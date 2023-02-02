package com.example.museumApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="PAINTING")
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    private int painting_year;
    private double painting_price;

    @Column(name="IMAGE_PATH")
    private String imagePath;

    @Column(name="LINK")
    private String link;

    @Column(name="DESCRIPTION")
    @Lob
    private String description;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
