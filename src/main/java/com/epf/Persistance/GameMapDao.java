package com.epf.Persistance;

import com.epf.Core.GameMap;
import java.util.List;

public interface GameMapDao {
    long create(GameMap gameMap);
    GameMap findById(long id);
    List<GameMap> findAll();
    int update(GameMap gameMap);
    int delete(long id);
}
