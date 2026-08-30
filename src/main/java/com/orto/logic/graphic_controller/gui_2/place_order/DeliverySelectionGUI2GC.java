package com.orto.logic.graphic_controller.gui_2.place_order;

import com.orto.logic.controller.bean.AddressBean;
import com.orto.logic.controller.bean.DeliveryBean;
import com.orto.logic.controller.bean.SellerBean;
import com.orto.logic.controller.bean.exceptions.InvalidStringException;
import com.orto.logic.graphic_controller.GUIGC;
import com.orto.logic.graphic_controller.exceptions.InvalidDeliveryInfoException;
import com.orto.logic.utils.DeliveryType;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DeliverySelectionGUI2GC extends GUIGC {
    //ATTRIBUTES
    private final SellerBean seller;

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
    @FXML private TextField inputBuyerPhoneNumberPickup;
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
    @FXML private Text textBuyerPhoneNumberPickup;
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
    @FXML private Text textOpeningTime;
    @FXML private Text textClosingTime;
    @FXML private Text textChoseDelivery;
    @FXML private RadioButton radioShippingDelivery;
    @FXML private RadioButton radioPickupDelivery;
    @FXML private Label labelError;
    @FXML private VBox vboxShipping;
    @FXML private VBox vboxPickup;


    //CONSTRUCTOR
    public DeliverySelectionGUI2GC(SellerBean seller) {
        super("/views/views2/form/buyer/placeOrderElements/DeliverySelection.fxml");
        this.seller = seller;
        root = load();
        ToggleGroup group = new ToggleGroup();
        radioPickupDelivery.setToggleGroup(group);
        radioShippingDelivery.setToggleGroup(group);
        radioShippingDelivery.setSelected(true);
        showShippingForm();

        setupTexts();
    }

    //INPUT METHODS
    @FXML private void onClickRadioShippingDelivery() {
        showShippingForm();
    }

    @FXML private void onClickRadioPickupDelivery() {
        showPickupForm();

    }

    public DeliveryBean getDeliveryInfo() throws InvalidDeliveryInfoException {
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
            addressBean.setStreetName(this.seller.getAddress().getStreetName());
            addressBean.setCivicNumber(this.seller.getAddress().getCivicNumber());
            addressBean.setPostalCode(this.seller.getAddress().getPostalCode());
            addressBean.setCity(this.seller.getAddress().getCity());
            addressBean.setProvince(this.seller.getAddress().getProvince());
            addressBean.setCountry(this.seller.getAddress().getCountry());
            deliveryBean.setAddress(addressBean);
            deliveryBean.setPhoneNumber(inputBuyerPhoneNumberPickup.getText());
        }
        try {
            deliveryBean.validate();
        } catch (InvalidStringException e) {
            throw new InvalidDeliveryInfoException(e);
        }
        return deliveryBean;
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
        textBuyerPhoneNumberPickup.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_BUYERPHONE"));
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
        textMondayOpeningTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.MONDAY).getOpeningTime()));
        textTuesdayOpeningTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.TUESDAY).getOpeningTime()));
        textWednesdayOpeningTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.WEDNESDAY).getOpeningTime()));
        textThursdayOpeningTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.THURSDAY).getOpeningTime()));
        textFridayOpeningTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.FRIDAY).getOpeningTime()));
        textSaturdayOpeningTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.SATURDAY).getOpeningTime()));
        textSundayOpeningTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.SUNDAY).getOpeningTime()));
        textMondayClosingTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.MONDAY).getClosingTime()));
        textTuesdayClosingTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.TUESDAY).getClosingTime()));
        textWednesdayClosingTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.WEDNESDAY).getClosingTime()));
        textThursdayClosingTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.THURSDAY).getClosingTime()));
        textFridayClosingTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.FRIDAY).getClosingTime()));
        textSaturdayClosingTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.SATURDAY).getClosingTime()));
        textSundayClosingTime.setText(toString(seller.getOpeningHours().get(DayOfWeek.SUNDAY).getClosingTime()));
        textOpeningTime.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_OPENINGTIME"));
        textClosingTime.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_CLOSINGTIME"));
        textChoseDelivery.setText(I18n.t("GUI_PLACEORDER_DELIVERYSELECTION_VIEW_CHOSEDELIVERY"));
    }

    public void showError(Exception e) {
        if (e instanceof InvalidDeliveryInfoException) {
            labelError.setText(I18n.t("ERROR_PLACEORDER_DELIVERYSELECTION_INVALIDDELIVERYINFO"));
        } else {
            labelError.setText(e.getMessage());
        }
        labelError.setVisible(true);
    }
    private void showShippingForm() {
        vboxShipping.setVisible(true);
        vboxShipping.setManaged(true);
        vboxPickup.setVisible(false);
        vboxPickup.setManaged(false);
    }

    private void showPickupForm() {
        vboxShipping.setVisible(false);
        vboxShipping.setManaged(false);
        vboxPickup.setVisible(true);
        vboxPickup.setManaged(true);
    }

    private String toString(AddressBean address) {
        return (address.getStreetName() + ", " +
                address.getCivicNumber() + ", " +
                address.getPostalCode() + ", " +
                address.getCity() +
                " (" + address.getProvince() + "), " +
                address.getCountry());
    }

    private String toString(LocalTime time) {
        return time.toString().substring(0, 5);
    }

}
