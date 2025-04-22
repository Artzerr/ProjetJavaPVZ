package com.epf.Core;

import com.epf.Persistance.ZombieDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ZombieServiceImplTest {

    @Mock
    private ZombieDao zombieDao;

    private ZombieService zombieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        zombieService = new ZombieServiceImpl(zombieDao);
    }

    @Test
    void testCreate() {
        Zombie zombie = new Zombie(1L, "Test Zombie", 100, 1.0, 10, 0.5, "test.png", 1L);
        when(zombieDao.create(zombie)).thenReturn(1L);

        long result = zombieService.create(zombie);

        assertEquals(1L, result);
        verify(zombieDao).create(zombie);
    }

    @Test
    void testFindById() {
        Zombie zombie = new Zombie(1L, "Test Zombie", 100, 1.0, 10, 0.5, "test.png", 1L);
        when(zombieDao.findById(1L)).thenReturn(zombie);

        Zombie result = zombieService.findById(1L);

        assertNotNull(result);
        assertEquals("Test Zombie", result.getNom());
        verify(zombieDao).findById(1L);
    }

    @Test
    void testFindAll() {
        List<Zombie> zombies = Arrays.asList(
            new Zombie(1L, "Zombie 1", 100, 1.0, 10, 0.5, "test1.png", 1L),
            new Zombie(2L, "Zombie 2", 150, 1.5, 15, 0.6, "test2.png", 1L)
        );
        when(zombieDao.findAll()).thenReturn(zombies);

        List<Zombie> result = zombieService.findAll();

        assertEquals(2, result.size());
        verify(zombieDao).findAll();
    }

    @Test
    void testUpdate() {
        Zombie zombie = new Zombie(1L, "Updated Zombie", 120, 1.2, 12, 0.55, "updated.png", 1L);
        when(zombieDao.update(zombie)).thenReturn(1);

        int result = zombieService.update(zombie);

        assertEquals(1, result);
        verify(zombieDao).update(zombie);
    }

    @Test
    void testDelete() {
        when(zombieDao.delete(1L)).thenReturn(1);

        int result = zombieService.delete(1L);

        assertEquals(1, result);
        verify(zombieDao).delete(1L);
    }

    @Test
    void testFindByMapId() {
        List<Zombie> zombies = Arrays.asList(
            new Zombie(1L, "Map Zombie 1", 100, 1.0, 10, 0.5, "test1.png", 1L),
            new Zombie(2L, "Map Zombie 2", 150, 1.5, 15, 0.6, "test2.png", 1L)
        );
        when(zombieDao.findByMapId(1L)).thenReturn(zombies);

        List<Zombie> result = zombieService.findByMapId(1L);

        assertEquals(2, result.size());
        verify(zombieDao).findByMapId(1L);
    }
}
