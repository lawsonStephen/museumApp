package com.example.museumApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "SCULPTURE")
public class Sculpture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private int sculpture_year;

    private double sculpture_price;

    @Column(name="IMAGE_PATH")
    private String imagePath;

    private String link;
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

    public int getSculpture_year() {
        return sculpture_year;
    }

    public void setSculpture_year(int sculpture_year) {
        this.sculpture_year = sculpture_year;
    }

    public double getSculpture_price() {
        return sculpture_price;
    }

    public void setSculpture_price(double sculpture_price) {
        this.sculpture_price = sculpture_price;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
