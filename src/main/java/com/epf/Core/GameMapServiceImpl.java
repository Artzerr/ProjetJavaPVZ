package com.epf.Core;

import java.util.List;
import com.epf.Persistance.GameMapDao;

public class GameMapServiceImpl implements GameMapService {

    private final GameMapDao gameMapDao;

    public GameMapServiceImpl(GameMapDao gameMapDao) {
        this.gameMapDao = gameMapDao;
    }

    @Override
    public long create(GameMap gameMap) {
        return gameMapDao.create(gameMap);
    }

    @Override
    public GameMap findById(long id) {
        return gameMapDao.findById(id);
    }

    @Override
    public List<GameMap> findAll() {
        return gameMapDao.findAll();
    }

    @Override
    public int update(GameMap gameMap) {
        return gameMapDao.update(gameMap);
    }

    @Override
    public int delete(long id) {
        return gameMapDao.delete(id);
    }
}
