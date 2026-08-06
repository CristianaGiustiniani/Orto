package com.orto.logic.model.dao.inmemory;

import com.orto.logic.model.dao.ProductDAO;
import com.orto.logic.model.entity.Product;

import com.orto.logic.model.entity.Seller;
import com.orto.logic.utils.QuantityUnit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOMEM implements ProductDAO {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(
                1,
                "Patata rossa",
                null,
                BigDecimal.valueOf(3.00),
                QuantityUnit.KILOGRAM));

        products.add(new Product(
                2, "Yogurt all'albicocca 125 gr in vetro",
                "Yogurt di latte vaccino con albicocche a pezzi",
                BigDecimal.valueOf(1.50),
                QuantityUnit.PIECE));
    }

    @Override
    public List<Product> getProducts(Seller seller) {
        return products;
    }

    @Override
    public void createProduct(Product product) {
        products.add(product);
    }
}
