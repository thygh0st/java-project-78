package hexlet.code.schemas;

import java.util.HashMap;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        predicates = new HashMap<>();
    }

    public NumberSchema required() {
        addFilter("required", num -> num != null);
        return this;
    }
    public NumberSchema positive() {
        addFilter("positive", num -> ((num == null) || (num > 0)));
        return this;
    }
    public NumberSchema range(int min, int max) { // возможно, тут тоже null валидный... upd из обсуждений - да
        addFilter("range", num -> ((num == null) || (num >= min) && (num <= max)));
        return this;
    }
}
