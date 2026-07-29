package com.orto.logic.controller;

import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.Seller;
import com.orto.logic.view_controller.controller.mapper.SellerMapper;
import com.orto.logic.view_controller.bean.SellerBean;
import com.orto.logic.view_controller.controller.ViewFactory;

import java.util.List;

public class FindFarmersController extends Controller {
    //METHODS
    public List<SellerBean> getFarmers() throws ConnectionException {
        //todo: manage null
        DAOFactory factory = DAOFactory.getDAOFactory();
        List <Seller> sellers;
        sellers = factory.getSellerDAO().getAll();
        return (new SellerMapper()).toBeans(sellers);
    }

    @Override
    public void start() {
        ViewFactory.getInstance().createFindFarmers().show();
    }
}
