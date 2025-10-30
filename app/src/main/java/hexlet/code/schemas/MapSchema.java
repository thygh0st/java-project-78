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
    public MapSchema shape(Map<?, BaseSchema<?>> schemas) {
        addFilter("shape",
            map -> {
                return map.entrySet().stream().allMatch(e -> {
                    return schemas.get(e.getKey()).isValid(e.getValue());
                });
//                boolean res = true; // FIXME
//                for (var inputKey : map.keySet()) {
//                    if (res) {
//                        BaseSchema<?> filter = schemas.get(inputKey);
//                        if (filter != null)
//                            res = filter.isValid(map.get(inputKey));
//                    } else {
//                        break;
//                    }
//                }
//                return res; // FIXME
            }
        );
        return this;
    }
}
