package com.epf.Core;

public class GameMap {
    private long idMap;
    private int ligne;
    private int colonne;
    private String cheminImage;

    // Constructeur par défaut
    public GameMap() {}

    // Constructeur avec paramètres
    public GameMap(long idMap, int ligne, int colonne, String cheminImage) {
        this.idMap = idMap;
        this.ligne = ligne;
        this.colonne = colonne;
        this.cheminImage = cheminImage;
    }

    // Getters et setters
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

    @Override
    public String toString() {
        return "GameMap{" +
                "idMap=" + idMap +
                ", ligne=" + ligne +
                ", colonne=" + colonne +
                ", cheminImage='" + cheminImage + '\'' +
                '}';
    }
}
