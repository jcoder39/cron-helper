package com.spectrobyte.cron_helper;

import com.spectrobyte.cron_helper.misc.Functions;
import com.spectrobyte.cron_helper.unit_of_time.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class CronExpression {

    private final List<UnitOfTime> unitOfTimes;

    public CronExpression(String expression) {
        this.unitOfTimes = new ArrayList<>() {{
            add(new Seconds());
            add(new Minutes());
            add(new Hours());
            add(new DayOfMonth());
            add(new Month());
            add(new DayOfWeek());
            add(new Year());
        }};

        List<String> tokens = Collections.list(new StringTokenizer(expression, " \t", false)).stream()
                .map(token -> (String) token).toList();

        IntStream.range(0, unitOfTimes.size()).forEach(index -> {
            UnitOfTime unit = unitOfTimes.get(index);
            if(Functions.indexExists(index, tokens)) {
                unit.parse(tokens.get(index));
            } else {
                unit.parse("*");
            }
        });
    }

    public boolean overlap(CronExpression other) {
        for(int index = 0; index < unitOfTimes.size(); index++) {
            UnitOfTime unit0 = unitOfTimes.get(index);
            UnitOfTime unit1 = other.unitOfTimes.get(index);

            if(unit0.getValues().stream().noneMatch(unit1.getValues()::contains)) {
                return false;
            }
        }

        return true;
    }
}
