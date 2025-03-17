package com.epf.Core;

import java.util.List;
import com.epf.Persistance.ZombieDao;
import org.springframework.stereotype.Service;

@Service
public class ZombieServiceImpl implements ZombieService {

    private final ZombieDao zombieDao;

    public ZombieServiceImpl(ZombieDao zombieDao) {
        this.zombieDao = zombieDao;
    }

    @Override
    public long create(Zombie zombie) {
        return zombieDao.create(zombie);
    }

    @Override
    public Zombie findById(long id) {
        return zombieDao.findById(id);
    }

    @Override
    public List<Zombie> findAll() {
        return zombieDao.findAll();
    }

    @Override
    public int update(Zombie zombie) {
        return zombieDao.update(zombie);
    }

    @Override
    public int delete(long id) {
        return zombieDao.delete(id);
    }

    @Override
    public List<Zombie> findByMapId(long mapId) {
        return zombieDao.findByMapId(mapId);
    }
}
