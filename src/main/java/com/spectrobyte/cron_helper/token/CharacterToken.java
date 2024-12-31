package com.spectrobyte.cron_helper.token;

import org.apache.commons.lang3.tuple.Pair;

public class CharacterToken implements IToken {

    private final Character character;

    public CharacterToken(Character character) {
        this.character = character;
    }

    @Override
    public boolean match(Character character) {
        return this.character.equals(character);
    }

    @Override
    public Pair<Integer, ResultToken> get(String expression, int position) {
        return Pair.of(position + 1, new ResultToken(ResultToken.Type.CHARACTER, "" + character));
    }
}
