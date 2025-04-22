package com.epf.API;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlantDTOTest {
    @Test
    void testPlantDTOCreation() {
        PlantDTO plant = new PlantDTO();
        plant.setId_plante(1L);
        plant.setNom("Peashooter");
        plant.setPoint_de_vie(100);
        plant.setAttaque_par_seconde(1.0);
        plant.setDegat_attaque(20);
        plant.setCout(100);
        plant.setSoleil_par_seconde(0.0);
        plant.setEffet("None");
        plant.setChemin_image("peashooter.png");

        assertEquals(1L, plant.getId_plante());
        assertEquals("Peashooter", plant.getNom());
        assertEquals(100, plant.getPoint_de_vie());
        assertEquals(1.0, plant.getAttaque_par_seconde());
        assertEquals(20, plant.getDegat_attaque());
        assertEquals(100, plant.getCout());
        assertEquals(0.0, plant.getSoleil_par_seconde());
        assertEquals("None", plant.getEffet());
        assertEquals("peashooter.png", plant.getChemin_image());
    }

    @Test
    void testPlantDTOEquality() {
        PlantDTO plant1 = new PlantDTO();
        plant1.setId_plante(1L);
        plant1.setNom("Peashooter");
        plant1.setPoint_de_vie(100);
        plant1.setAttaque_par_seconde(1.0);
        plant1.setDegat_attaque(20);

        PlantDTO plant2 = new PlantDTO();
        plant2.setId_plante(1L);
        plant2.setNom("Peashooter");
        plant2.setPoint_de_vie(100);
        plant2.setAttaque_par_seconde(1.0);
        plant2.setDegat_attaque(20);

        assertEquals(plant1.getId_plante(), plant2.getId_plante());
        assertEquals(plant1.getNom(), plant2.getNom());
        assertEquals(plant1.getPoint_de_vie(), plant2.getPoint_de_vie());
        assertEquals(plant1.getAttaque_par_seconde(), plant2.getAttaque_par_seconde());
        assertEquals(plant1.getDegat_attaque(), plant2.getDegat_attaque());
    }
}
