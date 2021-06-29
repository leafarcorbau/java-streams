package com.dh.streams.service.case2;

import com.dh.streams.comparator.EntryAscComparator;
import com.dh.streams.dto.InfoDto;
import com.dh.streams.service.ListProcessor;
import com.dh.streams.utils.Utils;

import java.util.*;

import static java.lang.String.format;

/*
1. transform to Object
    Dto{
        originalValue: Integer
        newValue: Double
    }
the new value = originalValue * with a random number between 1 and 10

2. filter only the newValue is an even number
3. filter only then newValue  less than 25
4. sort by newValue from min to max
5. collect to Map where
    the key = originalValue
    the value =  newValue
5. print each one with text "key = [key], value = [value]"
 */
public class LoopListInfoDtoProcessor implements ListProcessor {

    final Comparator<Map.Entry<Integer, Double>> valueComparator = new EntryAscComparator();

    @Override
    public Map<Integer, Double> process(List<Integer> integerList) {

        List<InfoDto> infoDtos = new ArrayList<>();
        Map<Integer, Double> resultMap = new HashMap<>();

        integerList.forEach(integerItem ->
            infoDtos.add(new InfoDto(integerItem, Utils.calculateResult(integerItem))));

        infoDtos.forEach(integerItem ->{
            final Double newValue = integerItem.getNewValue();
            if(newValue %2 == 0 && newValue < 25){
                resultMap.put(integerItem.getOriginalValue(), newValue);
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
