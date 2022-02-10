package org.greta94.cinema.controller;

import org.greta94.cinema.model.Film;
import org.greta94.cinema.model.User;
import org.greta94.cinema.service.CinemaDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FilmController {
  private CinemaDataSource cinemaService;

  public FilmController(CinemaDataSource cinemaService) {
    this.cinemaService = cinemaService;
  }

  @GetMapping("/films")
  public String index(Model model) {
    List<Film> films = cinemaService.getFilms();
    model.addAttribute("films", films);
    return "film/index";
  }

  @GetMapping("/film/{index}")
  public String detail(@PathVariable int index, Model model) {
    // TODO tester si l'index est recevable
    Film film = cinemaService.getFilms().get(index);
    model.addAttribute("film", film);
    return "film/detail";
  }

  @GetMapping("/film/like/{index}")
  public String doLike(@PathVariable int index,
                       @RequestParam boolean like,
                       Model model,
                       HttpServletRequest request) {

    // TODO tester si l'index est recevable
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");

    if (user == null) {
      return "redirect:/login";
    }

    // ok, il y a un utilisateur
    Film film = cinemaService.getFilms().get(index);
    if (cinemaService.canVote(film, user)) {
      film.addVote(like, user);
    }
    return "redirect:/films";
  }

}
