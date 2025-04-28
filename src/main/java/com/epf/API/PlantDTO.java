package com.epf.API;

import jakarta.validation.constraints.*;

public class PlantDTO {
    private long id_plante;
    
    @NotBlank(message = "Le nom ne peut pas être vide")
    @Size(max = 255, message = "Le nom ne peut pas dépasser 255 caractères")
    private String nom;
    
    @Min(value = 0, message = "Les points de vie doivent être positifs")
    private int point_de_vie;
    
    @Min(value = 0, message = "L'attaque par seconde doit être positive")
    @Digits(integer = 3, fraction = 2, message = "L'attaque par seconde doit avoir au maximum 3 chiffres et 2 décimales")
    private double attaque_par_seconde;
    
    @Min(value = 0, message = "Les dégâts d'attaque doivent être positifs")
    private int degat_attaque;
    
    @Min(value = 0, message = "Le coût doit être positif")
    private int cout;
    
    @Min(value = 0, message = "Le soleil par seconde doit être positif")
    @Digits(integer = 3, fraction = 2, message = "Le soleil par seconde doit avoir au maximum 3 chiffres et 2 décimales")
    private double soleil_par_seconde;
    
    @Pattern(regexp = "normal|slow low|slow medium|slow stop", message = "L'effet doit être l'une des valeurs suivantes: normal, slow low, slow medium, slow stop")
    private String effet;
    
    @Size(max = 255, message = "Le chemin d'image ne peut pas dépasser 255 caractères")
    private String chemin_image;

    public PlantDTO() {}

    public long getId_plante() {
        return id_plante;
    }

    public void setId_plante(long id_plante) {
        this.id_plante = id_plante;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public double getAttaque_par_seconde() {
        return attaque_par_seconde;
    }

    public void setAttaque_par_seconde(double attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public int getDegat_attaque() {
        return degat_attaque;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public double getSoleil_par_seconde() {
        return soleil_par_seconde;
    }

    public void setSoleil_par_seconde(double soleil_par_seconde) {
        this.soleil_par_seconde = soleil_par_seconde;
    }

    public String getEffet() {
        return effet;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
}
