package com.epf.API;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlantDTO {
    @JsonProperty("id_plante")
    private long id_plante;
    
    @JsonProperty("nom")
    private String nom;
    
    @JsonProperty("point_de_vie")
    private int point_de_vie;
    
    @JsonProperty("attaque_par_seconde")
    private double attaque_par_seconde;
    
    @JsonProperty("degat_attaque")
    private int degat_attaque;
    
    @JsonProperty("cout")
    private int cout;
    
    @JsonProperty("soleil_par_seconde")
    private double soleil_par_seconde;
    
    @JsonProperty("effet")
    private String effet;
    
    @JsonProperty("chemin_image")
    private String chemin_image;

    public PlantDTO() {}

    public long getIdPlante() {
        return id_plante;
    }

    public void setIdPlante(long id_plante) {
        this.id_plante = id_plante;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointDeVie() {
        return point_de_vie;
    }

    public void setPointDeVie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public double getAttaqueParSeconde() {
        return attaque_par_seconde;
    }

    public void setAttaqueParSeconde(double attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public int getDegatAttaque() {
        return degat_attaque;
    }

    public void setDegatAttaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public double getSoleilParSeconde() {
        return soleil_par_seconde;
    }

    public void setSoleilParSeconde(double soleil_par_seconde) {
        this.soleil_par_seconde = soleil_par_seconde;
    }

    public String getEffet() {
        return effet;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public String getCheminImage() {
        return chemin_image;
    }

    public void setCheminImage(String chemin_image) {
        this.chemin_image = chemin_image;
    }
}
