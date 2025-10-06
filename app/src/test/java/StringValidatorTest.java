//import java.nio.file.Files;
//import java.nio.file.Paths;

import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public final class StringValidatorTest {
//    @BeforeEach
//    public void setupValidator() {
//        var v = new Validator();
//    }
    @Test
    public void checkClass() {
        var v = new Validator();
        var schema = v.string();
        assertEquals(StringSchema.class, schema.getClass());
    }
    // TODO тест required()
    @Test
    public void testRequired() {
        var v = new Validator();
        var schema = v.string();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));

        assertFalse(schema.required().isValid(null));
        assertFalse(schema.isValid(""));
    }
    // TODO тест contains(), в т.ч. null
    @Test
    public void testContains() {
        var v = new Validator();
        var schema = v.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid("this str is valid"));
        assertTrue(schema.contains("this").isValid("this str is valid"));
//        assertFalse(schema.isValid("This str is not valid"));
        assertTrue(schema.contains("").isValid("This str is valid"));
        assertFalse(schema.contains(null).isValid("This str is not valid"));
        assertFalse(schema.contains("   ").isValid("this str is not valid"));
//        assertFalse(schema.contains("this").isValid(null));
    }
    // TODO комплексный тест

        // TODO тест minLength(), в т.ч. отрицательный
    @Test
    public void testMinLength() {
        var v = new Validator();
        var schema = v.string();

        assertTrue(schema.minLength(3).isValid("str"));
        assertTrue(schema.isValid("string"));
        assertFalse(schema.isValid("st"));
        assertFalse(schema.isValid(null));
//        assertFalse(schema.minLength(-5).isValid("asdf"));
    }
}
