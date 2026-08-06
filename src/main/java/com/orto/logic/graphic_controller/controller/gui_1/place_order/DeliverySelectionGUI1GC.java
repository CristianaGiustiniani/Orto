package com.orto.logic.graphic_controller.controller.gui_1.place_order;

import com.orto.logic.graphic_controller.bean.AddressBean;
import com.orto.logic.graphic_controller.bean.DeliveryBean;
import com.orto.logic.graphic_controller.bean.exceptions.InvalidStringException;
import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.graphic_controller.controller.exceptions.InvalidDeliveryInfoException;
import com.orto.logic.graphic_controller.controller.mapper.DeliveryMapper;
import com.orto.logic.model.entity.Address;
import com.orto.logic.model.entity.Delivery;
import com.orto.logic.model.entity.Seller;
import com.orto.logic.utils.DeliveryType;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DeliverySelectionGUI1GC extends GUIGC {
    //ATTRIBUTES
    Seller seller;

    //FXML ATTRIBUTES
    @FXML private TextField inputBuyerName;
    @FXML private TextField inputBuyerSurname;
    @FXML private TextField inputBuyerStreetName;
    @FXML private TextField inputBuyerCivicNumber;
    @FXML private TextField inputBuyerPostalCode;
    @FXML private TextField inputBuyerCity;
    @FXML private TextField inputBuyerProvince;
    @FXML private TextField inputBuyerCountry;
    @FXML private TextField inputBuyerPhoneNumber;
    @FXML private Text textShipping;
    @FXML private Text textPickup;
    @FXML private Text textBuyerName;
    @FXML private Text textBuyerSurname;
    @FXML private Text textBuyerStreetName;
    @FXML private Text textBuyerCivicNumber;
    @FXML private Text textBuyerPostalCode;
    @FXML private Text textBuyerCity;
    @FXML private Text textBuyerProvince;
    @FXML private Text textBuyerCountry;
    @FXML private Text textBuyerPhoneNumber;
    @FXML private Text textSellerName;
    @FXML private Text textSellerAddress;
    @FXML private Text textOpeningHours;
    @FXML private Text textMonday;
    @FXML private Text textTuesday;
    @FXML private Text textWednesday;
    @FXML private Text textThursday;
    @FXML private Text textFriday;
    @FXML private Text textSaturday;
    @FXML private Text textSunday;
    @FXML private Text textMondayOpeningTime;
    @FXML private Text textTuesdayOpeningTime;
    @FXML private Text textWednesdayOpeningTime;
    @FXML private Text textThursdayOpeningTime;
    @FXML private Text textFridayOpeningTime;
    @FXML private Text textSaturdayOpeningTime;
    @FXML private Text textSundayOpeningTime;
    @FXML private Text textMondayClosingTime;
    @FXML private Text textTuesdayClosingTime;
    @FXML private Text textWednesdayClosingTime;
    @FXML private Text textThursdayClosingTime;
    @FXML private Text textFridayClosingTime;
    @FXML private Text textSaturdayClosingTime;
    @FXML private Text textSundayClosingTime;
    @FXML private Text textFrom0;
    @FXML private Text textFrom1;
    @FXML private Text textFrom2;
    @FXML private Text textFrom3;
    @FXML private Text textFrom4;
    @FXML private Text textFrom5;
    @FXML private Text textFrom6;
    @FXML private Text textTo0;
    @FXML private Text textTo1;
    @FXML private Text textTo2;
    @FXML private Text textTo3;
    @FXML private Text textTo4;
    @FXML private Text textTo5;
    @FXML private Text textTo6;
    @FXML private RadioButton radioShippingDelivery;
    @FXML private RadioButton radioPickupDelivery;
    @FXML private Label labelError;
    @FXML private Label labelProductSelection;
    @FXML private Label labelDelivery;
    @FXML private Label labelPayment;
    @FXML private Label labelSummary;


    //CONSTRUCTOR
    public DeliverySelectionGUI1GC(Seller seller) {
        super("/views/views1/form/buyer/placeOrderElements/DeliverySelection.fxml");
        this.seller = seller;
        root = load();
        ToggleGroup group = new ToggleGroup();
        radioPickupDelivery.setToggleGroup(group);
        radioShippingDelivery.setToggleGroup(group);
        radioShippingDelivery.setSelected(true);
        setupTexts();
    }

    //INPUT METHODS
    public Delivery getDeliveryInfo() throws InvalidDeliveryInfoException {
        labelError.setVisible(false);

        DeliveryBean deliveryBean = new DeliveryBean();
        AddressBean addressBean = new AddressBean();
        if (radioShippingDelivery.isSelected()) {
            deliveryBean.setDeliveryType(DeliveryType.SHIPPING);
            deliveryBean.setRecipientName(inputBuyerName.getText());
            deliveryBean.setRecipientSurname(inputBuyerSurname.getText());
            addressBean.setStreetName(inputBuyerStreetName.getText());
            addressBean.setCivicNumber(inputBuyerCivicNumber.getText());
            addressBean.setPostalCode(inputBuyerPostalCode.getText());
            addressBean.setCity(inputBuyerCity.getText());
            addressBean.setProvince(inputBuyerProvince.getText());
            addressBean.setCountry(inputBuyerCountry.getText());
            deliveryBean.setAddress(addressBean);
            deliveryBean.setPhoneNumber(inputBuyerPhoneNumber.getText());
        } else if (radioPickupDelivery.isSelected()) {
            deliveryBean.setDeliveryType(DeliveryType.PICKUP);
            deliveryBean.setRecipientName(this.seller.getName());
            addressBean.setStreetName(this.seller.getAddress().getStreet());
            addressBean.setCivicNumber(this.seller.getAddress().getNumber());
            addressBean.setPostalCode(this.seller.getAddress().getPostalCode());
            addressBean.setCity(this.seller.getAddress().getCity());
            addressBean.setProvince(this.seller.getAddress().getProvince());
            addressBean.setCountry(this.seller.getAddress().getCountry());
            deliveryBean.setAddress(addressBean);
        }
        try {
            deliveryBean.validate();
        } catch (InvalidStringException e) {
            throw new InvalidDeliveryInfoException();
        }
        return (new DeliveryMapper()).toEntity(deliveryBean);
    }

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        textShipping.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_SHIPPING"));
        textPickup.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_PICKUP"));
        textBuyerName.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_BUYERNAME"));
        textBuyerSurname.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_BUYERSURNAME"));
        textBuyerStreetName.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_BUYERSTREETNAME"));
        textBuyerCivicNumber.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_BUYERCIVICNUMBER"));
        textBuyerPostalCode.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_BUYERPOSTALCODE"));
        textBuyerCity.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_BUYERCITY"));
        textBuyerProvince.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_BUYERPROVINCE"));
        textBuyerCountry.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_BUYERCOUNTRY"));
        textBuyerPhoneNumber.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_BUYERPHONE"));
        textSellerName.setText(seller.getName());
        textSellerAddress.setText(toString(seller.getAddress()));
        textOpeningHours.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_OPENINGHOURS"));
        textMonday.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_MONDAY"));
        textTuesday.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_TUESDAY"));
        textWednesday.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_WEDNESDAY"));
        textThursday.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_THURSDAY"));
        textFriday.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_FRIDAY"));
        textSaturday.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_SATURDAY"));
        textSunday.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_SUNDAY"));
        textMondayOpeningTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.MONDAY).openingTime()));
        textTuesdayOpeningTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.TUESDAY).openingTime()));
        textWednesdayOpeningTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.WEDNESDAY).openingTime()));
        textThursdayOpeningTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.THURSDAY).openingTime()));
        textFridayOpeningTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.FRIDAY).openingTime()));
        textSaturdayOpeningTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.SATURDAY).openingTime()));
        textSundayOpeningTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.SUNDAY).openingTime()));
        textMondayClosingTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.MONDAY).closingTime()));
        textTuesdayClosingTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.TUESDAY).closingTime()));
        textWednesdayClosingTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.WEDNESDAY).closingTime()));
        textThursdayClosingTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.THURSDAY).closingTime()));
        textFridayClosingTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.FRIDAY).closingTime()));
        textSaturdayClosingTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.SATURDAY).closingTime()));
        textSundayClosingTime.setText(toString(seller.getOpeningTimes().get(DayOfWeek.SUNDAY).closingTime()));
        final String from = I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_FROM");
        textFrom0.setText(from);
        textFrom1.setText(from);
        textFrom2.setText(from);
        textFrom3.setText(from);
        textFrom4.setText(from);
        textFrom5.setText(from);
        textFrom6.setText(from);
        final String to = I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_TO");
        textTo0.setText(to);
        textTo1.setText(to);
        textTo2.setText(to);
        textTo3.setText(to);
        textTo4.setText(to);
        textTo5.setText(to);
        textTo6.setText(to);
        labelProductSelection.setText(I18n.t("STEP_PRODUCT_SELECTION"));
        labelDelivery.setText(I18n.t("STEP_PAYMENT_SELECTION"));
        labelPayment.setText(I18n.t("STEP_DELIVERY_SELECTION"));
        labelSummary.setText(I18n.t("STEP_ORDER_SUMMARY"));
    }

    public void showError(Exception e) {
        if (e instanceof InvalidDeliveryInfoException) {
            labelError.setText(I18n.t("ERROR_PLACEORDER_DELIVERYSELECTION_INVALIDDELIVERYINFO"));
        } else {
            labelError.setText(e.getMessage());
        }
        labelError.setVisible(true);
    }

    private String toString(Address address) {
        return (address.getStreet() + ", " +
                address.getNumber() + ", " +
                address.getPostalCode() + ", " +
                address.getCity() +
                " (" + address.getProvince() + "), " +
                address.getCountry());
    }

    private String toString(LocalTime time) {
        return time.toString().substring(0, 5);
    }

}
