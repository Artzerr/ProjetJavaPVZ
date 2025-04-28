package com.epf.API;

import jakarta.validation.constraints.*;

public class MapDTO {
    private long id_map;
    
    @Min(value = 0, message = "Le nombre de lignes doit être positif")
    private int ligne;
    
    @Min(value = 0, message = "Le nombre de colonnes doit être positif")
    private int colonne;
    
    @Size(max = 255, message = "Le chemin d'image ne peut pas dépasser 255 caractères")
    private String chemin_image;

    // Getters and setters
    public long getId_map() { return id_map; }
    public void setId_map(long id_map) { this.id_map = id_map; }
    
    public int getLigne() { return ligne; }
    public void setLigne(int ligne) { this.ligne = ligne; }
    
    public int getColonne() { return colonne; }
    public void setColonne(int colonne) { this.colonne = colonne; }
    
    public String getChemin_image() { return chemin_image; }
    public void setChemin_image(String chemin_image) { this.chemin_image = chemin_image; }
}
