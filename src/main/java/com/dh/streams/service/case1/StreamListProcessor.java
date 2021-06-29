package com.dh.streams.service.case1;

import com.dh.streams.service.ListProcessor;
import com.dh.streams.utils.Utils;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;

/*
1. transform to Double
    the new Double value = originalValue *  with a random number between 1 and 10
2. filter only even numbers
3. filter only  less than 25
4. sort by  min to max
5. collect to Map where
    the key = originalValue
    the value =  newValue
5. print each one with text "key = [key], value = [value]"
 */
public class StreamListProcessor implements ListProcessor {

    @Override
    public Map<Integer, Double> process(List<Integer> integerList) {

        Map<Integer, Double> result =  new LinkedHashMap<>();

        integerList.stream()
                .map(integerItem ->  new Double[]{Double.valueOf(integerItem), Utils.calculateResult(integerItem)})
                .filter(doubleArray -> doubleArray[1]%2 == 0 && doubleArray[1] < 25)
                .collect(Collectors.toMap(array -> array[0].intValue(), array -> array[1]))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(entry -> entry.getValue()))
                .forEach(entry-> result.put(entry.getKey(), entry.getValue()));

        return result;

    }
}
