package com.epf.Core;

import java.util.List;
import com.epf.Persistance.PlantDao;

public class PlantServiceImpl implements PlantService {

    private final PlantDao plantDao;

    public PlantServiceImpl(PlantDao plantDao) {
        this.plantDao = plantDao;
    }

    @Override
    public long create(Plant plant) {
        return plantDao.create(plant);
    }

    @Override
    public Plant findById(long id) {
        return plantDao.findById(id);
    }

    @Override
    public List<Plant> findAll() {
        return plantDao.findAll();
    }

    @Override
    public int update(Plant plant) {
        return plantDao.update(plant);
    }

    @Override
    public int delete(long id) {
        return plantDao.delete(id);
    }
}
