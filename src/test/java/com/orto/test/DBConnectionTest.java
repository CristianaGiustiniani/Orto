package com.orto.test;

import com.orto.logic.utils.DBConnection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

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
