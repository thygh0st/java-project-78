package hexlet.code.schemas;

import java.util.ArrayList;

public final class StringSchema extends BaseSchema<String> {
//    private boolean required; // для единообразия делаю Integer
    private Integer requiredPos;
    private Integer minLengthPos; // заменить на int?
    private Integer substrPos; // заменить на int?

    public StringSchema() {
//        required = false;
        requiredPos = null;
        minLengthPos = null;
        substrPos = null;
        predicates = new ArrayList<>(); // вынести в "конструктор" базового класса, раз уж разделяем?
    }

    public StringSchema required() {
        this.requiredPos = addFilter((str) -> ((str != null) && !str.isEmpty()), this.requiredPos);
        return this;
    }
    // FIXME что-то сделать с -length
    // UPD да, наверное, и не надо ничего делать: минимальная длина < 0 -> всегда true
    public StringSchema minLength(int length) {
        this.minLengthPos = addFilter((str) -> ((str != null) && (str.length() >= length)), this.minLengthPos);
        return this;
    }
    public StringSchema contains(String substring) {
        // FIXME использовать NullPointerException, ктр может бросить contains()?
        this.substrPos = addFilter(
                (str) -> ((str != null) && (substring != null) && str.contains(substring)),
                this.substrPos
        );
        return this;
    }
}
