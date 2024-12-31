package com.spectrobyte.cron_helper.token;

import org.apache.commons.lang3.tuple.Pair;

public interface IToken {
    boolean match(Character character);
    Pair<Integer, ResultToken> get(String expression, int position);
}
