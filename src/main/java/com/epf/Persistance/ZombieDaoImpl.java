package com.epf.Persistance;

import com.epf.Core.Zombie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZombieDaoImpl implements ZombieDao {

    private final JdbcTemplate jdbcTemplate;

    public ZombieDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper pour convertir une ligne en objet Zombie
    private final RowMapper<Zombie> zombieRowMapper = (rs, rowNum) -> new Zombie(
            rs.getLong("id_zombie"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getDouble("vitesse_de_deplacement"),
            rs.getString("chemin_image"),
            rs.getLong("id_map")
    );

    @Override
    public long create(Zombie zombie) {
        String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                zombie.getNom(),
                zombie.getPointDeVie(),
                zombie.getAttaqueParSeconde(),
                zombie.getDegatAttaque(),
                zombie.getVitesseDeDeplacement(),
                zombie.getCheminImage(),
                zombie.getIdMap());
    }

    @Override
    public Zombie findById(long id) {
        String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, zombieRowMapper);
    }

    @Override
    public List<Zombie> findAll() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, zombieRowMapper);
    }

    @Override
    public int update(Zombie zombie) {
        String sql = "UPDATE zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        return jdbcTemplate.update(sql,
                zombie.getNom(),
                zombie.getPointDeVie(),
                zombie.getAttaqueParSeconde(),
                zombie.getDegatAttaque(),
                zombie.getVitesseDeDeplacement(),
                zombie.getCheminImage(),
                zombie.getIdMap(),
                zombie.getIdZombie());
    }

    @Override
    public int delete(long id) {
        String sql = "DELETE FROM zombie WHERE id_zombie = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Zombie> findByMapId(long mapId) {
        String sql = "SELECT * FROM zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new Object[]{mapId}, zombieRowMapper);
    }
}