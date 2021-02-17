package com.JOffre.Model;

public class OffreModel {
    private String titre ;
    private int date;
    private String photo;
    private String description;
    private String ville;
    private boolean exist;

    public OffreModel(){
        super();
    }

    public OffreModel(String titre, int date, String photo, String description, String ville, boolean exist) {
        this.titre = titre;
        this.date = date;
        this.photo = photo;
        this.description = description;
        this.ville = ville;
        this.exist = exist;
    }


    public String getTitre() {
        return titre;
    }

    public int getDate() {
        return date;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public String getVille() {
        return ville;
    }

    public boolean isExist() {
        return exist;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
