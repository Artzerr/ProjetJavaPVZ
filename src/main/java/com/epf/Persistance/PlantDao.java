package com.epf.Persistance;

import com.epf.Core.Plant;
import java.util.List;

public interface PlantDao {
    long create(Plant plant);
    Plant findById(long id);
    List<Plant> findAll();
    int update(Plant plant);
    int delete(long id);
}