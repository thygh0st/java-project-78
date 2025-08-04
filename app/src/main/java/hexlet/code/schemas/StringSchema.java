package hexlet.code.schemas;

public final class StringSchema implements Validating {
    private boolean required;
    private int minLength;
    private String substr;

    public StringSchema() {
        required = false;
        minLength = 0;
        substr = "";
    }

    public StringSchema required() {
        this.required = true;
        return this;
    }
    public StringSchema minLength(int length) {
        this.minLength = length; // FIXME что-то сделать с -length
        return this;
    }
    public StringSchema contains(String substring) {
        this.substr = substring;
        return this;
    }

    @Override
    public boolean isValid(Object obj) { // TODO
        String str = (String) obj;
        if ((str == null) || str.isEmpty()) {
            return !required;
        }
//        if (required && str.equals("")) {
//            return false;
//        }
        if ((minLength > 0) && (str.length() < minLength)) { // флаг minLength?
            return false;
        }
        if ((substr != null) && (!str.contains(substr))) {
            return false;
        }
        return true;
    }
}
