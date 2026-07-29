package com.orto.logic.view_controller.controller.mapper;

import com.orto.logic.model.entity.Seller;
import com.orto.logic.view_controller.bean.SellerBean;
import com.orto.logic.view_controller.bean.TimeSlotBean;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class SellerMapper implements Mapper <Seller, SellerBean>{

    public SellerBean toBean(Seller seller) {
        SellerBean sellerBean = new SellerBean();
        List<TimeSlotBean> openingHoursBean = new ArrayList<>();
        TimeSlotBean timeSlotBean = new TimeSlotBean();

        //converting seller fields into sellerBean fields
        sellerBean.setId(seller.getId());
        sellerBean.setName(seller.getName());
        sellerBean.setAddress((new AddressMapper()).toBean(seller.getAddress()));
        sellerBean.setProductTypes(seller.getProductTypes());
        timeSlotBean.setDay(DayOfWeek.MONDAY);
        timeSlotBean.setOpeningTime(seller.getOpeningTimes().get(DayOfWeek.MONDAY).openingTime());
        timeSlotBean.setClosingTime(seller.getOpeningTimes().get(DayOfWeek.MONDAY).closingTime());
        openingHoursBean.add(timeSlotBean);
        timeSlotBean.setDay(DayOfWeek.TUESDAY);
        timeSlotBean.setOpeningTime(seller.getOpeningTimes().get(DayOfWeek.TUESDAY).openingTime());
        timeSlotBean.setClosingTime(seller.getOpeningTimes().get(DayOfWeek.TUESDAY).closingTime());
        openingHoursBean.add(timeSlotBean);
        timeSlotBean.setDay(DayOfWeek.WEDNESDAY);
        timeSlotBean.setOpeningTime(seller.getOpeningTimes().get(DayOfWeek.WEDNESDAY).openingTime());
        timeSlotBean.setClosingTime(seller.getOpeningTimes().get(DayOfWeek.WEDNESDAY).closingTime());
        openingHoursBean.add(timeSlotBean);
        timeSlotBean.setDay(DayOfWeek.THURSDAY);
        timeSlotBean.setOpeningTime(seller.getOpeningTimes().get(DayOfWeek.THURSDAY).openingTime());
        timeSlotBean.setClosingTime(seller.getOpeningTimes().get(DayOfWeek.THURSDAY).closingTime());
        openingHoursBean.add(timeSlotBean);
        timeSlotBean.setDay(DayOfWeek.FRIDAY);
        timeSlotBean.setOpeningTime(seller.getOpeningTimes().get(DayOfWeek.FRIDAY).openingTime());
        timeSlotBean.setClosingTime(seller.getOpeningTimes().get(DayOfWeek.FRIDAY).closingTime());
        openingHoursBean.add(timeSlotBean);
        timeSlotBean.setDay(DayOfWeek.SATURDAY);
        timeSlotBean.setOpeningTime(seller.getOpeningTimes().get(DayOfWeek.SATURDAY).openingTime());
        timeSlotBean.setClosingTime(seller.getOpeningTimes().get(DayOfWeek.SATURDAY).closingTime());
        openingHoursBean.add(timeSlotBean);
        timeSlotBean.setDay(DayOfWeek.SUNDAY);
        timeSlotBean.setOpeningTime(seller.getOpeningTimes().get(DayOfWeek.SUNDAY).openingTime());
        timeSlotBean.setClosingTime(seller.getOpeningTimes().get(DayOfWeek.SUNDAY).closingTime());
        openingHoursBean.add(timeSlotBean);
        sellerBean.setOpeningHours(openingHoursBean);

        return sellerBean;
    }

    @Override
    public Seller toEntity(SellerBean bean) {
        //so long not needed, so long not implemented
        return null;
    }
}
