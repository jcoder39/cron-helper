package com.spectrobyte.cron_helper.unit_of_time;

import com.spectrobyte.cron_helper.unit_of_time.NumbersAndStrings;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;

/**
 * Month
 * Allowed values: 0-11 or JAN-DEC
 * Allowed special characters: , - * /
 */
public class Month extends NumbersAndStrings {

    public Month() {
        super(Pair.of(0, 11), new HashMap<>() {{
            put("JAN", 0);
            put("FEB", 1);
            put("MAR", 2);
            put("APR", 3);
            put("MAY", 4);
            put("JUN", 5);
            put("JUL", 6);
            put("AUG", 7);
            put("SEP", 8);
            put("OCT", 9);
            put("NOV", 10);
            put("DEC", 11);
        }});
    }
}
