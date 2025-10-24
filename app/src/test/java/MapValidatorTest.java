import hexlet.code.Validator;
import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;
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
    // TODO тест shape()
    @Test
    public void checkShape() {
        var v = new Validator();
        var schema = v.map();

        Map<String, BaseSchema<String>> schmString = new HashMap<>();

        schmString.put("firstName", v.string().required());
        schmString.put("lastName", v.string().required().minLength(2));

        schema.shape(schmString);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(schema.isValid(human3));

//        Map<String, BaseSchema<Integer>> schmNumber = new HashMap<>();
//        schmNumber.put("num1", v.number().required());
//        schmNumber.put("num2", v.number().required().range(3, 6));
//
//        schema.shape(schmNumber);

    }
}
