package com.epf.Core;

import java.util.List;

public interface GameMapService {
    long create(GameMap gameMap);
    GameMap findById(long id);
    List<GameMap> findAll();
    int update(GameMap gameMap);
    int delete(long id);
}
