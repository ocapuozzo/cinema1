package org.greta94.cinema.model;

import java.util.ArrayList;
import java.util.List;

public class Personne {
    private String nom;
    private String prenom;
    private Integer anneeNaiscance;
    private String photo;
    private List<Film> filmsRealises = new ArrayList<>();
    private List<Role> roles = new ArrayList<>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAnneeNaiscance() {
        return anneeNaiscance;
    }

    public void setAnneeNaiscance(Integer anneeNaiscance) {
        this.anneeNaiscance = anneeNaiscance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Film> getFilmsRealises() {
        return filmsRealises;
    }

    public void setFilmsRealises(List<Film> filmsRealises) {
        this.filmsRealises = filmsRealises;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addFilm(Film film){
        this.filmsRealises.add(film);
    }

    public void addRole(Role role){
        this.roles.add(role);
    }
}
