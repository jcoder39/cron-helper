package com.spectrobyte.cron_helper.expression;

import com.spectrobyte.cron_helper.token.IToken;
import com.spectrobyte.cron_helper.token.ResultToken;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class BaseExpression {
    protected final Consumer<List<ResultToken>> callback;
    protected final List<IToken> tokens = new ArrayList<>();

    public BaseExpression(List<IToken> tokens, Consumer<List<ResultToken>> callback) {
        this.tokens.addAll(tokens);
        this.callback = callback;
    }

    public abstract int match(String expression);

    public String work(String expression) {
        List<ResultToken> values = new ArrayList<>();

        boolean found = false;
        int i = 0;
        while (i < expression.length()) {
            char c = expression.charAt(i);

            found = false;
            for(var token : tokens) {
                if(token.match(c)) {
                    found = true;

                    var t = token.get(expression, i);
                    ResultToken resultToken = t.getRight();

                    if(resultToken.type != ResultToken.Type.NONE) {
                        values.add(resultToken);
                    }

                    i = t.getLeft();
                }
            }

            if(!found) {
                break;
            }

        }

        callback.accept(values);

        return expression.substring(i);
    }
}
