package com.epf.API;

import com.epf.Core.Plant;
import com.epf.Core.PlantService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plantes")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    // Récupérer tous les plants
    @GetMapping
    public List<PlantDTO> getAllPlants() {
        List<Plant> plants = plantService.findAll();
        return plants.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PlantDTO getPlantById(@PathVariable long id) {
        Plant plant = plantService.findById(id);
        return convertToDTO(plant);
    }

    @PostMapping
    public PlantDTO createPlant(@RequestBody PlantDTO plantDTO) {
        Plant plant = convertToEntity(plantDTO);
        plantService.create(plant);
        return plantDTO;
    }

    @PutMapping("/{id}")
    public PlantDTO updatePlant(@PathVariable long id, @RequestBody PlantDTO plantDTO) {
        Plant plant = convertToEntity(plantDTO);
        plant.setIdPlante(id);
        plantService.update(plant);
        return plantDTO;
    }

    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable long id) {
        plantService.delete(id);
    }

    // Méthode de conversion Entity -> DTO
    private PlantDTO convertToDTO(Plant plant) {
        PlantDTO dto = new PlantDTO();
        dto.setId_plante(plant.getIdPlante());
        dto.setNom(plant.getNom());
        dto.setPoint_de_vie(plant.getPointDeVie());
        dto.setAttaque_par_seconde(plant.getAttaqueParSeconde());
        dto.setDegat_attaque(plant.getDegatAttaque());
        dto.setCout(plant.getCout());
        dto.setSoleil_par_seconde(plant.getSoleilParSeconde());
        dto.setEffet(plant.getEffet());
        dto.setChemin_image(plant.getCheminImage());
        return dto;
    }

    // Méthode de conversion DTO -> Entity
    private Plant convertToEntity(PlantDTO dto) {
        Plant plant = new Plant();
        plant.setIdPlante(dto.getId_plante());
        plant.setNom(dto.getNom());
        plant.setPointDeVie(dto.getPoint_de_vie());
        plant.setAttaqueParSeconde(dto.getAttaque_par_seconde());
        plant.setDegatAttaque(dto.getDegat_attaque());
        plant.setCout(dto.getCout());
        plant.setSoleilParSeconde(dto.getSoleil_par_seconde());
        plant.setEffet(dto.getEffet());
        plant.setCheminImage(dto.getChemin_image());
        return plant;
    }
}
