package com.spectrobyte.cron_helper.expression;

import com.spectrobyte.cron_helper.misc.Globals;
import com.spectrobyte.cron_helper.token.IToken;
import com.spectrobyte.cron_helper.token.ResultToken;

import java.util.List;
import java.util.function.Consumer;

public class NullExpression extends BaseExpression {

    public NullExpression(List<IToken> tokens, Consumer<List<ResultToken>> callback) {
        super(tokens, callback);
    }

    @Override
    public int match(String expression) {
        return (expression.matches("[A-Z0-9]+") && expression.matches("[^LW]+"))
                ? Globals.UNREACHABLE_NUMBER : -1;
    }
}
