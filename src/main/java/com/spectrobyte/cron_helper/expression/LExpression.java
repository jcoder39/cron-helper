package com.spectrobyte.cron_helper.expression;

import com.spectrobyte.cron_helper.token.IToken;
import com.spectrobyte.cron_helper.token.ResultToken;
import com.spectrobyte.cron_helper.token.SkipToken;

import java.util.List;
import java.util.function.Consumer;

public class LExpression extends BaseExpression {

    private final static Character character = 'L';

    public LExpression(List<IToken> tokens, Consumer<List<ResultToken>> callback) {
        super(tokens, callback);
        this.tokens.add(new SkipToken(character));
    }

    @Override
    public int match(String expression) {
        return expression.indexOf(character);
    }
}
