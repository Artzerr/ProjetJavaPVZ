package com.epf.Core;

public class Plant {
    private long id_plante;
    private String nom;
    private int point_de_vie;
    private double attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private double soleil_par_seconde;
    private String effet;
    private String chemin_image;

    public Plant() {}

    public Plant(long id_plante, String nom, int point_de_vie, double attaque_par_seconde,
                 int degat_attaque, int cout, double soleil_par_seconde, String effet, String chemin_image) {
        this.id_plante = id_plante;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.cout = cout;
        this.soleil_par_seconde = soleil_par_seconde;
        this.effet = effet;
        this.chemin_image = chemin_image;
    }

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

    @Override
    public String toString() {
        return "Plant{" +
                "id_plante=" + id_plante +
                ", nom='" + nom + '\'' +
                ", point_de_vie=" + point_de_vie +
                ", attaque_par_seconde=" + attaque_par_seconde +
                ", degat_attaque=" + degat_attaque +
                ", cout=" + cout +
                ", soleil_par_seconde=" + soleil_par_seconde +
                ", effet='" + effet + '\'' +
                ", chemin_image='" + chemin_image + '\'' +
                '}';
    }
}
