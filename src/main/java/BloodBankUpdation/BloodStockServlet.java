package BloodBankUpdation;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BloodStockServlet")
public class BloodStockServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Database connection details
        String jdbcUrl = "jdbc:mysql://localhost:3306/bloodmanagement";
        String dbUser = "root";
        String dbPassword = "student";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodmanagement", "root","student");

            String insertQuery = "INSERT INTO bloodstock (`A+`, `B+`, `AB+`, `O+`, `A-`, `B-`, `AB-`, `O-`) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // Prepare the SQL statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set the parameters based on form input
            preparedStatement.setInt(1, Integer.parseInt(request.getParameter("groupA")));
            preparedStatement.setInt(2, Integer.parseInt(request.getParameter("groupB")));
            preparedStatement.setInt(3, Integer.parseInt(request.getParameter("groupAB")));
            preparedStatement.setInt(4, Integer.parseInt(request.getParameter("groupO")));
            preparedStatement.setInt(5, Integer.parseInt(request.getParameter("groupANeg")));
            preparedStatement.setInt(6, Integer.parseInt(request.getParameter("groupBNeg")));
            preparedStatement.setInt(7, Integer.parseInt(request.getParameter("groupABNeg")));
            preparedStatement.setInt(8, Integer.parseInt(request.getParameter("groupONeg")));

            // Execute the insert query
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                // Redirect to a success page or display a success message
                response.sendRedirect("success");
            } else {
                // Display an error message
                response.getWriter().write("Failed to insert blood stock.");
            }

            // Close the resources
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions here
        }
    }
}
