import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.nio.file.Files;
//import java.nio.file.Paths;

import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        assertEquals(true, schema.isValid(null));
        assertEquals(true, schema.isValid(""));

        assertEquals(false, schema.required().isValid(null));
        assertEquals(false, schema.isValid(""));
    }
    // TODO тест contains(), в т.ч. null
    @Test
    public void testContains() {
        var v = new Validator();
        var schema = v.string();

        assertEquals(true, schema.isValid(""));
        assertEquals(true, schema.isValid("this str is valid"));
        assertEquals(true, schema.contains("this").isValid("this str is valid"));
        assertEquals(false, schema.isValid("This str is not valid"));
        assertEquals(true, schema.contains("").isValid("This str is valid"));
        assertEquals(false, schema.contains("   ").isValid("this str is not valid"));
        assertEquals(false, schema.contains("this").isValid(null));
    }

        // TODO тест minLength(), в т.ч. отрицательный
    @Test
    public void testMinLength() {
        var v = new Validator();
        var schema = v.string();

        assertEquals(true, schema.minLength(3).isValid("str"));
        assertEquals(true, schema.isValid("string"));
        assertEquals(false, schema.isValid("st"));
        assertEquals(false, schema.isValid(null));
//        assertEquals(false, schema.minLength(-5).isValid("asdf"));
    }
}
