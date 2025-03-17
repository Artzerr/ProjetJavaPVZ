package com.epf.Persistance;

import com.epf.Core.Plant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantDaoImpl implements PlantDao {

    private final JdbcTemplate jdbcTemplate;

    public PlantDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Plant> plantRowMapper = (rs, rowNum) -> new Plant(
            rs.getLong("id_plante"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getInt("cout"),
            rs.getDouble("soleil_par_seconde"),
            rs.getString("effet"),
            rs.getString("chemin_image")
    );

    @Override
    public long create(Plant plant) {
        String sql = "INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                plant.getNom(),
                plant.getPointDeVie(),
                plant.getAttaqueParSeconde(),
                plant.getDegatAttaque(),
                plant.getCout(),
                plant.getSoleilParSeconde(),
                plant.getEffet(),
                plant.getCheminImage());
    }

    @Override
    public Plant findById(long id) {
        String sql = "SELECT * FROM plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, plantRowMapper);
    }

    @Override
    public List<Plant> findAll() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, plantRowMapper);
    }

    @Override
    public int update(Plant plant) {
        String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        return jdbcTemplate.update(sql,
                plant.getNom(),
                plant.getPointDeVie(),
                plant.getAttaqueParSeconde(),
                plant.getDegatAttaque(),
                plant.getCout(),
                plant.getSoleilParSeconde(),
                plant.getEffet(),
                plant.getCheminImage(),
                plant.getIdPlante());
    }

    @Override
    public int delete(long id) {
        String sql = "DELETE FROM plante WHERE id_plante = ?";
        return jdbcTemplate.update(sql, id);
    }
}
