package com.supinfo.league.saison.infrastructure;

import com.supinfo.league.saison.domain.Saison;
import com.supinfo.league.saison.domain.SaisonDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class JdbcSaisonDao implements SaisonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSaisonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String nextId(){
        return UUID.randomUUID().toString();
    }

    @Override
    public Saison findById(String id) {
        String query = "Select * from saisons where id = ?";
        return this.jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new Saison(rs.getString("id"), rs.getString("libelle")), id);
    }

    @Override
    public void creerSaison(Saison saison) {
        String query = "INSERT INTO saisons (id, libelle) VALUES (?,?)";
        this.jdbcTemplate.update(query, saison.getId(), saison.getLibelle());
    }

    @Override
    public boolean exists(String libelle) {
        String query = "SELECT count(*) from saisons where libelle = ?";
        int count = this.jdbcTemplate.queryForObject(query, Integer.class, libelle);
        return count > 0;
    }
}
