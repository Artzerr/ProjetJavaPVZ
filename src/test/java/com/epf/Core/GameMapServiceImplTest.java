package com.epf.Core;

import com.epf.Persistance.GameMapDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameMapServiceImplTest {

    @Mock
    private GameMapDao gameMapDao;

    private GameMapService gameMapService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameMapService = new GameMapServiceImpl(gameMapDao);
    }

    @Test
    void testCreate() {
        GameMap map = new GameMap(1L, 5, 9, "test.png");
        when(gameMapDao.create(map)).thenReturn(1L);

        long result = gameMapService.create(map);

        assertEquals(1L, result);
        verify(gameMapDao).create(map);
    }

    @Test
    void testFindById() {
        GameMap map = new GameMap(1L, 5, 9, "test.png");
        when(gameMapDao.findById(1L)).thenReturn(map);

        GameMap result = gameMapService.findById(1L);

        assertNotNull(result);
        assertEquals(5, result.getLigne());
        assertEquals(9, result.getColonne());
        verify(gameMapDao).findById(1L);
    }

    @Test
    void testFindAll() {
        List<GameMap> maps = Arrays.asList(
            new GameMap(1L, 5, 9, "test1.png"),
            new GameMap(2L, 6, 8, "test2.png")
        );
        when(gameMapDao.findAll()).thenReturn(maps);

        List<GameMap> result = gameMapService.findAll();

        assertEquals(2, result.size());
        verify(gameMapDao).findAll();
    }

    @Test
    void testUpdate() {
        GameMap map = new GameMap(1L, 6, 10, "updated.png");
        when(gameMapDao.update(map)).thenReturn(1);

        int result = gameMapService.update(map);

        assertEquals(1, result);
        verify(gameMapDao).update(map);
    }

    @Test
    void testDelete() {
        when(gameMapDao.delete(1L)).thenReturn(1);

        int result = gameMapService.delete(1L);

        assertEquals(1, result);
        verify(gameMapDao).delete(1L);
    }
}
