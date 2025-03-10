package com.epf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.epf.Persistance.DatabaseConfig;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DatabaseConfig.class);

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        try {
            Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM pvz.map", Integer.class);
            System.out.println("Connexion OK ! Nombre de lignes dans ma_table : " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context.close();
        }
    }
}
