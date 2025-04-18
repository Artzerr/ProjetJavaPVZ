package com.epf;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.epf.Core.GameMap;
import com.epf.Core.Plant;
import com.epf.Core.Zombie;
import com.epf.Persistance.DatabaseConfig;
import com.epf.Persistance.GameMapDaoImpl;
import com.epf.Persistance.PlantDaoImpl;
import com.epf.Persistance.ZombieDaoImpl;

@ComponentScan(basePackages = {"com.epf.Core", "com.epf.Persistance"})
public class Main {
    private static void displayPlants(List<Plant> plants) {
        System.out.println("\n=== PLANTES ===");
        for (Plant plant : plants) {
            System.out.println("ID: " + plant.getIdPlante());
            System.out.println("Nom: " + plant.getNom());
            System.out.println("PV: " + plant.getPointDeVie());
            System.out.println("Coût: " + plant.getCout());
            System.out.println("Dégâts: " + plant.getDegatAttaque());
            System.out.println("Attaque/s: " + plant.getAttaqueParSeconde());
            System.out.println("Soleil/s: " + plant.getSoleilParSeconde());
            System.out.println("Effet: " + plant.getEffet());
            System.out.println("--------------------");
        }
    }

    private static void displayZombies(List<Zombie> zombies) {
        System.out.println("\n=== ZOMBIES ===");
        for (Zombie zombie : zombies) {
            System.out.println("ID: " + zombie.getIdZombie());
            System.out.println("Nom: " + zombie.getNom());
            System.out.println("PV: " + zombie.getPointDeVie());
            System.out.println("Attaque/s: " + zombie.getAttaqueParSeconde());
            System.out.println("Dégâts: " + zombie.getDegatAttaque());
            System.out.println("Vitesse: " + zombie.getVitesseDeDeplacement());
            System.out.println("id_map: " + zombie.getIdMap());
            System.out.println("--------------------");
        }
    }

    private static void displayMaps(List<GameMap> maps) {
        System.out.println("\n=== MAPS ===");
        for (GameMap map : maps) {
            System.out.println("ID: " + map.getIdMap());
            System.out.println("Lignes: " + map.getLigne());
            System.out.println("Colonnes: " + map.getColonne());
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(Main.class, DatabaseConfig.class)) {
            PlantDaoImpl daoPlant = context.getBean(PlantDaoImpl.class);
            ZombieDaoImpl daoZombie = context.getBean(ZombieDaoImpl.class);
            GameMapDaoImpl daoGameMap = context.getBean(GameMapDaoImpl.class);
                        
            // Récupération et affichage des données
            List<Plant> plants = daoPlant.findAll();
            List<GameMap> maps = daoGameMap.findAll();
            List<Zombie> zombies = daoZombie.findAll();
            //List<Zombie> zombiesFromMap = daoZombie.findByMapId(maps.get(0));
            
            System.out.println("\033c"); // Clear console

            displayPlants(plants);
            displayZombies(zombies);
            //displayZombies(zombiesFromMap);
            displayMaps(maps);
        }
    }
}