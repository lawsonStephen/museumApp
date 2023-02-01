package com.example.museumApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiArtPainting
{
    private String title;
    private String completitionYear;
    private String artistName;

    private String artistUrl;

    private String image;

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompletitionYear() {
        return completitionYear;
    }

    public void setCompletitionYear(String completitionYear) {
        this.completitionYear = completitionYear;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArtistUrl() {
        return artistUrl;
    }

    public void setArtistUrl(String artistUrl) {
        this.artistUrl = artistUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WikiArtPainting that = (WikiArtPainting) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
