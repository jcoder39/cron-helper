package com.spectrobyte.cron_helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CronHelperTest {
    @Test
    public void cronExpressionTest() {
        CronExpression cronExpression = new CronExpression(
                "0 * 0-4/2 1,3,5,10,12,14-16,19,21,23 2-6/2 ? *"
        );
        CronExpression cronExpression1 = new CronExpression(
                "0 * 0-4/2 22-25 * ? *"
        );

        Assertions.assertTrue(cronExpression.overlap(cronExpression1));
    }
}
