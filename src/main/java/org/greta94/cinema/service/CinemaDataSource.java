package org.greta94.cinema.service;

import org.greta94.cinema.model.Film;
import org.greta94.cinema.model.Role;
import org.greta94.cinema.model.User;
import org.springframework.stereotype.Service;
import org.greta94.cinema.model.Personne;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CinemaDataSource {
    private List<Film> films = new ArrayList<>();
    private List<Personne> personnes = new ArrayList<>();

    public CinemaDataSource(){
        Film film;
        Personne personne;
        Role role;
        // Le juge et l'assassin
        film = new Film();
        film.setTitre("Le juge et l'assassin");
        film.setResume("Fin du XIXème, Joseph Bouvier est révoqué de l'armée à cause de ses excès de violence. Suite à ce renvoi, l'homme s'attaque à sa fiancée et tente de se suicider, en vain. Après un séjour en hôpital psychiatrique, Joseph ressort de cet endroit encore plus enragé et décide de se venger sur toutes les personnes qui croiseront son chemin en Ardèche. Non loin de là, le juge Rousseau, passionné par l'affaire, prend part à l'investigation et se met sur les traces de Bouvier. Bien décidé à le mettre sous les verrous, c'est le début d'une chasse à l'homme...");
       // film.setNote(3.8f);
        film.setAfficheNom("f0001.jpg");
        Random rand = new Random();
        User toto = new User("toto");
        for (int i = 0; i < 100; i++) {
            film.addVote(rand.nextBoolean(), toto);
        }
        films.add(film);
        personne = new Personne();
        personne.setNom("Noiret");
        personne.setPrenom("Philippe");
        personne.setAnneeNaiscance(1930);
        personne.setPhoto("p0001.jpg");
        personnes.add(personne);
        role = new Role();
        role.setActeur(personne);
        role.setFilm(film);
        role.setName("Le juge Rousseau");
        film.addActeur(role);
        personne.addRole(role);
        personne = new Personne();
        personne.setNom("Galabru");
        personne.setPrenom("Michel");
        personne.setAnneeNaiscance(1922);
        personne.setPhoto("p0002.jpg");
        personnes.add(personne);
        role = new Role();
        role.setActeur(personne);
        role.setFilm(film);
        role.setName("Joseph Bouvier");
        film.addActeur(role);
        personne.addRole(role);
        personne = new Personne();
        personne.setNom("Huppert");
        personne.setPrenom("Isabelle");
        personne.setAnneeNaiscance(1953);
        personne.setPhoto("p0003.jpg");
        personnes.add(personne);
        role = new Role();
        role.setActeur(personne);
        role.setFilm(film);
        role.setName("Rose");
        film.addActeur(role);
        personne.addRole(role);
        personne = new Personne();
        personne.setNom("Tavernier");
        personne.setPrenom("Bertrand");
        personne.setAnneeNaiscance(1941);
        personne.setPhoto("p0110.jpg");
        personnes.add(personne);
        film.setRealisateur(personne);
        personne.addFilm(film);

        // La guerre des étoiles
        film = new Film();
        film.setTitre("La guerre des étoiles");
        film.setResume("Il y a bien longtemps, dans une galaxie très lointaine... La guerre civile fait rage entre l'Empire galactique et l'Alliance rebelle. Capturée par les troupes de choc de l'Empereur menées par le sombre et impitoyable Dark Vador, la princesse Leia Organa dissimule les plans de l'Etoile Noire, une station spatiale invulnérable, à son droïde R2-D2 avec pour mission de les remettre au Jedi Obi-Wan Kenobi. Accompagné de son fidèle compagnon, le droïde de protocole C-3PO, R2-D2 s'échoue sur la planète Tatooine et termine sa quête chez le jeune Luke Skywalker. Rêvant de devenir pilote mais confiné aux travaux de la ferme, ce dernier se lance à la recherche de ce mystérieux Obi-Wan Kenobi, devenu ermite au coeur des montagnes désertiques de Tatooine...");
        //film.setNote(4.4f);
        film.setAfficheNom("f0002.jpg");
        for (int i = 0; i < 500; i++) {
            film.addVote(rand.nextBoolean(), toto);
        }
        films.add(film);
        personne = new Personne();
        personne.setNom("Hamill");
        personne.setPrenom("Mark");
        personne.setAnneeNaiscance(1951);
        personne.setPhoto("p0004.jpg");
        personnes.add(personne);
        role = new Role();
        role.setActeur(personne);
        role.setFilm(film);
        role.setName("Luke Skywalker");
        film.addActeur(role);
        personne.addRole(role);
        personne = new Personne();
        personne.setNom("Ford");
        personne.setPrenom("Harrison");
        personne.setAnneeNaiscance(1942);
        personne.setPhoto("p0005.jpg");
        personnes.add(personne);
        role = new Role();
        role.setActeur(personne);
        role.setFilm(film);
        role.setName("Ian Solo");
        film.addActeur(role);
        personne.addRole(role);
        personne = new Personne();
        personne.setNom("Fisher");
        personne.setPrenom("Carrie");
        personne.setAnneeNaiscance(1956);
        personne.setPhoto("p0006.jpg");
        personnes.add(personne);
        role = new Role();
        role.setActeur(personne);
        role.setFilm(film);
        role.setName("Princesse Leia Organa");
        film.addActeur(role);
        personne.addRole(role);
        personne = new Personne();
        personne.setNom("Lucas");
        personne.setPrenom("Georges");
        personne.setAnneeNaiscance(1944);
        personne.setPhoto("p0045.jpg");
        personnes.add(personne);
        film.setRealisateur(personne);
        personne.addFilm(film);
    }

    public List<Film> getFilms() {
        return this.films;
    }

    public List<Personne> getPersonnes() {
        return this.personnes;
    }

    public boolean canVote(Film film, User user) {
        return !film.getVotes().stream().anyMatch(vote -> vote.getUser().getUserName().equals(user.getUserName()));
    }
}
