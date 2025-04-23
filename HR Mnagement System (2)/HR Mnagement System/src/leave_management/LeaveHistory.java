package leave_management;

import javax.swing.*;
import java.sql.*;

public class LeaveHistory extends JFrame {
    public LeaveHistory() {
        setTitle("All Leave History");

        JTextArea result = new JTextArea();
        result.setEditable(false);
        JScrollPane scroll = new JScrollPane(result);
        scroll.setBounds(10, 10, 360, 300);

        JButton back = new JButton("Back");
        back.setBounds(150, 320, 100, 30);

        add(scroll);
        add(back);

        // Fetch leave history
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT id, employee_id, leave_type, from_date, to_date, status FROM leaves";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("ID: ").append(rs.getInt("id"))
                  .append(", EmpID: ").append(rs.getString("employee_id"))
                  .append(", Type: ").append(rs.getString("leave_type"))
                  .append(", From: ").append(rs.getDate("from_date"))
                  .append(", To: ").append(rs.getDate("to_date"))
                  .append(", Status: ").append(rs.getString("status"))
                  .append("\n");
            }

            result.setText(sb.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        back.addActionListener(e -> {
            dispose();
            new MainMenu();
        });

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }
}
