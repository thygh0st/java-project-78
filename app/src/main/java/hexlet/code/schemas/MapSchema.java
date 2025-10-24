package hexlet.code.schemas;

import java.util.ArrayList; // FIXME вынести в базовый класс?
import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {
    private Integer requiredPos;
    private Integer sizeofPos;
    private boolean shaped;
    private Map<?, BaseSchema<String>> extFilterMap; // не получилось сделать более общим, только String

    public MapSchema() {
        requiredPos = null;
        sizeofPos = null;
        predicates = new ArrayList<>();
        shaped = false;
        extFilterMap = null;
    }

    public MapSchema required() {
        this.requiredPos = addFilter(map -> map != null, this.requiredPos);
        return this;
    }
    public MapSchema sizeof(int size) {
        this.sizeofPos = addFilter(map -> ((map == null) || (map.size() == size)), this.sizeofPos);
        return this;
    }
    public void shape(Map<?, BaseSchema<String>> schemas) { // не получилось сделать более общим, только String
        shaped = true;
        extFilterMap = new HashMap<>(schemas);
    }
    public boolean isValid(Map<?, ?> obj) {
        if (!shaped) {
            return super.isValid(obj);
        } else {
            boolean res = true;
            var inputSet = obj.keySet();
            for (var key : inputSet) {
//                res = res && extFilterMap.getOrDefault(key, ).isValid(key);
                BaseSchema<String> filter = extFilterMap.get(key); // получаем фильтр для этого ключа
                if (filter == null) {
                    return false;
                } else {
                    res = res && filter.isValid((String) obj.get(key));
                }
            }
            return res;
        }
    }
}
