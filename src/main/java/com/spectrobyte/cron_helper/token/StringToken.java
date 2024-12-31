package com.spectrobyte.cron_helper.token;

import org.apache.commons.lang3.tuple.Pair;

public class StringToken implements IToken {
    @Override
    public boolean match(Character character) {
        return !(character == 'L' || character == 'W') && character >= 'A' && character <= 'Z';
    }

    @Override
    public Pair<Integer, ResultToken> get(String expression, int position) {
        int newPosition = position + 3;
        String t = expression.substring(position, newPosition);

        return Pair.of(newPosition, new ResultToken(ResultToken.Type.STRING, t));
    }
}
