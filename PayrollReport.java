// PayrollReport.java
import java.sql.*;

public class PayrollReport {
    public void viewMonthlyReport(String month, int year) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "SELECT e.name, p.net_salary FROM payroll p JOIN employees e ON e.id = p.employee_id WHERE p.month = ? AND p.year = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, month);
        ps.setInt(2, year);
        ResultSet rs = ps.executeQuery();

        System.out.println("Payroll Report - " + month + "/" + year);
        while (rs.next()) {
            System.out.println("Employee: " + rs.getString("name") + " | Net Salary: " + rs.getDouble("net_salary"));
        }
        con.close();
    }
}

