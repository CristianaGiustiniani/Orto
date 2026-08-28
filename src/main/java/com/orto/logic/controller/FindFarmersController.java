package com.orto.logic.controller;

import com.orto.logic.controller.mapper.SellerMapper;
import com.orto.logic.controller.bean.SellerBean;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.Seller;

import java.util.List;

public class FindFarmersController {
    SellerMapper mapper = new SellerMapper();

    //METHODS
    public List<SellerBean> getFarmers() throws ConnectionException {
        DAOFactory factory = DAOFactory.getDAOFactory();
        List <Seller> sellers;
        sellers = factory.getSellerDAO().getAllSellers();
        return mapper.toBeans(sellers);
    }

    public boolean isSellerOpen(SellerBean seller) {
        return (mapper.toEntity(seller)).isOpen();
    }
}
