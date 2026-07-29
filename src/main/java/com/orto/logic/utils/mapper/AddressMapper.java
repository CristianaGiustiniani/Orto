package com.orto.logic.utils.mapper;

import com.orto.logic.model.entity.Address;
import com.orto.logic.view_controller.bean.AddressBean;

public class AddressMapper implements Mapper <Address, AddressBean>{
    @Override
    public AddressBean toBean(Address address) {
        AddressBean addressBean = new AddressBean();

        addressBean.setStreetName(address.getStreet());
        addressBean.setCivicNumber(address.getNumber());
        addressBean.setPostalCode(address.getPostalCode());
        addressBean.setCity(address.getCity());
        addressBean.setProvince(address.getProvince());
        addressBean.setCountry(address.getCountry());

        return addressBean;
    }

    @Override
    public Address toEntity(AddressBean bean) {
        return null;
    }
}
