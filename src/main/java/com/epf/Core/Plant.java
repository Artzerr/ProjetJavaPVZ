package com.epf.Core;

public class Plant {
    private long idPlante;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private int cout;
    private double soleilParSeconde;
    private String effet;
    private String cheminImage;

    // Constructeur par défaut
    public Plant() {}

    // Constructeur avec paramètres
    public Plant(long idPlante, String nom, int pointDeVie, double attaqueParSeconde,
                 int degatAttaque, int cout, double soleilParSeconde, String effet, String cheminImage) {
        this.idPlante = idPlante;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.cout = cout;
        this.soleilParSeconde = soleilParSeconde;
        this.effet = effet;
        this.cheminImage = cheminImage;
    }

    // Getters et setters
    public long getIdPlante() {
        return idPlante;
    }
    public void setIdPlante(long idPlante) {
        this.idPlante = idPlante;
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
    public int getCout() {
        return cout;
    }
    public void setCout(int cout) {
        this.cout = cout;
    }
    public double getSoleilParSeconde() {
        return soleilParSeconde;
    }
    public void setSoleilParSeconde(double soleilParSeconde) {
        this.soleilParSeconde = soleilParSeconde;
    }
    public String getEffet() {
        return effet;
    }
    public void setEffet(String effet) {
        this.effet = effet;
    }
    public String getCheminImage() {
        return cheminImage;
    }
    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "idPlante=" + idPlante +
                ", nom='" + nom + '\'' +
                ", pointDeVie=" + pointDeVie +
                ", attaqueParSeconde=" + attaqueParSeconde +
                ", degatAttaque=" + degatAttaque +
                ", cout=" + cout +
                ", soleilParSeconde=" + soleilParSeconde +
                ", effet='" + effet + '\'' +
                ", cheminImage='" + cheminImage + '\'' +
                '}';
    }
}
