package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> predicates;

    public final boolean isValid(Object obj) {
        boolean result = true;
        if (!predicates.isEmpty()) {
            for (var cond : predicates.values()) {
                result = result && cond.test((T) obj);
            }
        }
        return result;
    }

    public final void addFilter(String key, Predicate<T> filter) {
        predicates.put(key.toLowerCase(), filter);
    }
}
