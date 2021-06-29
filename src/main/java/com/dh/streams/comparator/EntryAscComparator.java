package com.dh.streams.comparator;

import java.util.Comparator;
import java.util.Map;

public class EntryAscComparator implements Comparator<Map.Entry<Integer, Double>> {
    @Override
    public int compare(final Map.Entry<Integer, Double> e1, final Map.Entry<Integer, Double> e2) {
        final Double v1 = e1.getValue();
        final Double v2 = e2.getValue();
        return v1.compareTo(v2);
    }
}
