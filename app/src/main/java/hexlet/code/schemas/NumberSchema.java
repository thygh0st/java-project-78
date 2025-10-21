package hexlet.code.schemas;

import java.util.ArrayList;

public final class NumberSchema extends BaseSchema<Integer> {
    private Integer requiredPos;
    private Integer positivePos;
    private Integer rangePos;

    public NumberSchema() {
        requiredPos = null;
        positivePos = null;
        rangePos = null;
        predicates = new ArrayList<>();
    }

    public NumberSchema required() {
//        this.requiredPos = addFilter(Objects::nonNull, this.requiredPos); // окак
        this.requiredPos = addFilter(num -> num != null, this.requiredPos);
        return this;
    }
    public NumberSchema positive() {
        this.positivePos = addFilter(num -> ((num == null) || (num > 0)), this.positivePos);
        return this;
    }
    public NumberSchema range(int min, int max) { // возможно, тут тоже null валидный...
        this.rangePos = addFilter(num -> ((num != null) && (num >= min) && (num <= max)), this.rangePos);
        return this;
    }
}
