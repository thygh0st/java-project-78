package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.function.Predicate;

// FIXME вынести добавление элемента в массив в общую часть?
public final class StringSchema extends BaseSchema<String> {
    private boolean required;
    private Integer minLengthPos;
    private Integer substrPos;

    public StringSchema() {
        required = false;
        minLengthPos = null;
        substrPos = null;
        predicates = new ArrayList<>();
    }

    public StringSchema required() {
        if (!this.required) {
            predicates.add((str) -> ((str != null) && !str.isEmpty()));
            this.required = true;
        }
        return this;
    }
    // FIXME что-то сделать с -length
    // UPD да, наверное, и не надо ничего делать: минимальная длина < 0 -> всегда true
    public StringSchema minLength(int length) {
        if (this.minLengthPos == null) {
            this.minLengthPos = predicates.size(); // получаем размер массива = индекс последнего элемента после добавления
            predicates.add((str) -> ((str != null) && (str.length() >= length)));
        } else {
            predicates.set(this.minLengthPos, (str) -> ((str != null) && (str.length() >= length)));
        }
        return this;
    }
    public StringSchema contains(String substring) {
        // FIXME использовать NullPointerException, ктр может бросить contains()?
        if (this.substrPos == null) {
            this.substrPos = predicates.size();
            predicates.add((str) -> ((str != null) && (substring != null) && str.contains(substring)));
        } else {
            predicates.set(this.substrPos, (str) -> ((str != null) && (substring != null) && str.contains(substring)));
        }
        return this;
    }
}
