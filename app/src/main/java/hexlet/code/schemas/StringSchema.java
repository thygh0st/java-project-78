package hexlet.code.schemas;

import java.util.HashMap;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema() {
        predicates = new HashMap<>(); // вынести в "конструктор" базового класса, раз уж разделяем?
    }

    public StringSchema required() {
        addFilter("required", (str) -> ((str != null) && !str.isEmpty()));
        return this;
    }
    public StringSchema minLength(int length) {
        addFilter("minlength", (str) -> ((str != null) && (str.length() >= length)));
        return this;
    }
    public StringSchema contains(String substring) {
        // FIXME использовать NullPointerException, ктр может бросить contains()?
        addFilter("contains", (str) -> ((str != null) && (substring != null) && str.contains(substring)));
        return this;
    }
}
