package com.epf.API;

import com.epf.Core.Zombie;
import com.epf.Core.ZombieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ZombieControllerTest {

    private MockMvc mockMvc;
    private ZombieService zombieService;

    @BeforeEach
    void setup() {
        // On crée un mock du service pour isoler le test du contrôleur
        zombieService = Mockito.mock(ZombieService.class);

        // On instancie le contrôleur en lui passant le mock
        com.epf.API.ZombieController zombieController = new com.epf.API.ZombieController(zombieService);

        // On construit le MockMvc qui simulera les requêtes HTTP
        mockMvc = MockMvcBuilders.standaloneSetup(zombieController).build();
    }

    @Test
    void testGetAllZombies() throws Exception {
        // Données factices
        Zombie zombie1 = new Zombie(1L, "Zombie de base", 100, 0.8, 10, 0.5, "images/zombie/zombie.png", 1);
        Zombie zombie2 = new Zombie(2L, "Zombie Cone", 200, 0.8, 10, 0.45, "images/zombie/conehead.png", 1);

        // On dit au mock de renvoyer cette liste lorsqu'on appelle findAll()
        when(zombieService.findAll()).thenReturn(Arrays.asList(zombie1, zombie2));

        // On simule un appel GET /zombies
        mockMvc.perform(get("/zombies")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id_zombie").value(1))
                .andExpect(jsonPath("$[0].nom").value("Zombie de base"))
                .andExpect(jsonPath("$[1].id_zombie").value(2))
                .andExpect(jsonPath("$[1].nom").value("Zombie Cone"));
    }

    @Test
    void testGetZombieById() throws Exception {
        Zombie zombie = new Zombie(1L, "Zombie de base", 100, 0.8, 10, 0.5, "images/zombie/zombie.png", 1);
        when(zombieService.findById(1L)).thenReturn(zombie);

        // On simule un appel GET /zombies/1
        mockMvc.perform(get("/zombies/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_zombie").value(1))
                .andExpect(jsonPath("$.nom").value("Zombie de base"));
    }

    @Test
    void testCreateZombie() throws Exception {
        when(zombieService.create(any(Zombie.class))).thenReturn(1L);

        String newZombieJson = """
                {
                    "nom": "Zombie Runner",
                    "point_de_vie": 80,
                    "attaque_par_seconde": 1.0,
                    "degat_attaque": 8,
                    "vitesse_de_deplacement": 0.7,
                    "chemin_image": "images/zombie/runner.png",
                    "id_map": 2
                }
                """;

        // On simule un appel POST /zombies
        mockMvc.perform(post("/zombies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newZombieJson))
                .andExpect(status().isOk())
                // On vérifie que le JSON renvoyé contient le nom "Zombie Runner"
                .andExpect(jsonPath("$.nom").value("Zombie Runner"));
    }

    @Test
    void testUpdateZombie() throws Exception {
        String updatedZombieJson = """
                {
                    "nom": "Zombie Updated",
                    "point_de_vie": 120,
                    "attaque_par_seconde": 1.0,
                    "degat_attaque": 10,
                    "vitesse_de_deplacement": 0.6,
                    "chemin_image": "images/zombie/updated.png",
                    "id_map": 2
                }
                """;

        mockMvc.perform(put("/zombies/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedZombieJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Zombie Updated"))
                .andExpect(jsonPath("$.point_de_vie").value(120));

        // On peut vérifier que la méthode update du service est bien appelée
        verify(zombieService).update(any(Zombie.class));
    }

    @Test
    void testDeleteZombie() throws Exception {
        // On simule un appel DELETE /zombies/1
        mockMvc.perform(delete("/zombies/1"))
                .andExpect(status().isOk());

        // Vérification que la méthode delete du service est bien appelée
        verify(zombieService).delete(1L);
    }
}
