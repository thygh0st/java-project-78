package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema() {
        predicates = new HashMap<>();
    }

    public MapSchema required() {
        addFilter("required", map -> map != null);
        return this;
    }
    public MapSchema sizeof(int size) {
        addFilter("sizeof", map -> ((map == null) || (map.size() == size)));
        return this;
    }
    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        addFilter("shape",
            map -> {
                return map.entrySet().stream().allMatch(e -> {
                    return schemas.get(e.getKey()).isValid((T) e.getValue());
                });
            }
        );
        return this;
    }
}
