package com.epf.API;

import com.epf.Core.GameMap;
import com.epf.Core.GameMapService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/maps")
public class GameMapController {

    private final GameMapService gameMapService;

    public GameMapController(GameMapService gameMapService) {
        this.gameMapService = gameMapService;
    }

    // Récupérer toutes les maps
    @GetMapping
    public List<GameMapDTO> getAllMaps() {
        List<GameMap> maps = gameMapService.findAll();
        return maps.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Récupérer une map par son id
    @GetMapping("/{id}")
    public GameMapDTO getMapById(@PathVariable long id) {
        GameMap map = gameMapService.findById(id);
        return convertToDTO(map);
    }

    // Créer une nouvelle map
    @PostMapping
    public GameMapDTO createMap(@RequestBody GameMapDTO gameMapDTO) {
        GameMap map = convertToEntity(gameMapDTO);
        gameMapService.create(map);
        return gameMapDTO;
    }

    // Mettre à jour une map existante
    @PutMapping("/{id}")
    public GameMapDTO updateMap(@PathVariable long id, @RequestBody GameMapDTO gameMapDTO) {
        GameMap map = convertToEntity(gameMapDTO);
        map.setIdMap(id);
        gameMapService.update(map);
        return gameMapDTO;
    }

    // Supprimer une map
    @DeleteMapping("/{id}")
    public void deleteMap(@PathVariable long id) {
        gameMapService.delete(id);
    }

    // Méthode de conversion Entity -> DTO
    private GameMapDTO convertToDTO(GameMap map) {
        GameMapDTO dto = new GameMapDTO();
        dto.setIdMap(map.getIdMap());
        dto.setLigne(map.getLigne());
        dto.setColonne(map.getColonne());
        dto.setCheminImage(map.getCheminImage());
        return dto;
    }

    // Méthode de conversion DTO -> Entity
    private GameMap convertToEntity(GameMapDTO dto) {
        GameMap map = new GameMap();
        map.setLigne(dto.getLigne());
        map.setColonne(dto.getColonne());
        map.setCheminImage(dto.getCheminImage());
        return map;
    }
}
