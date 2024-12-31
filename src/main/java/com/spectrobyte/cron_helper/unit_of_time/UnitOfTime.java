package com.spectrobyte.cron_helper.unit_of_time;

import com.spectrobyte.cron_helper.expression.BaseExpression;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class UnitOfTime {

    public enum Type {SECONDS, MINUTES, HOURS, DOM, MONTH, DOW, YEAR}

    protected final List<BaseExpression> expressionProcessors = new ArrayList<>();
    protected List<Integer> values = new ArrayList<>();

    public List<Integer> getValues() {
        return values;
    }

    public String parse(String expression) {
        values.clear();

        return parse0(expression);
    }

    private String parse0(String expression) {
        return parse0(expression, false);
    }

    private String parse0(String expression, boolean finished) {
        if(finished) {
            return expression;
        }

        var processorOptional = expressionProcessors.stream()
                .map(e -> Pair.of(e.match(expression), e))
                .filter(e -> e.getLeft() >= 0)
                .min(Comparator.comparingInt(Pair::getLeft));

        if(processorOptional.isPresent()) {
            var exp = processorOptional.get().getRight().work(expression);
            return parse0(exp, exp.length() == expression.length());
        } else {
            return expression;
        }
    }
}
