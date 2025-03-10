package com.epf.Persistance;

import com.epf.Core.Zombie;
import java.util.List;

public interface ZombieDao {
    long create(Zombie zombie);
    Zombie findById(long id);
    List<Zombie> findAll();
    int update(Zombie zombie);
    int delete(long id);

    // Récupérer tous les zombies associés à une map donnée (via l'id_map)
    List<Zombie> findByMapId(long mapId);
}
