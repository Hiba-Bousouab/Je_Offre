package com.JOffre.Model;

import java.io.Serializable;

public class User implements Serializable {

    private String idUser;
    private String firstName;
    private String lastName;
    private Offre[] offers;
    private Offre[] favorites;

    public Offre[] getFavorites() { return favorites; }

    public void setFavorites(Offre[] favorites) { this.favorites = favorites; }

    public Offre[] getOffres() {
        return offers;
    }

    public void setOffres(Offre[] offers) { this.offers = offers; }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
