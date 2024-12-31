package com.spectrobyte.cron_helper.unit_of_time;

import com.spectrobyte.cron_helper.unit_of_time.Numbers;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Seconds
 * Allowed values: 0-59
 * Allowed special characters: , - * /
 */
public class Seconds extends Numbers {

    public Seconds() {
        super(Pair.of(0, 59));
    }
}
