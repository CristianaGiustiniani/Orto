package com.orto.logic.model.dao;

import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.entity.Product;
import com.orto.logic.model.entity.Seller;

import java.util.List;

public interface ProductDAO {
    List<Product> getProducts(Seller seller) throws ConnectionException;
}
