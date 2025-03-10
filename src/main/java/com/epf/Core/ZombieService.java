package com.epf.Core;

import java.util.List;

public interface ZombieService {
    long create(Zombie zombie);
    Zombie findById(long id);
    List<Zombie> findAll();
    int update(Zombie zombie);
    int delete(long id);
    List<Zombie> findByMapId(long mapId);
}
