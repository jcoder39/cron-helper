package com.spectrobyte.cron_helper.expression;

import com.spectrobyte.cron_helper.token.IToken;
import com.spectrobyte.cron_helper.token.ResultToken;
import com.spectrobyte.cron_helper.token.SkipToken;

import java.util.List;
import java.util.function.Consumer;

public class RangeExpression extends BaseExpression {

    private final static Character character = '-';

    public RangeExpression(List<IToken> tokens, Consumer<List<ResultToken>> callback) {
        super(tokens, callback);
        this.tokens.add(new SkipToken(character));
    }

    @Override
    public int match(String expression) {
        return expression.indexOf(character);
    }
}
