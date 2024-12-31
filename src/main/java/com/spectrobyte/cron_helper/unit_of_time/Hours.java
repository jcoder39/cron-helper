package com.spectrobyte.cron_helper.unit_of_time;

import com.spectrobyte.cron_helper.unit_of_time.Numbers;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Hours
 * Allowed values: 0-23
 * Allowed special characters: , - * /
 */
public class Hours extends Numbers {

    public Hours() {
        super(Pair.of(0, 23));
    }
}
