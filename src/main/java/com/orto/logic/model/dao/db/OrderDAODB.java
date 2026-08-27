package com.orto.logic.model.dao.db;

import com.orto.logic.model.dao.OrderDAO;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.entity.Order;
import com.orto.logic.model.entity.OrderLine;
import com.orto.logic.utils.DBConnection;
import com.orto.logic.utils.SessionManager;
import com.orto.logic.utils.exceptions.IllegalNullUserException;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class OrderDAODB implements OrderDAO {
    @Override
    public void createOrder(Order order) throws ConnectionException {
        String query1 = "INSERT INTO `order` (buyer, seller, paymentType, paymentStatus, totalPrice, status) VALUES (?, ?, ?, ?, ?, ?)";
        String query2 = "INSERT INTO delivery (orderId, type, recipientName, recipientSurname, addressName, addressNumber, addressPostalCode, addressCity, addressProvince, addressCountry, phoneNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String query3 = "INSERT INTO orderline (orderId, productId, quantity, annotation) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps1 = conn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement ps2 = conn.prepareStatement(query2);
             PreparedStatement ps3 = conn.prepareStatement(query3)) {

            //Insert order
            ps1.setInt(1, SessionManager.getInstance().getLoggedUser().getId());
            ps1.setInt(2, order.getSeller().getId());
            ps1.setString(3, order.getPaymentInfo().getPaymentType().toString().toLowerCase());
            ps1.setString(4, order.getPaymentInfo().getPaymentStatus().toString().toLowerCase());
            ps1.setBigDecimal(5, order.getTotalPrice());
            ps1.setString(6, order.getStatus().toString().toLowerCase());
            int rows = ps1.executeUpdate();

            //Get order id
            if (rows > 0) {
                try (ResultSet rs = ps1.getGeneratedKeys()) {
                    if (rs.next()) {
                        order.setId(rs.getInt(1));
                    }
                }
            }

            //Insert delivery information
            ps2.setInt(1, order.getId());
            ps2.setString(2, order.getDeliveryInfo().getDeliveryType().toString().toLowerCase());
            ps2.setString(3, order.getDeliveryInfo().getRecipientName());
            ps2.setString(4, order.getDeliveryInfo().getRecipientSurname());
            ps2.setString(5, order.getDeliveryInfo().getAddress().getStreet());
            ps2.setString(6, order.getDeliveryInfo().getAddress().getNumber());
            ps2.setString(7, order.getDeliveryInfo().getAddress().getPostalCode());
            ps2.setString(8, order.getDeliveryInfo().getAddress().getCity());
            ps2.setString(9, order.getDeliveryInfo().getAddress().getProvince());
            ps2.setString(10, order.getDeliveryInfo().getAddress().getCountry());
            ps2.setString(11, order.getDeliveryInfo().getPhoneNumber());
            ps2.executeUpdate();

            //Insert order lines
            List<OrderLine> lines = order.getOrderLines();
            for (OrderLine line : lines) {
                ps3.setInt(1, order.getId());
                ps3.setInt(2, line.getProduct().getId());
                ps3.setDouble(3, line.getQuantity());
                ps3.setString(4, line.getAnnotation());
                ps3.addBatch();
            }
            ps3.executeBatch();
        } catch (SQLException e) {
            throw new ConnectionException();
        } catch (IllegalNullUserException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getAllOrders() throws ConnectionException {
        //not implementing this
        return Collections.emptyList();
    }
}
