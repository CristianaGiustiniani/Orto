package com.orto.logic.graphic_controller.controller.mapper;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceMapper implements Mapper<BigDecimal, String>{
    @Override
    public String toBean(BigDecimal entity) {
        return entity.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

    @Override
    public BigDecimal toEntity(String bean) {
        return new BigDecimal(bean);
    }
}
