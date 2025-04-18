package com.epf.API;

import com.epf.Core.GameMap;
import com.epf.Core.GameMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

//import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GameMapControllerTest {

    private MockMvc mockMvc;
    private GameMapService gameMapService;

    @BeforeEach
    void setup() {
        gameMapService = Mockito.mock(GameMapService.class);
        GameMapController gameMapController = new GameMapController(gameMapService);
        mockMvc = MockMvcBuilders.standaloneSetup(gameMapController).build();
    }

    @Test
    void testGetAllMaps() throws Exception {
        GameMap map1 = new GameMap(1, 5, 9, "images/map/gazon.png");
        GameMap map2 = new GameMap(2, 6, 8, "images/map/gazon.png");

        when(gameMapService.findAll()).thenReturn(Arrays.asList(map1, map2));

        mockMvc.perform(get("/maps").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idMap").value(1))
                .andExpect(jsonPath("$[0].ligne").value(5))
                .andExpect(jsonPath("$[1].idMap").value(2))
                .andExpect(jsonPath("$[1].colonne").value(8));
    }

    @Test
    void testGetMapById() throws Exception {
        GameMap map = new GameMap(1, 5, 9, "images/map/gazon.png");
        when(gameMapService.findById(1)).thenReturn(map);

        mockMvc.perform(get("/maps/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idMap").value(1))
                .andExpect(jsonPath("$.ligne").value(5))
                .andExpect(jsonPath("$.colonne").value(9))
                .andExpect(jsonPath("$.cheminImage").value("images/map/gazon.png"));
    }

    @Test
    void testCreateMap() throws Exception {
        // On suppose que le service renvoie un ID (par exemple 1L) après création
        when(gameMapService.create(Mockito.any(GameMap.class))).thenReturn(1L);

        String jsonContent = "{ \"ligne\": 5, \"colonne\": 9, \"cheminImage\": \"images/map/gazon.png\" }";

        mockMvc.perform(post("/maps")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ligne").value(5))
                .andExpect(jsonPath("$.colonne").value(9))
                .andExpect(jsonPath("$.cheminImage").value("images/map/gazon.png"));
    }

    @Test
    void testUpdateMap() throws Exception {
        String updatedJson = "{ \"ligne\": 6, \"colonne\": 8, \"cheminImage\": \"images/map/updated.png\" }";

        mockMvc.perform(put("/maps/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ligne").value(6))
                .andExpect(jsonPath("$.colonne").value(8))
                .andExpect(jsonPath("$.cheminImage").value("images/map/updated.png"));

        verify(gameMapService).update(Mockito.any(GameMap.class));
    }

    @Test
    void testDeleteMap() throws Exception {
        mockMvc.perform(delete("/maps/1"))
                .andExpect(status().isOk());

        verify(gameMapService).delete(1);
    }
}
