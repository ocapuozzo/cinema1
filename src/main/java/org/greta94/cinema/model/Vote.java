package org.greta94.cinema.model;

public class Vote {
  private boolean like;
  private Film film;
  private User user;

  public Vote(boolean like, Film film, User user) {
    this.like = like;
    this.film = film;
    this.user = user;
  }

  public boolean isLike() {
    return like;
  }

  public void setLike(boolean like) {
    this.like = like;
  }

  public Film getFilm() {
    return film;
  }

  public void setFilm(Film film) {
    this.film = film;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
