// PayrollManager.java
import java.sql.*;

public class PayrollManager {
    public void calculateAndStorePayroll(int empId, String month, int year) throws SQLException {
        Connection con = DBConnection.getConnection();

        PreparedStatement getEmp = con.prepareStatement("SELECT base_salary FROM employees WHERE id=?");
        getEmp.setInt(1, empId);
        ResultSet empRs = getEmp.executeQuery();
        double baseSalary = 0;
        if (empRs.next()) baseSalary = empRs.getDouble("base_salary");

        PreparedStatement getAbs = con.prepareStatement("SELECT absent_days FROM attendance WHERE employee_id=? AND month=? AND year=?");
        getAbs.setInt(1, empId);
        getAbs.setString(2, month);
        getAbs.setInt(3, year);
        ResultSet absRs = getAbs.executeQuery();
        int absentDays = 0;
        if (absRs.next()) absentDays = absRs.getInt("absent_days");

        double dailyRate = baseSalary / 30;
        double netSalary = baseSalary - (dailyRate * absentDays);

        PreparedStatement insert = con.prepareStatement("INSERT INTO payroll (employee_id, month, year, net_salary) VALUES (?, ?, ?, ?)");
        insert.setInt(1, empId);
        insert.setString(2, month);
        insert.setInt(3, year);
        insert.setDouble(4, netSalary);
        insert.executeUpdate();

        con.close();
    }
}
