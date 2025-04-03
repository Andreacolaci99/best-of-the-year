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
    public String greeting(@RequestParam(name = "name", required=false, defaultValue = "creator") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    private List<Movie> getBestMovies() {

        Movie m1 = new Movie(1, "Tre uomini e una gamba");
        Movie m2 = new Movie(2, "La leggenda di Al Jhon e Jack");
        Movie m3 = new Movie(3, "Chiedimi se sono felice");
        Movie m4 = new Movie(4, "Tu la conosci Claudia ?");
        Movie m5 = new Movie(5, "Odio l'estate");

        List<Movie> movie = new ArrayList<>();

        movie.add(m1);
        movie.add(m2);
        movie.add(m3);
        movie.add(m4);
        movie.add(m5);

        return movie;
    }

    @GetMapping("/greeting/movie")
    public String BestMovies(Model model) {
        List<Movie> movie = getBestMovies();
        model.addAttribute("movie", movie);
        return "Movie";
    }

    private List<Songs> getBestSongs() {

        Songs s1 = new Songs(1, "Pasta Fasule");
        Songs s2 = new Songs(2, "Giudizi universali");
        Songs s3 = new Songs(3, "Replay");
        Songs s4 = new Songs(4, "Spaccacuore");
        Songs s5 = new Songs(5, "I'm your man");

        List<Songs> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        songs.add(s4);
        songs.add(s5);

        return songs;
    }

    @GetMapping("/greeting/songs")
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