package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    private boolean required;
    private boolean positive;
    private boolean isRange;
    private int minValue;
    private int maxValue;

    public NumberSchema() {
        required = false;
        positive = false;
        isRange = false;
        minValue = 0;
        maxValue = 0;
    }

    public NumberSchema required() {
        this.required = true;
        return this;
    }
    public NumberSchema positive() {
        this.positive = true;
        return this;
    }
    public NumberSchema range(int min, int max) {
        this.isRange = true;
        this.minValue = min;
        this.maxValue = max;

        return this;
    }

//    public boolean isValid(Integer obj) {
//
//    }
}
