package com.epf.API;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZombieDTO {
    @JsonProperty("id_zombie")
    private long idZombie;
    
    @JsonProperty("nom")
    private String nom;
    
    @JsonProperty("point_de_vie")
    private int pointDeVie;
    
    @JsonProperty("attaque_par_seconde")
    private double attaqueParSeconde;
    
    @JsonProperty("degat_attaque")
    private int degatAttaque;
    
    @JsonProperty("vitesse_de_deplacement")
    private double vitesseDeDeplacement;
    
    @JsonProperty("chemin_image")
    private String cheminImage;
    
    @JsonProperty("id_map")
    private long idMap;

    public ZombieDTO() {}

    public long getIdZombie() {
        return idZombie;
    }
    public void setIdZombie(long idZombie) {
        this.idZombie = idZombie;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getPointDeVie() {
        return pointDeVie;
    }
    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }
    public double getAttaqueParSeconde() {
        return attaqueParSeconde;
    }
    public void setAttaqueParSeconde(double attaqueParSeconde) {
        this.attaqueParSeconde = attaqueParSeconde;
    }
    public int getDegatAttaque() {
        return degatAttaque;
    }
    public void setDegatAttaque(int degatAttaque) {
        this.degatAttaque = degatAttaque;
    }
    public double getVitesseDeDeplacement() {
        return vitesseDeDeplacement;
    }
    public void setVitesseDeDeplacement(double vitesseDeDeplacement) {
        this.vitesseDeDeplacement = vitesseDeDeplacement;
    }
    public String getCheminImage() {
        return cheminImage;
    }
    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }
    public long getIdMap() {
        return idMap;
    }
    public void setIdMap(long idMap) {
        this.idMap = idMap;
    }
}
