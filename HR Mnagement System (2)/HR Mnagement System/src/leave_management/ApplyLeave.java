package leave_management;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ApplyLeave extends JFrame {
    public ApplyLeave() {
        setTitle("Apply for Leave");

        JLabel l1 = new JLabel("Employee ID:");
        JLabel l2 = new JLabel("Leave Type:");
        JLabel l3 = new JLabel("From Date (YYYY-MM-DD):");
        JLabel l4 = new JLabel("To Date (YYYY-MM-DD):");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JButton apply = new JButton("Apply");
        JButton back = new JButton("Back");

        l1.setBounds(30, 30, 150, 30); t1.setBounds(180, 30, 150, 30);
        l2.setBounds(30, 70, 150, 30); t2.setBounds(180, 70, 150, 30);
        l3.setBounds(30, 110, 150, 30); t3.setBounds(180, 110, 150, 30);
        l4.setBounds(30, 150, 150, 30); t4.setBounds(180, 150, 150, 30);
        apply.setBounds(100, 200, 100, 30);
        back.setBounds(210, 200, 100, 30);

        add(l1); add(t1); add(l2); add(t2); add(l3); add(t3); add(l4); add(t4); add(apply); add(back);

        apply.addActionListener(e -> {
            try (Connection conn = DBUtil.getConnection()) {
                String sql = "INSERT INTO leaves (employee_id, leave_type, from_date, to_date, status) VALUES (?, ?, ?, ?, 'Pending')";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, t1.getText());
                pst.setString(2, t2.getText());
                pst.setString(3, t3.getText());
                pst.setString(4, t4.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Leave Applied Successfully!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

        back.addActionListener(e -> {
            dispose();
            new MainMenu();
        });

        setSize(400, 300);-
        setLayout(null);
        setVisible(true);
    }
}
