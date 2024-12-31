package com.spectrobyte.cron_helper.unit_of_time;

import com.spectrobyte.cron_helper.expression.HashExpression;
import com.spectrobyte.cron_helper.expression.LExpression;
import com.spectrobyte.cron_helper.expression.QueryExpression;
import com.spectrobyte.cron_helper.misc.Functions;
import com.spectrobyte.cron_helper.token.NumberToken;
import com.spectrobyte.cron_helper.token.ResultToken;
import com.spectrobyte.cron_helper.unit_of_time.NumbersAndStrings;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Day-of-Week
 * Allowed values: 1-7 or SUN-SAT
 * Allowed special characters: , - * ? / L #
 */
public class DayOfWeek extends NumbersAndStrings {

    public DayOfWeek() {
        super(Pair.of(1, 7), new HashMap<>(){{
            put("SUN", 1);
            put("MON", 2);
            put("TUE", 3);
            put("WED", 4);
            put("THU", 5);
            put("FRI", 6);
            put("SAT", 7);
        }});

        expressionProcessors.addAll(List.of(
                new QueryExpression(this::onQuery),
                new LExpression(List.of(new NumberToken()), this::onL),
                new HashExpression(List.of(new NumberToken()), this::onHash)
        ));
    }

    private void onQuery(List<ResultToken> resultTokens) {
        values = IntStream.range(allowedRangeValues.getLeft(), allowedRangeValues.getRight() + 1)
                .boxed().collect(Collectors.toList());
    }

    private void onL(List<ResultToken> resultTokens) {
        if(resultTokens.isEmpty()) {
            values.add(stringMap.get("SAT"));
        } else {
            var resultToken0 = resultTokens.get(0);
            int weekday = Functions.getIntFrom(resultToken0, stringMap);
            values.add(weekday);
        }
    }

    private void onHash(List<ResultToken> resultTokens) {
        var resultToken0 = resultTokens.get(0);
        int weekday = Functions.getIntFrom(resultToken0, stringMap);
        values.add(weekday);
    }
}
