package com.epf.Persistance;

import com.epf.Core.GameMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameMapDaoImplTest {

    private GameMapDaoImpl gameMapDao;
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        gameMapDao = new GameMapDaoImpl(jdbcTemplate);
    }

    @Test
    void testCreate() {
        GameMap map = new GameMap(1, 5, 9, "images/map/gazon.png");
        when(jdbcTemplate.update(
                eq("INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)"),
                eq(5),
                eq(9),
                eq("images/map/gazon.png")
        )).thenReturn(1);

        long result = gameMapDao.create(map);
        assertEquals(1, result);
    }

    @Test
    void testFindById() {
        GameMap expectedMap = new GameMap(1, 5, 9, "images/map/gazon.png");
        when(jdbcTemplate.queryForObject(
                eq("SELECT * FROM map WHERE id_map = ?"),
                any(Object[].class),
                any(RowMapper.class)
        )).thenReturn(expectedMap);

        GameMap result = gameMapDao.findById(1);
        assertEquals(expectedMap.getIdMap(), result.getIdMap());
        assertEquals(expectedMap.getLigne(), result.getLigne());
        assertEquals(expectedMap.getColonne(), result.getColonne());
        assertEquals(expectedMap.getCheminImage(), result.getCheminImage());
    }

    @Test
    void testFindAll() {
        List<GameMap> expectedMaps = Arrays.asList(
                new GameMap(1, 5, 9, "images/map/gazon.png"),
                new GameMap(2, 6, 8, "images/map/desert.png")
        );

        when(jdbcTemplate.query(
                eq("SELECT * FROM map"),
                any(RowMapper.class)
        )).thenReturn(expectedMaps);

        List<GameMap> result = gameMapDao.findAll();
        assertEquals(expectedMaps.size(), result.size());
        assertEquals(expectedMaps.get(0).getIdMap(), result.get(0).getIdMap());
        assertEquals(expectedMaps.get(1).getIdMap(), result.get(1).getIdMap());
    }

    @Test
    void testUpdate() {
        GameMap map = new GameMap(1, 5, 9, "images/map/gazon.png");
        when(jdbcTemplate.update(
                eq("UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?"),
                eq(5),
                eq(9),
                eq("images/map/gazon.png"),
                eq(1L)
        )).thenReturn(1);

        int result = gameMapDao.update(map);
        assertEquals(1, result);
    }

    @Test
    void testDelete() {
        when(jdbcTemplate.update(
                eq("DELETE FROM map WHERE id_map = ?"),
                eq(1L)
        )).thenReturn(1);

        int result = gameMapDao.delete(1);
        assertEquals(1, result);
    }
}
