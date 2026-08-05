package com.orto.logic.graphic_controller.controller.mapper;

import com.orto.logic.graphic_controller.bean.ProductBean;
import com.orto.logic.model.entity.Product;

public class ProductMapper implements Mapper<Product, ProductBean>{
    @Override
    public ProductBean toBean(Product entity) {
        return null;
    }

    @Override
    public Product toEntity(ProductBean bean) {
        return null;
    }
}
