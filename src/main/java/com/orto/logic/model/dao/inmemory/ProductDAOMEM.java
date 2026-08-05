package com.orto.logic.model.dao.inmemory;

import com.orto.logic.model.dao.ProductDAO;
import com.orto.logic.model.entity.Product;

import com.orto.logic.utils.QuantityUnit;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOMEM implements ProductDAO {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Organic Tomatoes", "Fresh organic tomatoes from local farm", 2.50, QuantityUnit.KILOGRAM));
        products.add(new Product(2, "Fresh Milk", "Whole cow milk", 1.50, QuantityUnit.LITER));
        products.add(new Product(3, "Free Range Eggs", "Box of 6 eggs", 2.00, QuantityUnit.PACK));
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public void createProduct(Product product) {
        products.add(product);
    }
}
