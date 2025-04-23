package leave_management;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ApproveRejectLeave extends JFrame {
    public ApproveRejectLeave() {
        setTitle("Approve/Reject Leave");

        JLabel l1 = new JLabel("Leave ID:");
        JLabel l2 = new JLabel("Action:");

        JTextField t1 = new JTextField();
        JComboBox<String> actionBox = new JComboBox<>(new String[]{"Approve", "Reject"});

        JButton process = new JButton("Process");
        JButton back = new JButton("Back");

        l1.setBounds(30, 30, 100, 30); t1.setBounds(150, 30, 150, 30);
        l2.setBounds(30, 70, 100, 30); actionBox.setBounds(150, 70, 150, 30);
        process.setBounds(80, 120, 100, 30);
        back.setBounds(190, 120, 100, 30);

        add(l1); add(t1); add(l2); add(actionBox); add(process); add(back);

        process.addActionListener(e -> {
            try (Connection conn = DBUtil.getConnection()) {
                String sql = "UPDATE leaves SET status = ? WHERE id = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, actionBox.getSelectedItem().toString());
                pst.setInt(2, Integer.parseInt(t1.getText()));
                int result = pst.executeUpdate();

                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Leave status updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Leave ID not found.");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

        back.addActionListener(e -> {
            dispose();
            new MainMenu();
        });

        setSize(400, 250);
        setLayout(null);
        setVisible(true);
    }
}
