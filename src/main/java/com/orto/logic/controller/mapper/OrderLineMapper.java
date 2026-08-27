package com.orto.logic.controller.mapper;

import com.orto.logic.controller.bean.OrderLineBean;
import com.orto.logic.controller.bean.ProductBean;
import com.orto.logic.model.entity.OrderLine;
import com.orto.logic.model.entity.Product;

public class OrderLineMapper implements Mapper<OrderLine, OrderLineBean> {
    @Override
    public OrderLineBean toBean(OrderLine entity) {
        OrderLineBean bean = new OrderLineBean();

        bean.setProductId(entity.getProductId());
        bean.setProductName(entity.getProductName());
        bean.setPrice((new PriceMapper()).toBean(entity.getProductPrice()));
        bean.setQuantity((new QuantityMapper()).toBean(entity.getQuantity()));
        bean.setQuantityUnit(entity.getQuantityUnit());
        bean.setAnnotation(entity.getAnnotation());

        return bean;
    }

    @Override
    public OrderLine toEntity(OrderLineBean bean) {
        ProductBean productBean = new ProductBean();

        productBean.setId(bean.getProductId());
        productBean.setName(bean.getProductName());
        productBean.setPrice(bean.getPrice());
        productBean.setQuantityUnit(bean.getQuantityUnit());

        Product product = (new ProductMapper()).toEntity(productBean);

        return new OrderLine(
                product,
                (new QuantityMapper()).toEntity(bean.getQuantity()),
                bean.getAnnotation());
    }
}
