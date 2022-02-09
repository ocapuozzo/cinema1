package org.greta94.cinema.controller;

import org.greta94.cinema.model.Film;
import org.greta94.cinema.service.CinemaDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FilmController {
  private CinemaDataSource cinemaService;

  public FilmController(CinemaDataSource cinemaService) {
    this.cinemaService = cinemaService;
  }

  @GetMapping("/films")
  public String index(Model model) {
    List<Film> films;
    films = cinemaService.getFilms();
    model.addAttribute("films", films);
    return "film/index";
  }
//
//  @GetMapping("/film")
//  public String detail(Model model) {
//    List<Film> films;
//    films = cinemaService.getFilms();
//    model.addAttribute("films", films);
//    return "film/index";
//  }

}
