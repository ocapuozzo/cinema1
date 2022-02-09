package org.greta94.cinema.model;

import java.util.ArrayList;
import java.util.List;

public class Film {
    private String titre;
    private Float note;
    private String afficheNom;
    private String resume;
    private Personne realisateur;
    private List<Role> acteurs = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public void addVote(boolean like){
        this.votes.add(new Vote(like, this));
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * retourne le pourcentage de like parmi les votes
     * @return
     */
    public Float getNote() {
        float nLike = 0;
        for (int i = 0; i < this.votes.size(); i++) {
            if (this.votes.get(i).isLike()) {
                nLike++;
            }
        }
        return (float) (nLike/this.votes.size() * 100);
    }

    //public void setNote(float note) {
    //    this.note = note;
    //}

    public String getAfficheNom() {
        return afficheNom;
    }

    public void setAfficheNom(String afficheNom) {
        this.afficheNom = afficheNom;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Personne getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Personne realisateur) {
        this.realisateur = realisateur;
    }

    public List<Role> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Role> acteurs) {
        this.acteurs = acteurs;
    }

    public void addActeur(Role role){
        this.acteurs.add(role);
    }
}
