package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MapValidatorTest {
    @Test
    public void checkClass() {
        var v = new Validator();
        var schema = v.map();
        assertEquals(MapSchema.class, schema.getClass());
    }
    @Test
    public void checkRequired() {
        var v = new Validator();
        var schema = v.map();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new TreeMap<>()));
    }
    @Test
    public void checkSizeof() {
        var v = new Validator();
        var schema = v.map();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(new TreeMap<>()));

        var testMap = new HashMap<String, String>();
        testMap.put("key1", "val1");
        assertTrue(schema.isValid(testMap));

        schema.sizeof(2);

        assertFalse(schema.isValid(testMap));
        testMap.put("key2", "val2");
        assertTrue(schema.isValid(testMap));

        testMap.put("key3", "val3");
        assertFalse(schema.isValid(testMap));

    }
}
