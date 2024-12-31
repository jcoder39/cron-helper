package com.spectrobyte.cron_helper.token;

import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NumberToken implements IToken {

    private final Queue<Character> stack = new LinkedList<>();
    @Override
    public boolean match(Character character) {
        return character >= '0' && character <= '9';
    }

    @Override
    public Pair<Integer, ResultToken> get(String expression, int position) {
        Integer newPosition = parse(position, expression, stack);

        StringBuilder number = new StringBuilder();
        while (!stack.isEmpty()) {
            number.append(stack.poll());
        }

        return Pair.of(newPosition, new ResultToken(ResultToken.Type.NUMBER, number.toString()));
    }

    private int parse(int position, String expression, Queue<Character> stack) {
        if(position >= expression.length()) {
            return position;
        }

        char c = expression.charAt(position);
        if(c >= '0' && c <= '9') {
            stack.add(c);
            return parse(++position, expression, stack);
        } else {
            return position;
        }
    }
}
