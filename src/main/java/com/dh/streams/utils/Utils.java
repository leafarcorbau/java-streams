package com.dh.streams.utils;

import java.util.Map;
import java.util.Random;

import static java.lang.String.format;

public class Utils {

    private static final String MSG = "key = %s, value = %s";

    public static Double calculateResult(Integer integerItem) {
        final int randomInteger = new Random().nextInt(10);
        return Double.valueOf(integerItem * randomInteger);
    }

    public static void print(final Map<Integer, Double> map){
        map.entrySet()
                .forEach(entry -> System.out.println(format(MSG, entry.getKey(), entry.getValue())));
    }
}
