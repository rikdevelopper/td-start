package com.supinfo.league.journee.infrastructure;

import com.supinfo.league.journee.domain.Journee;
import com.supinfo.league.journee.domain.JourneeDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class JdbcJourneeDao implements JourneeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcJourneeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String nextId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void creerJournee(Journee journee) {
        String query = "INSERT INTO journees (id, numero, journee_date, saison_id) values (?,?,?,?)";
        this.jdbcTemplate.update(query, journee.getId(), journee.getNumero(), journee.getDate(), journee.getSaison().getId());
    }
}
