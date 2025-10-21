package hexlet.code.schemas;

import java.util.ArrayList; // FIXME вынести в базовый класс?
import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {
    private Integer requiredPos;
    private Integer sizeofPos;

    public MapSchema() {
        requiredPos = null;
        sizeofPos = null;
        predicates = new ArrayList<>();
    }

    public MapSchema required() {
        this.requiredPos = addFilter(map -> map != null, this.requiredPos);
        return this;
    }
    public MapSchema sizeof(int size) {
        this.sizeofPos = addFilter(map -> ((map == null) || (map.size() == size)), this.sizeofPos);
        return this;
    }
}
