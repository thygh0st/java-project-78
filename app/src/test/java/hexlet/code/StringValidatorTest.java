package hexlet.code;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.nio.file.Files;
//import java.nio.file.Paths;

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
    // TODO тест contains(), в т.ч. null
    // TODO тест minLength(), в т.ч. отрицательный
}
