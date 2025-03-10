package com.epf.API;

public class ZombieDTO {
    private long idZombie;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private double vitesseDeDeplacement;
    private String cheminImage;
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
