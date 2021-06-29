package com.dh.streams.service.case1;

import com.dh.streams.comparator.EntryAscComparator;
import com.dh.streams.service.ListProcessor;
import com.dh.streams.utils.Utils;

import java.util.*;

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
public class LoopListProcessor implements ListProcessor {

    final Comparator<Map.Entry<Integer, Double>> valueComparator = new EntryAscComparator();

    @Override
    public Map<Integer, Double> process(List<Integer> integerList) {
        Map<Integer, Double> resultMap = new HashMap<>();

        integerList.forEach(integerItem ->{
            final Double result = Utils.calculateResult(integerItem);
            if( result%2 == 0 && result < 25){
                resultMap.put(integerItem,result);
            }});

        return sortMap(resultMap);
    }

    private Map<Integer, Double> sortMap(Map<Integer, Double> resultMap) {

        Map<Integer, Double> orderedMap = new LinkedHashMap<>();
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(resultMap.entrySet());
        Collections.sort(entryList, valueComparator);
        entryList.forEach(entry -> orderedMap.put(entry.getKey(), entry.getValue()));

        return orderedMap;
    }
}
