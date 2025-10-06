package hexlet.code.schemas;

import java.util.ArrayList;

public final class StringSchema extends BaseSchema<String> {
    private boolean required;
    private int minLength;
    private String substr;

    public StringSchema() {
        required = false;
        minLength = 0;
        substr = "";
        predicates = new ArrayList<>();
    }

    public StringSchema required() {
//        this.required = true;
        predicates.add((str) -> ((str != null) && !str.isEmpty()));
        return this;
    }
    public StringSchema minLength(int length) {
//        this.minLength = length; // FIXME что-то сделать с -length
// UPD да, наверное, и не надо ничего делать: минимальная длина < 0 -> всегда true
        predicates.add((str) -> ((str != null) && (str.length() >= length)));
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
