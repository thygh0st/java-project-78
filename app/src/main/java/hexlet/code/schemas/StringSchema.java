package hexlet.code.schemas;

import java.util.ArrayList;

public final class StringSchema extends BaseSchema<String> {
    private boolean required;
    private boolean minLength;
    private boolean substr;

    public StringSchema() {
        required = false;
        minLength = false;
        substr = false;
        predicates = new ArrayList<>();
    }

    public StringSchema required() {
        if (!this.required) {
            predicates.add((str) -> ((str != null) && !str.isEmpty()));
            this.required = true;
        }
        return this;
    }
    public StringSchema minLength(int length) {
// FIXME что-то сделать с -length
// UPD да, наверное, и не надо ничего делать: минимальная длина < 0 -> всегда true
        if (!this.minLength) {
            predicates.add((str) -> ((str != null) && (str.length() >= length)));
            this.minLength = true;
        }
        return this;
    }
    public StringSchema contains(String substring) {
//        this.substr = substring;
        predicates.add((str) -> ((str != null) && (substring != null) && str.contains(substring)));
        // FIXME использовать NullPointerException, ктр может бросить contains()?
        // FIXME накапливает проверки в scheme, надо хранить один экземпляр проверки и подменять substring
        return this;
    }

////    @Override
//    public boolean isValid(String obj) {
//        String str = (String) obj;
//        if ((str == null) || str.isEmpty()) {
//            return (!required) && ((minLength <= 0) || (substr == null));
//        }
//        if ((minLength > 0) && (str.length() < minLength)) { // флаг minLength?
//            return false;
//        }
//        if ((substr != null) && (!str.contains(substr))) {
//            return false;
//        }
//        return true;
//    }
}
