package bestoftheyear.id.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bestoftheyear.id.best_of_the_year.models.Movie;
import bestoftheyear.id.best_of_the_year.models.Songs;

@Controller
@RequestMapping("/")

public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    private List<Movie> getBestMovies() {

        Movie m1 = new Movie(1, "Tre uomini e una gamba");
        Movie m2 = new Movie(2, "La leggenda di Al Jhon e Jack");
        Movie m3 = new Movie(3, "Chiedimi se sono felice");

        List<Movie> movie = new ArrayList<>();

        movie.add(m1);
        movie.add(m2);
        movie.add(m3);

        return movie;
    }

    @GetMapping("/movie")
    public String BestMovies(Model model) {
        List<Movie> movie = getBestMovies();
        model.addAttribute("movie", movie);
        return "Movie";
    }

    private List<Songs> getBestSongs() {
        Songs s1 = new Songs(1, "Giudizi universali");
        Songs s2 = new Songs(2, "Replay");
        Songs s3 = new Songs(3, "Spaccacuore");

        List<Songs> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);

        return songs;
    }

    @GetMapping("/songs")
    public String BestSongs(Model model) {
        List<Songs> songs = getBestSongs();
        model.addAttribute("songs", songs);
        return "Songs";
    }

    @GetMapping("/movies/id")
    public String getMoviesByID(@RequestParam(name = "id") int id, Model model) {
        List<Movie> movie = getBestMovies();
        for (Movie m : movie) {
            if(m.getId() == id){
               model.addAttribute("movie", m);
               break;
            }            
        }
        return "MovieByID";
    }
    
    @GetMapping("/songs/id")
    public String getSongsByID(@RequestParam(name = "id") int id, Model model) {
        List<Songs> songs = getBestSongs();
        for (Songs s : songs) {
            if(s.getId() == id){
               model.addAttribute("songs", s);
               break;
            }            
        }
        return "SongsByID";
    }

}