package com.orto.logic.graphic_controller.controller.mapper;

import com.orto.logic.graphic_controller.bean.*;
import com.orto.logic.model.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper implements Mapper <Order, OrderBean>{
    @Override
    public OrderBean toBean(Order order) {
        //I'm only interested in the id, the seller, the status and the total price
        OrderBean orderBean = new OrderBean();
        SellerBean sellerBean = new SellerBean();

        //converting order fields into orderBean fields
        orderBean.setId(order.getId());

        sellerBean.setId(order.getSeller().getId());
        sellerBean.setName(order.getSeller().getName());
        sellerBean.setAddress((new AddressMapper()).toBean(order.getSeller().getAddress()));
        orderBean.setSeller(sellerBean);

        orderBean.setStatus(order.getStatus());
        orderBean.setTotalPrice(order.getTotalPrice());

        return orderBean;
    }

    @Override
    public Order toEntity(OrderBean bean) {
        Order order = new Order(

        );
        return null;
    }
}
