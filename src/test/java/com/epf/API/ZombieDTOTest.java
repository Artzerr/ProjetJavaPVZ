package com.epf.API;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ZombieDTOTest {
    @Test
    void testZombieDTOCreation() {
        ZombieDTO zombie = new ZombieDTO();
        zombie.setIdZombie(1L);
        zombie.setNom("Basic Zombie");
        zombie.setPointDeVie(150);
        zombie.setAttaqueParSeconde(1.0);
        zombie.setDegatAttaque(10);
        zombie.setVitesseDeDeplacement(1.0);
        zombie.setCheminImage("zombie.png");
        zombie.setIdMap(1L);

        assertEquals(1L, zombie.getIdZombie());
        assertEquals("Basic Zombie", zombie.getNom());
        assertEquals(150, zombie.getPointDeVie());
        assertEquals(1.0, zombie.getAttaqueParSeconde());
        assertEquals(10, zombie.getDegatAttaque());
        assertEquals(1.0, zombie.getVitesseDeDeplacement());
        assertEquals("zombie.png", zombie.getCheminImage());
        assertEquals(1L, zombie.getIdMap());
    }

    @Test
    void testZombieDTOEquality() {
        ZombieDTO zombie1 = new ZombieDTO();
        zombie1.setIdZombie(1L);
        zombie1.setNom("Basic Zombie");
        zombie1.setPointDeVie(150);
        zombie1.setAttaqueParSeconde(1.0);
        zombie1.setDegatAttaque(10);

        ZombieDTO zombie2 = new ZombieDTO();
        zombie2.setIdZombie(1L);
        zombie2.setNom("Basic Zombie");
        zombie2.setPointDeVie(150);
        zombie2.setAttaqueParSeconde(1.0);
        zombie2.setDegatAttaque(10);

        assertEquals(zombie1.getIdZombie(), zombie2.getIdZombie());
        assertEquals(zombie1.getNom(), zombie2.getNom());
        assertEquals(zombie1.getPointDeVie(), zombie2.getPointDeVie());
        assertEquals(zombie1.getAttaqueParSeconde(), zombie2.getAttaqueParSeconde());
        assertEquals(zombie1.getDegatAttaque(), zombie2.getDegatAttaque());
    }
}
