package com.JOffre.Model;

import java.io.Serializable;

public class User implements Serializable {

    private String idUser;
    private String firstName;
    private String lastName;
    private Long[] offres;

    public Long[] getOffres() {
        return offres;
    }

    public void setOffres(Long[] offres) {
        this.offres = offres;
    }

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
