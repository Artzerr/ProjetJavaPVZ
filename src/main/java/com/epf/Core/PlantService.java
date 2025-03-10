package com.epf.Core;

import java.util.List;

public interface PlantService {
    long create(Plant plant);
    Plant findById(long id);
    List<Plant> findAll();
    int update(Plant plant);
    int delete(long id);
}
