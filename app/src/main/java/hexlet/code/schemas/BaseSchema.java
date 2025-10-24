package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
//    private HashMap<Predicate<T>, boolean> predicates;
    protected ArrayList<Predicate<T>> predicates;

    public boolean isValid(T obj) {
        boolean result = true;
        if (!predicates.isEmpty()) {
            for (var cond : predicates) {
                result = result && cond.test(obj);
            }
        }
        return result;
    }

    public Integer addFilter(Predicate<T> filter, Integer pos) {
        if (pos == null) {
            predicates.add(filter);
            return predicates.size() - 1;
        } else {
            predicates.set(pos, filter);
            return pos;
        }
    }
}
