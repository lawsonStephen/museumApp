package com.example.museumApp.model;

import javax.persistence.*;

@Entity
@Table(name="PAINTING")
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int painting_year;
    private double painting_price;

    private String imagePath;
    @ManyToOne
    @JoinColumn(name="ARTIST_ID")
    private Artist artist;
    @ManyToOne
    @JoinColumn(name="MUSEUM_ID")
    private Museum museum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPainting_year() {
        return painting_year;
    }

    public void setPainting_year(int painting_year) {
        this.painting_year = painting_year;
    }

    public double getPainting_price() {
        return painting_price;
    }

    public void setPainting_price(double painting_price) {
        this.painting_price = painting_price;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
