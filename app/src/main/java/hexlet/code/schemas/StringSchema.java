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
    public StringSchema contains(String substr) {
        this.substr = substr;
        return this;
    }

    @Override
    public boolean isValid(Object obj) { // TODO
        String str = (String) obj;
        if (required) {
            if (str == null || str.equals("")) {
                return false;
            }
        }
        if ((minLength > 0) && (str.length() < minLength)) {
            return false;
        }
        if ((substr != null) && (!str.contains(substr))) {
            return false;
        }
        return true;
    }
}
