package com.spectrobyte.cron_helper.misc;

import com.spectrobyte.cron_helper.token.ResultToken;

import java.util.List;
import java.util.Map;

public final class Functions {
    public static int getIntFrom(ResultToken resultToken) {
        return getIntFrom(resultToken, Map.of());
    }

    public static int getIntFrom(ResultToken resultToken, Map<String, Integer> stringValues) {
        if(resultToken.type == ResultToken.Type.NUMBER) {
            return Integer.parseInt(resultToken.value);
        }
        if(resultToken.type == ResultToken.Type.STRING) {
            return stringValues.get(resultToken.value);
        }

        return Globals.UNREACHABLE_NUMBER;
    }

    public static <T> boolean indexExists(int index, List<T> list) {
        return index >= 0 && index < list.size();
    }
}
