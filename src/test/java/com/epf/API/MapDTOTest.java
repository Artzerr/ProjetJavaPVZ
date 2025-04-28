package com.epf.API;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDTOTest {
    private static Validator validator;

    @BeforeAll
    public static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidMapDTO() {
        MapDTO map = new MapDTO();
        map.setId_map(1L);
        map.setLigne(5);
        map.setColonne(9);
        map.setChemin_image("background.png");

        var violations = validator.validate(map);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testInvalidMapDTO() {
        MapDTO map = new MapDTO();
        map.setId_map(1L);
        map.setLigne(-5);  // invalid: negative rows
        map.setColonne(-9); // invalid: negative columns
        map.setChemin_image("a".repeat(256)); // invalid: too long

        var violations = validator.validate(map);
        assertEquals(3, violations.size());
    }
}
