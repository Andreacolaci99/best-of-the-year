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
   
    @GetMapping("/movies")
    public String getBestMovies(Model model) {

        Movie m1 = new Movie(1, "Tre uomini e una gamba");
        Movie m2 = new Movie(2, "La leggenda di Al Jhon e Jack");
        Movie m3 = new Movie(3, "Chiedimi se sono felice");
    
        List<Movie> film = new ArrayList<>();
        film.add(m1);
        film.add(m2);
        film.add(m3);

        model.addAttribute("ListaFilm", film);

        return "Movie";
    }

    @GetMapping("/songs")
    public String getBestSongs(Model model){

        Songs s1 = new Songs(1, "Giudizi universali");
        Songs s2 = new Songs(2, "Replay");
        Songs s3 = new Songs(3, "Spaccacuore");
    
        List<Songs> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);

        model.addAttribute("ListaCanzoni", songs);

        return "Songs";
    }

}