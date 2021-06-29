package com.dh.streams;


import com.dh.streams.service.ListProcessor;
import com.dh.streams.service.case2.LoopListInfoDtoProcessor;
import com.dh.streams.service.case2.StreamListInfoDtoProcessor;
import com.dh.streams.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

/*
List<Integer> intsList = {1, 2, 3, 4, 5, 6., 7, 8, 9, 10}

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
public class HomeworkCase2Test {

    @Test
    public void shouldProcessWithStreams(){

        //given
        final List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final ListProcessor streamListProcessor = new StreamListInfoDtoProcessor();

        //When
        final Map<Integer, Double> result = streamListProcessor.process(integers);
        Utils.print(result);

        //Then
        final List<Double> values = result.entrySet().stream().map(item -> item.getValue()).collect(Collectors.toList());
        //assert all values are Even
        values.forEach(value -> assertThat(value%2).isEqualTo(0));
        //assert all values are less than 25
        values.forEach(value -> assertThat(value).isLessThan(25));
        //assert all values are Sorted Min to Max
        assertThat(values).isSortedAccordingTo(Comparator.naturalOrder());
    }

    @Test
    public void shouldProcessWithLoop(){

        //given
        final List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final ListProcessor loopListProcessor = new LoopListInfoDtoProcessor();

        //When
        final Map<Integer, Double> result = loopListProcessor.process(integers);
        Utils.print(result);

        //Then
        final List<Double> values = result.entrySet().stream().map(item -> item.getValue()).collect(Collectors.toList());
        //assert all values are Even
        values.forEach(value -> assertThat(value%2).isEqualTo(0));
        //assert all values are less than 25
        values.forEach(value -> assertThat(value).isLessThan(25));
        //assert all values are Sorted Min to Max
        assertThat(values).isSortedAccordingTo(Comparator.naturalOrder());
    }
}
