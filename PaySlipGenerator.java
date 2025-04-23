// PaySlipGenerator.java
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class PaySlipGenerator {
    public void generate(int empId, String month, int year) throws SQLException, IOException {
        Connection con = DBConnection.getConnection();
        String query = "SELECT e.name, e.base_salary, a.absent_days, p.net_salary FROM employees e " +
                       "JOIN attendance a ON e.id = a.employee_id " +
                       "JOIN payroll p ON e.id = p.employee_id " +
                       "WHERE e.id = ? AND a.month = ? AND a.year = ? AND p.month = ? AND p.year = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, empId);
        ps.setString(2, month);
        ps.setInt(3, year);
        ps.setString(4, month);
        ps.setInt(5, year);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            FileWriter fw = new FileWriter("Payslip_" + empId + "_" + month + "_" + year + ".txt");
            fw.write("Employee Name: " + rs.getString("name") + "\n");
            fw.write("Base Salary: " + rs.getDouble("base_salary") + "\n");
            fw.write("Absent Days: " + rs.getInt("absent_days") + "\n");
            fw.write("Net Salary: " + rs.getDouble("net_salary") + "\n");
            fw.close();
        }
        con.close();
    }
}
