package com.orto.test;

import com.orto.logic.utils.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DBConnectionTest {
    @Test
    public void testGetConnection() {
        try (Connection conn = DBConnection.getConnection()) {
            assertNotNull(conn);
            assertFalse(conn.isClosed());
        } catch (SQLException e) {
            assertNull(e.getMessage());
        }
    }
}
