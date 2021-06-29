package com.dh.streams.service;

import java.util.List;
import java.util.Map;

public interface ListProcessor{

    Map<Integer, Double> process(List<Integer> integerList);
}
