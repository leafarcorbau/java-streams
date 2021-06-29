package com.dh.streams.service.case2;

import com.dh.streams.dto.InfoDto;
import com.dh.streams.service.ListProcessor;
import com.dh.streams.utils.Utils;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class StreamListInfoDtoProcessor implements ListProcessor  {

    public static final int INT = 25;

    @Override
    public Map<Integer, Double> process(List<Integer> integerList) {
        Map<Integer, Double> result =  new LinkedHashMap<>();

        integerList.stream()
                .map(integerItem -> new InfoDto(integerItem, Utils.calculateResult(integerItem)))
                .filter(infoDto -> infoDto.getNewValue()%2 == 0 && infoDto.getNewValue() < INT)
                .collect(Collectors.toMap(infoDto ->infoDto.getOriginalValue(), infoDto -> infoDto.getNewValue()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(entry -> entry.getValue()))
                .forEach(entry-> result.put(entry.getKey(), entry.getValue()));

        return result;
    }
}
