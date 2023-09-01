package com.bankRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/bloodmanagement";
    private static final String dbUser = "root";
    private static final String dbPassword = "student";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
    }
    
    public static BloodStock getBloodStock(String bloodBankUsername) {
        BloodStock bloodStock = new BloodStock();
        try (Connection connection = getConnection()) {
            // Write SQL query to fetch blood stock data for the given bloodBankUsername
            String query = "SELECT * FROM blood_stock WHERE blood_bank_username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bloodBankUsername);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bloodStock.setA_positive(resultSet.getInt("a_positive"));
                bloodStock.setB_positive(resultSet.getInt("b_positive"));
                bloodStock.setAB_positive(resultSet.getInt("ab_positive"));
                bloodStock.setO_positive(resultSet.getInt("o_positive"));
                bloodStock.setA_negative(resultSet.getInt("a_negative"));
                bloodStock.setB_negative(resultSet.getInt("b_negative"));
                bloodStock.setAB_negative(resultSet.getInt("ab_negative"));
                bloodStock.setO_negative(resultSet.getInt("o_negative"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bloodStock;
    }
}
