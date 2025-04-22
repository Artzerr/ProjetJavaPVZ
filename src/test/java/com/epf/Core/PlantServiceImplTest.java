package com.epf.Core;

import com.epf.Persistance.PlantDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlantServiceImplTest {

    @Mock
    private PlantDao plantDao;

    private PlantService plantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        plantService = new PlantServiceImpl(plantDao);
    }

    @Test
    void testCreate() {
        Plant plant = new Plant(1L, "Test Plant", 100, 1.0, 10, 50, 25.0, "normal", "test.png");
        when(plantDao.create(plant)).thenReturn(1L);

        long result = plantService.create(plant);

        assertEquals(1L, result);
        verify(plantDao).create(plant);
    }

    @Test
    void testFindById() {
        Plant plant = new Plant(1L, "Test Plant", 100, 1.0, 10, 50, 25.0, "normal", "test.png");
        when(plantDao.findById(1L)).thenReturn(plant);

        Plant result = plantService.findById(1L);

        assertNotNull(result);
        assertEquals("Test Plant", result.getNom());
        verify(plantDao).findById(1L);
    }

    @Test
    void testFindAll() {
        List<Plant> plants = Arrays.asList(
            new Plant(1L, "Plant 1", 100, 1.0, 10, 50, 25.0, "normal", "test1.png"),
            new Plant(2L, "Plant 2", 150, 1.5, 15, 75, 0.0, "special", "test2.png")
        );
        when(plantDao.findAll()).thenReturn(plants);

        List<Plant> result = plantService.findAll();

        assertEquals(2, result.size());
        verify(plantDao).findAll();
    }

    @Test
    void testUpdate() {
        Plant plant = new Plant(1L, "Updated Plant", 120, 1.2, 12, 60, 30.0, "normal", "updated.png");
        when(plantDao.update(plant)).thenReturn(1);

        int result = plantService.update(plant);

        assertEquals(1, result);
        verify(plantDao).update(plant);
    }

    @Test
    void testDelete() {
        when(plantDao.delete(1L)).thenReturn(1);

        int result = plantService.delete(1L);

        assertEquals(1, result);
        verify(plantDao).delete(1L);
    }
}
