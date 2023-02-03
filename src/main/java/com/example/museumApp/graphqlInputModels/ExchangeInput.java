package com.example.museumApp.graphqlInputModels;

public class ExchangeInput {
    private String museumName;
    private String sculptureName;

    public String getMuseumName() {
        return museumName;
    }

    public void setMuseumName(String museumName) {
        this.museumName = museumName;
    }

    public String getSculptureName() {
        return sculptureName;
    }

    public void setSculptureName(String sculptureName) {
        this.sculptureName = sculptureName;
    }
}
