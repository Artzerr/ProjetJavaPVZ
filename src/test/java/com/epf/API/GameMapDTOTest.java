package com.epf.API;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameMapDTOTest {
    @Test
    void testGameMapDTOCreation() {
        GameMapDTO map = new GameMapDTO();
        map.setIdMap(1L);
        map.setLigne(5);
        map.setColonne(9);
        map.setCheminImage("map1.png");

        assertEquals(1L, map.getIdMap());
        assertEquals(5, map.getLigne());
        assertEquals(9, map.getColonne());
        assertEquals("map1.png", map.getCheminImage());
    }

    @Test
    void testGameMapDTOEquality() {
        GameMapDTO map1 = new GameMapDTO();
        map1.setIdMap(1L);
        map1.setLigne(5);
        map1.setColonne(9);
        map1.setCheminImage("map1.png");

        GameMapDTO map2 = new GameMapDTO();
        map2.setIdMap(1L);
        map2.setLigne(5);
        map2.setColonne(9);
        map2.setCheminImage("map1.png");

        assertEquals(map1.getIdMap(), map2.getIdMap());
        assertEquals(map1.getLigne(), map2.getLigne());
        assertEquals(map1.getColonne(), map2.getColonne());
        assertEquals(map1.getCheminImage(), map2.getCheminImage());
    }
}
