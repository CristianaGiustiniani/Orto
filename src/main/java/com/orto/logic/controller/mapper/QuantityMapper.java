package com.orto.logic.controller.mapper;

public class QuantityMapper implements Mapper<Double, String>{
    @Override
    public String toBean(Double entity) {
        return String.valueOf(entity);
    }

    @Override
    public Double toEntity(String bean) {
        return Double.parseDouble(bean);
    }
}
