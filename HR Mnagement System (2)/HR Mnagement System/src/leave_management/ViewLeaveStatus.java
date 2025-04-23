package leave_management;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewLeaveStatus extends JFrame {
    public ViewLeaveStatus() {
        setTitle("View Leave Status");

        JLabel l1 = new JLabel("Employee ID:");
        JTextField t1 = new JTextField();
        JButton view = new JButton("View");
        JButton back = new JButton("Back");
        JTextArea result = new JTextArea();
        result.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(result);

        l1.setBounds(30, 30, 100, 30); t1.setBounds(150, 30, 150, 30);
        view.setBounds(80, 70, 100, 30); back.setBounds(190, 70, 100, 30);
        scrollPane.setBounds(30, 120, 320, 200);

        add(l1); add(t1); add(view); add(back); add(scrollPane);

        view.addActionListener(e -> {
            try (Connection conn = DBUtil.getConnection()) {
                String sql = "SELECT leave_type, from_date, to_date, status FROM leaves WHERE employee_id = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, t1.getText());
                ResultSet rs = pst.executeQuery();

                StringBuilder sb = new StringBuilder();
                while (rs.next()) {
                    sb.append("Type: ").append(rs.getString("leave_type"))
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
        });

        back.addActionListener(e -> {
            dispose();
            new MainMenu();
        });

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }
}
