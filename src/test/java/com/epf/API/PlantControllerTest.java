package com.epf.API;

import com.epf.Core.Plant;
import com.epf.Core.PlantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PlantControllerTest {

    private MockMvc mockMvc;
    private PlantService plantService;

    @BeforeEach
    void setup() {
        plantService = Mockito.mock(PlantService.class);
        PlantController plantController = new PlantController(plantService);
        mockMvc = MockMvcBuilders.standaloneSetup(plantController).build();
    }

    @Test
    void testGetAllPlants() throws Exception {
        Plant plant1 = new Plant(1, "Tournesol", 100, 0.0, 0, 50, 25.0, "normal", "images/plante/tournesol.png");
        Plant plant2 = new Plant(2, "Pois Tireur", 150, 1.5, 20, 100, 0.0, "normal", "images/plante/poistireur.png");

        when(plantService.findAll()).thenReturn(Arrays.asList(plant1, plant2));

        mockMvc.perform(get("/plantes").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id_plante").value(1))
                .andExpect(jsonPath("$[0].nom").value("Tournesol"))
                .andExpect(jsonPath("$[1].id_plante").value(2))
                .andExpect(jsonPath("$[1].nom").value("Pois Tireur"));
    }

    @Test
    void testGetPlantById() throws Exception {
        Plant plant = new Plant(1, "Tournesol", 100, 0.0, 0, 50, 25.0, "normal", "images/plante/tournesol.png");
        when(plantService.findById(1)).thenReturn(plant);

        mockMvc.perform(get("/plantes/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_plante").value(1))
                .andExpect(jsonPath("$.nom").value("Tournesol"))
                .andExpect(jsonPath("$.point_de_vie").value(100))
                .andExpect(jsonPath("$.chemin_image").value("images/plante/tournesol.png"));
    }

    @Test
    void testCreatePlant() throws Exception {
        when(plantService.create(Mockito.any(Plant.class))).thenReturn(1L);

        String jsonContent = """
                {
                    "nom": "Tournesol",
                    "point_de_vie": 100,
                    "attaque_par_seconde": 0.0,
                    "degat_attaque": 0,
                    "cout": 50,
                    "soleil_par_seconde": 25.0,
                    "effet": "normal",
                    "chemin_image": "images/plante/tournesol.png"
                }""";

        mockMvc.perform(post("/plantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Tournesol"))
                .andExpect(jsonPath("$.point_de_vie").value(100));
    }

    @Test
    void testUpdatePlant() throws Exception {
        String updatedJson = """
                {
                    "nom": "Tournesol Updated",
                    "point_de_vie": 110,
                    "attaque_par_seconde": 0.0,
                    "degat_attaque": 0,
                    "cout": 50,
                    "soleil_par_seconde": 25.0,
                    "effet": "normal",
                    "chemin_image": "images/plante/tournesol.png"
                }""";

        mockMvc.perform(put("/plantes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Tournesol Updated"))
                .andExpect(jsonPath("$.point_de_vie").value(110));

        verify(plantService).update(Mockito.any(Plant.class));
    }

    @Test
    void testDeletePlant() throws Exception {
        mockMvc.perform(delete("/plantes/1"))
                .andExpect(status().isOk());

        verify(plantService).delete(1);
    }
}