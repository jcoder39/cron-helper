package com.spectrobyte.cron_helper.unit_of_time;

import com.spectrobyte.cron_helper.expression.*;
import com.spectrobyte.cron_helper.misc.Functions;
import com.spectrobyte.cron_helper.token.NumberToken;
import com.spectrobyte.cron_helper.token.ResultToken;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Numbers extends UnitOfTime {

    protected final Pair<Integer, Integer> allowedRangeValues;

    public Numbers(Pair<Integer, Integer> allowedRangeValues) {
        this.allowedRangeValues = allowedRangeValues;

        expressionProcessors.addAll(List.of(
                new EnumExpression(List.of(new NumberToken()), this::onEnum),
                new RangeExpression(List.of(new NumberToken()), this::onRange),
                new AsteriskExpression(this::onAsterisk),
                new SlashExpression(List.of(new NumberToken()), this::onSlash),
                new NullExpression(List.of(new NumberToken()), this::onNull)
        ));
    }

    private void onEnum(List<ResultToken> resultTokens) {
        resultTokens.forEach(resultToken -> values.add(Functions.getIntFrom(resultToken)));
    }

    private void onRange(List<ResultToken> resultTokens) {
        var resultToken0 = resultTokens.get(0);

        int from = 0;
        int to = 0;
        if(resultTokens.size() == 1) {
            from = values.get(values.size() - 1) + 1;
            to = Functions.getIntFrom(resultToken0);
        } else {
            from = Functions.getIntFrom(resultToken0);
            var resultToken1 = resultTokens.get(1);
            to = Functions.getIntFrom(resultToken1);
        }
        to += 1;

        values.addAll(IntStream.range(from, to).boxed().toList());
    }

    private void onAsterisk(List<ResultToken> resultTokens) {
        values = IntStream.range(allowedRangeValues.getLeft(), allowedRangeValues.getRight() + 1)
                .boxed().collect(Collectors.toList());
    }

    private void onSlash(List<ResultToken> resultTokens) {
        var resultToken0 = resultTokens.get(0);

        int start = 0;
        int end = 0;
        int increment = 0;
        if(resultTokens.size() == 1) {
            start = values.get(0);
            end = values.get(values.size() - 1);
            increment = Functions.getIntFrom(resultToken0);
        } else {
            start = Functions.getIntFrom(resultToken0);
            var resultToken1 = resultTokens.get(1);
            increment = Functions.getIntFrom(resultToken1);
            end = allowedRangeValues.getRight();
        }
        end += 1;

        values.clear();
        for(int l = start; l < end; l += increment) {
            values.add(l);
        }
    }

    private void onNull(List<ResultToken> resultTokens) {
        var resultToken0 = resultTokens.get(0);
        values.add(Functions.getIntFrom(resultToken0));
    }
}
