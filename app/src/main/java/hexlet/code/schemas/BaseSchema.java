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
                result &= cond.test(obj);
            }
        }
        return result;
    }
}
