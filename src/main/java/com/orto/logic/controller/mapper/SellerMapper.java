package com.orto.logic.controller.mapper;

import com.orto.logic.model.entity.Seller;
import com.orto.logic.controller.bean.SellerBean;
import com.orto.logic.controller.bean.TimeSlotBean;
import com.orto.logic.model.entity.TimeSlot;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;

public class SellerMapper implements Mapper <Seller, SellerBean>{

    public SellerBean toBean(Seller seller) {
        SellerBean sellerBean = new SellerBean();
        Map<DayOfWeek, TimeSlotBean> openingHoursBean = new EnumMap<>(DayOfWeek.class);

        //converting seller fields into sellerBean fields
        sellerBean.setId(seller.getId());
        sellerBean.setName(seller.getName());
        sellerBean.setAddress((new AddressMapper()).toBean(seller.getAddress()));
        sellerBean.setProductTypes(seller.getProductTypes());

        for(DayOfWeek day: DayOfWeek.values()) {
            TimeSlotBean timeSlotBean = new TimeSlotBean();
            timeSlotBean.setOpeningTime(seller.getOpeningTimes().get(day).openingTime());
            timeSlotBean.setClosingTime(seller.getOpeningTimes().get(day).closingTime());
            openingHoursBean.put(day, timeSlotBean);
        }

        sellerBean.setOpeningHours(openingHoursBean);

        return sellerBean;
    }

    @Override
    public Seller toEntity(SellerBean bean) {
        Map<DayOfWeek, TimeSlot> openingTimes = new EnumMap<>(DayOfWeek.class);
        for (DayOfWeek day : DayOfWeek.values()) {
            TimeSlotBean timeSlotBean = bean.getOpeningHours().get(day);
            openingTimes.put(day, new TimeSlot(
                    timeSlotBean.getOpeningTime(),
                    timeSlotBean.getClosingTime()
            ));
        }

        return new Seller(
                bean.getId(),
                bean.getName(),
                new AddressMapper().toEntity(bean.getAddress()),
                bean.getProductTypes(),
                openingTimes);
    }
}
