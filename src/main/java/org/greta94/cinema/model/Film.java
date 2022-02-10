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

    // addVote est une méthode d'instance, donc elle est toujours
    // appelée à partir d'une référence à un objet (this)
    public void addVote(boolean like, User user){
        Vote unVote = new Vote(like, this, user);
        this.votes.add(unVote);
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
        float nLike = this.votes.stream().filter(vote -> vote.isLike()).count();
        return (float) (nLike/this.votes.size() * 100);

/*
        LocalDateTime before = LocalDateTime.now();
        for (int i = 0; i < this.votes.size(); i++) {
            Vote vote = this.votes.get(i);
            if (vote.isLike()) {
                nLike++;
            }
        }
        LocalDateTime after = LocalDateTime.now();
        long temps= ChronoUnit.MILLIS.between(before, after);
        System.out.println("Temps de calcul en millisecondes boucle for :" + temps);


        for ( Vote vote: this.votes) {
            if (vote.isLike()) {
                nLike++;
            }
        }

        before = LocalDateTime.now();
        nLike= 0;
        Iterator<Vote> iterator = this.votes.iterator();
        while (iterator.hasNext()) {
            Vote vote = iterator.next();
            if (vote.isLike()) {
                nLike++;
            }
        }
        after = LocalDateTime.now();
        temps= ChronoUnit.MILLIS.between(before, after);
        System.out.println("Temps de calcul en millisecondes iterator :" + temps);
*/
        // structure de controle du flux d'exception : SEQ, ALTERNATIVE et BOUCLE
//        before = LocalDateTime.now();
//        nLike = this.votes.stream().filter(vote -> vote.isLike()).count();
//        after = LocalDateTime.now();
//        temps= ChronoUnit.MILLIS.between(before, after);
//        System.out.println("Temps de calcul en millisecondes stream :" + temps);

//        return (float) (nLike/this.votes.size() * 100);
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
