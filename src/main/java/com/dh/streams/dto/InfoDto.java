package com.dh.streams.dto;

public class InfoDto {
    private Integer originalValue;
    private Double newValue;

    public InfoDto(final Integer originalValue,final Double newValue) {
        this.originalValue = originalValue;
        this.newValue = newValue;
    }

    public Integer getOriginalValue() {
        return originalValue;
    }

    public Double getNewValue() {
        return newValue;
    }
}
