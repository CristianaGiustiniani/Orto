package com.orto.logic.model.dao.db;

import com.orto.logic.model.dao.ProductDAO;
import com.orto.logic.model.entity.Product;
import com.orto.logic.model.entity.Seller;

import java.util.List;

public class ProductDAODB implements ProductDAO {
    @Override
    public void createProduct(Product product) {

    }

    @Override
    public List<Product> getProducts(Seller seller) {
        return List.of();
    }

}
