package com.epf.API;

import com.epf.Core.Zombie;
import com.epf.Core.ZombieService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zombies")
public class ZombieController {

    private final ZombieService zombieService;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    // Récupérer tous les zombies
    @GetMapping
    public List<ZombieDTO> getAllZombies() {
        List<Zombie> zombies = zombieService.findAll();
        return zombies.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Récupérer un zombie par son id
    @GetMapping("/{id}")
    public ZombieDTO getZombieById(@PathVariable long id) {
        Zombie zombie = zombieService.findById(id);
        return convertToDTO(zombie);
    }

    // Créer un nouveau zombie
    @PostMapping
    public ZombieDTO createZombie(@RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = convertToEntity(zombieDTO);
        zombieService.create(zombie);
        return zombieDTO;
    }

    // Mettre à jour un zombie existant
    @PutMapping("/{id}")
    public ZombieDTO updateZombie(@PathVariable long id, @RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = convertToEntity(zombieDTO);
        zombie.setIdZombie(id);
        zombieService.update(zombie);
        return zombieDTO;
    }

    // Supprimer un zombie
    @DeleteMapping("/{id}")
    public void deleteZombie(@PathVariable long id) {
        zombieService.delete(id);
    }

    // Méthode de conversion Entity -> DTO
    private ZombieDTO convertToDTO(Zombie zombie) {
        ZombieDTO dto = new ZombieDTO();
        dto.setIdZombie(zombie.getIdZombie());
        dto.setNom(zombie.getNom());
        dto.setPointDeVie(zombie.getPointDeVie());
        dto.setAttaqueParSeconde(zombie.getAttaqueParSeconde());
        dto.setDegatAttaque(zombie.getDegatAttaque());
        dto.setVitesseDeDeplacement(zombie.getVitesseDeDeplacement());
        dto.setCheminImage(zombie.getCheminImage());
        dto.setIdMap(zombie.getIdMap());
        return dto;
    }

    // Méthode de conversion DTO -> Entity
    private Zombie convertToEntity(ZombieDTO dto) {
        Zombie zombie = new Zombie();
        zombie.setNom(dto.getNom());
        zombie.setPointDeVie(dto.getPointDeVie());
        zombie.setAttaqueParSeconde(dto.getAttaqueParSeconde());
        zombie.setDegatAttaque(dto.getDegatAttaque());
        zombie.setVitesseDeDeplacement(dto.getVitesseDeDeplacement());
        zombie.setCheminImage(dto.getCheminImage());
        zombie.setIdMap(dto.getIdMap());
        return zombie;
    }
}
