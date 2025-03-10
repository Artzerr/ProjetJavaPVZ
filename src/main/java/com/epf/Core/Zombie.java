package com.epf.Core;

public class Zombie {
    private long idZombie;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private double vitesseDeDeplacement;
    private String cheminImage;
    private long idMap;

    public Zombie() {}

    public Zombie(long idZombie, String nom, int pointDeVie, double attaqueParSeconde,
                  int degatAttaque, double vitesseDeDeplacement, String cheminImage, long idMap) {
        this.idZombie = idZombie;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.vitesseDeDeplacement = vitesseDeDeplacement;
        this.cheminImage = cheminImage;
        this.idMap = idMap;
    }

    // Getters et setters
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

    @Override
    public String toString() {
        return "Zombie{" +
                "idZombie=" + idZombie +
                ", nom='" + nom + '\'' +
                ", pointDeVie=" + pointDeVie +
                ", attaqueParSeconde=" + attaqueParSeconde +
                ", degatAttaque=" + degatAttaque +
                ", vitesseDeDeplacement=" + vitesseDeDeplacement +
                ", cheminImage='" + cheminImage + '\'' +
                ", idMap=" + idMap +
                '}';
    }
}