package com.epf.Persistance;

import com.epf.Core.GameMap;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;

public class GameMapDaoImpl implements GameMapDao {

    private final JdbcTemplate jdbcTemplate;

    public GameMapDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<GameMap> gameMapRowMapper = (rs, rowNum) -> new GameMap(
            rs.getLong("id_map"),
            rs.getInt("ligne"),
            rs.getInt("colonne"),
            rs.getString("chemin_image")
    );

    @Override
    public long create(GameMap gameMap) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql,
                gameMap.getLigne(),
                gameMap.getColonne(),
                gameMap.getCheminImage());
    }

    @Override
    public GameMap findById(long id) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, gameMapRowMapper);
    }

    @Override
    public List<GameMap> findAll() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, gameMapRowMapper);
    }

    @Override
    public int update(GameMap gameMap) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        return jdbcTemplate.update(sql,
                gameMap.getLigne(),
                gameMap.getColonne(),
                gameMap.getCheminImage(),
                gameMap.getIdMap());
    }

    @Override
    public int delete(long id) {
        String sql = "DELETE FROM map WHERE id_map = ?";
        return jdbcTemplate.update(sql, id);
    }
}
