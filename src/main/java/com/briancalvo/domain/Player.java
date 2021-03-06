package com.briancalvo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Brian on 10/10/2016.
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @JsonIgnore
    private LocalDate date;
    private int points;
    private int assists;
    private int rebounds;
    private String position;
    @ManyToOne // un jugador sólo puede pertenecer a un equipo
    private Team team;

    /* Constructores */

    public Player(long id, String name, String surname, LocalDate date, int points, int assists, int rebounds, String position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.position = position;
    }

    public Player(){
    }

    /* Getters */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPoints() {
        return points;
    }

    public int getAssists() {
        return assists;
    }

    public int getRebounds() {
        return rebounds;
    }

    public String getPosition() { return position; }

    public Team getTeam() { return team; }

    /* Setters */

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
