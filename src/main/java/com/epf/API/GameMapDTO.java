package com.epf.API;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameMapDTO {
    @JsonProperty("id_map")
    private long idMap;
    
    @JsonProperty("ligne")
    private int ligne;
    
    @JsonProperty("colonne")
    private int colonne;
    
    @JsonProperty("chemin_image")
    private String cheminImage;

    public GameMapDTO() {}

    public long getIdMap() {
        return idMap;
    }

    public void setIdMap(long idMap) {
        this.idMap = idMap;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }
}
