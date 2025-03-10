package com.epf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.epf.Persistance.DatabaseConfig;

public class Main {
    public static void main(String[] args) {
        // Création du contexte Spring
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DatabaseConfig.class);

        // Récupération du bean JdbcTemplate
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        // Vérification de la connexion
        try {
            // Par exemple : on compte le nombre de lignes dans une table
            // (remplace "ma_table" par le nom d'une vraie table de ta BDD)
            Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM pvz.map", Integer.class);
            System.out.println("Connexion OK ! Nombre de lignes dans ma_table : " + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context.close();
        }
    }
}
