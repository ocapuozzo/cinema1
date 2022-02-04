package org.greta94.cinema.model;

public class Role {
    private String name;
    private Personne acteur;
    private Film film;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Personne getActeur() {
        return acteur;
    }

    public void setActeur(Personne acteur) {
        this.acteur = acteur;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
