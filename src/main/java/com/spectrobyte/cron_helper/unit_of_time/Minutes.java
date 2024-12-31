package com.spectrobyte.cron_helper.unit_of_time;

import com.spectrobyte.cron_helper.unit_of_time.Numbers;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Minutes
 * Allowed values: 0-59
 * Allowed special characters: , - * /
 */
public class Minutes extends Numbers {

    public Minutes() {
        super(Pair.of(0, 59));
    }
}
