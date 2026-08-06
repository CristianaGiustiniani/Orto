package com.orto.logic.model.dao;

import com.orto.logic.model.entity.Product;
import com.orto.logic.model.entity.Seller;

import java.util.List;

public interface ProductDAO {
    void createProduct(Product product);

    List<Product> getProducts(Seller seller);
}
