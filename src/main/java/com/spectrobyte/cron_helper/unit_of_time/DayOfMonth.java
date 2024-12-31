package com.spectrobyte.cron_helper.unit_of_time;

import com.spectrobyte.cron_helper.expression.LExpression;
import com.spectrobyte.cron_helper.expression.QueryExpression;
import com.spectrobyte.cron_helper.expression.WExpression;
import com.spectrobyte.cron_helper.misc.Functions;
import com.spectrobyte.cron_helper.token.NumberToken;
import com.spectrobyte.cron_helper.token.ResultToken;
import com.spectrobyte.cron_helper.unit_of_time.Numbers;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Day-of-month
 * Allowed values: 1-31
 * Allowed special characters: , - * ? / L W
 */
public class DayOfMonth extends Numbers {

    public DayOfMonth() {
        super(Pair.of(1, 31));

        expressionProcessors.addAll(List.of(
                new QueryExpression(this::onQuery),
                new LExpression(List.of(new NumberToken()), this::onL),
                new WExpression(List.of(new NumberToken()), this::onW)
        ));
    }

    private void onQuery(List<ResultToken> resultTokens) {
        values = IntStream.range(allowedRangeValues.getLeft(), allowedRangeValues.getRight() + 1)
                .boxed().collect(Collectors.toList());
    }

    private void onL(List<ResultToken> resultTokens) {
        values.addAll(List.of(28, 29, 30, 31));
    }

    private void onW(List<ResultToken> resultTokens) {
        var resultToken0 = resultTokens.get(0);
        int pivot = Functions.getIntFrom(resultToken0);

        int start = pivot - 1;
        int end = pivot + 1;
        if(start < allowedRangeValues.getLeft()) {
            start++;
            end++;
        }
        if(end > allowedRangeValues.getRight()) {
            end--;
        }
        for(int i = start; i <= end; i++) {
            values.add(i);
        }
    }
}
