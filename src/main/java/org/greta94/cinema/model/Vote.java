package org.greta94.cinema.model;

public class Vote {
  private boolean like;
  private Film film;

  public Vote(boolean like, Film film) {
    this.like = like;
    this.film = film;
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
}
