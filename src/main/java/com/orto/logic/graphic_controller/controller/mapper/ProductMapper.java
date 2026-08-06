package com.orto.logic.graphic_controller.controller.mapper;

import com.orto.logic.graphic_controller.bean.ProductBean;
import com.orto.logic.model.entity.Product;

public class ProductMapper implements Mapper<Product, ProductBean>{
    @Override
    public ProductBean toBean(Product entity) {
        ProductBean bean = new ProductBean();
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        bean.setDescription(entity.getDescription());
        bean.setPrice((new PriceMapper()).toBean(entity.getPrice()));
        bean.setQuantityUnit(entity.getQuantityUnit());
        return bean;
    }

    @Override
    public Product toEntity(ProductBean bean) {
        return new Product(
                bean.getId(),
                bean.getName(),
                bean.getDescription(),
                (new PriceMapper()).toEntity(bean.getPrice()),
                bean.getQuantityUnit()
        );
    }
}
