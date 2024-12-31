package com.spectrobyte.cron_helper.unit_of_time;

import com.spectrobyte.cron_helper.unit_of_time.Numbers;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Year
 * Allowed values: empty, 1970-2199
 * Allowed special characters: , - * /
 */
public class Year extends Numbers {

    public Year() {
        super(Pair.of(1970, 2199));
    }
}
