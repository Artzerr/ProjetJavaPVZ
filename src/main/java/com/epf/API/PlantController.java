package com.epf.API;

import com.epf.Core.Plant;
import com.epf.Core.PlantService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plants")
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
        dto.setIdPlante(plant.getIdPlante());
        dto.setNom(plant.getNom());
        dto.setPointDeVie(plant.getPointDeVie());
        dto.setAttaqueParSeconde(plant.getAttaqueParSeconde());
        dto.setDegatAttaque(plant.getDegatAttaque());
        dto.setCout(plant.getCout());
        dto.setSoleilParSeconde(plant.getSoleilParSeconde());
        dto.setEffet(plant.getEffet());
        dto.setCheminImage(plant.getCheminImage());
        return dto;
    }

    // Méthode de conversion DTO -> Entity
    private Plant convertToEntity(PlantDTO dto) {
        Plant plant = new Plant();
        plant.setNom(dto.getNom());
        plant.setPointDeVie(dto.getPointDeVie());
        plant.setAttaqueParSeconde(dto.getAttaqueParSeconde());
        plant.setDegatAttaque(dto.getDegatAttaque());
        plant.setCout(dto.getCout());
        plant.setSoleilParSeconde(dto.getSoleilParSeconde());
        plant.setEffet(dto.getEffet());
        plant.setCheminImage(dto.getCheminImage());
        return plant;
    }
}
