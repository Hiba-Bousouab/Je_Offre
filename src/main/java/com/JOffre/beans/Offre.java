package com.JOffre.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Offre implements Serializable {

    private Long offerId;
    private String titre;
    private Timestamp date;
    private String description;
    private City city;
    private Category category;

    public Offre(){
        super();
    }

    public Offre(Long offerId, String titre, Timestamp date, String description, City city, Category category) {
        this.offerId = offerId;
        this.titre = titre;
        this.date = date;
        this.description = description;
        this.city = city;
        this.category = category;
    }



    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }




}
