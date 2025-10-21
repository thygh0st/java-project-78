package hexlet.code;

import hexlet.code.schemas.NumberSchema;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NumberValidatorTest {
    @Test
    public void checkClass() {
        var v = new Validator();
        var schema = v.number();
        assertEquals(NumberSchema.class, schema.getClass());
    }

    @Test
    public void checkRequired() {
        var v = new Validator();
        var schema = v.number();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(2));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
    }

    @Test
    public void checkPositive() {
        var v = new Validator();
        var schema = v.number();

        assertTrue(schema.isValid(10));
        assertTrue(schema.isValid(-5));

        assertTrue(schema.positive().isValid(null)); // в примере null - positive
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(-5));
    }

    @Test
    public void checkRange() {
        var v = new Validator();
        var schema = v.number();

        assertTrue(schema.isValid(10));
        assertTrue(schema.isValid(-5));
        assertTrue(schema.isValid(null));

        schema.range(-5, 5);

        assertFalse(schema.isValid(10));
        assertTrue(schema.isValid(3));
        assertTrue(schema.isValid(-5));
        assertTrue(schema.isValid(null));
    }

    @Test
    public void testComplex() {
        // TODO как range взаимодействует с positive?
        var v = new Validator();
        var schema = v.number();

        assertTrue(schema.isValid(10));
        assertTrue(schema.isValid(-5));
        assertTrue(schema.isValid(null));

        assertFalse(schema.required().isValid(null));
        assertFalse(schema.positive().isValid(-5));
        assertFalse(schema.isValid(null)); // накопили required
        assertTrue(schema.isValid(10));
        assertFalse(schema.range(-10, 3).isValid(-5)); // накоплен positive
        assertTrue(schema.isValid(2));
        assertFalse(schema.range(0, 1).isValid(2));
    }
}
