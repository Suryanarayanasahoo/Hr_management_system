// EmployeeDAO.java
import java.sql.*;
import java.util.*;

public class EmployeeDAO {
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                employees.add(new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("base_salary")
                ));
            }
        }
        return employees;
    }

    public void setBaseSalary(int empId, double salary) throws SQLException {
        String query = "UPDATE employees SET base_salary = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDouble(1, salary);
            ps.setInt(2, empId);
            ps.executeUpdate();
        }
    }
}
