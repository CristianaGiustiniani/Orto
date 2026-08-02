package com.orto.logic.controller;

import com.orto.logic.model.entity.Order;
import com.orto.logic.model.entity.PaymentInfo;
import com.orto.logic.model.entity.Product;
import com.orto.logic.model.entity.Seller;
import com.orto.logic.graphic_controller.bean.DeliveryBean;
import com.orto.logic.graphic_controller.bean.OrderLineBean;

import java.util.List;

public class PlaceOrderController extends Controller {
    private Order order;
    //todo: implement these

    public void startOrder(Seller seller) {}
    public void confirmProductSelection() {}
    public void confirmDeliverySelection() {}
    public void confirmPaymentSelection() {}
    //todo: in verità la validazione sintattica vorrei fosse fatta dalla boundary
    private void validateProductSelection(List<OrderLineBean> orderLines) {}
    private void validateDeliverySelection(DeliveryBean delivery) {}
    private List<Product> retrieveProducts(Seller seller) {
        return null;
    }
    //todo: capire se prende come param payment o paymentBean
    private boolean processPayment(PaymentInfo payment) {
        return false;
    }
    private void notifySeller(Seller seller) {}

}
