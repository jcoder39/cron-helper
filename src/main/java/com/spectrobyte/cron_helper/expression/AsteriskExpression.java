package com.spectrobyte.cron_helper.expression;

import com.spectrobyte.cron_helper.token.CharacterToken;
import com.spectrobyte.cron_helper.token.ResultToken;

import java.util.List;
import java.util.function.Consumer;

public class AsteriskExpression extends BaseExpression {

    private final static Character character = '*';

    public AsteriskExpression(Consumer<List<ResultToken>> callback) {
        super(List.of(new CharacterToken(character)), callback);
    }

    @Override
    public int match(String expression) {
        return expression.indexOf(character);
    }
}
