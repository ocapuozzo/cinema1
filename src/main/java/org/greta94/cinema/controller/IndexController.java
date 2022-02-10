package org.greta94.cinema.controller;

import org.greta94.cinema.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

  @GetMapping(value = {"/", "/index.html"})
  public String index() {
    return "index/index";
  }

  @GetMapping(value = {"/login"})
  public String login() {
    return "index/login";
  }

  @PostMapping(value = {"/login"})
  public String loginPost(HttpServletRequest request) {
    String username = request.getParameter("username");
    User u = new User(username);
    request.getSession().setAttribute("user", u);
    // j'applique le pattern PRG (Post Redirect Get)
    return "redirect:/films";
  }

}
