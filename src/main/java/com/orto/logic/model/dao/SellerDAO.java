package com.orto.logic.model.dao;

import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.entity.Seller;

import java.util.List;

public interface SellerDAO {
    List<Seller> getAll() throws ConnectionException;
}
