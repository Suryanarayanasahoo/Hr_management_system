package leave_management;

import java.sql.*;

public class DBUtil {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/hr_management_system";
        String user = "root";
        String password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
