import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SetSalaryUI extends JFrame {

    public SetSalaryUI() {
        setTitle("Set Salary");

        // Components declared before usage
        JTextField empIdField = new JTextField();
        JTextField salaryField = new JTextField();
        JButton saveBtn = new JButton("Save");
        JButton backBtn = new JButton("Back");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        panel.add(new JLabel("Employee ID:"));
        panel.add(empIdField);
        panel.add(new JLabel("Salary Amount:"));
        panel.add(salaryField);
        panel.add(saveBtn);
        panel.add(backBtn);

        // Save Button logic with DB interaction
        saveBtn.addActionListener(e -> {
            String empId = empIdField.getText();
            String salary = salaryField.getText();

            try (Connection conn = DBConnection.getConnection()) {
                String query = "INSERT INTO salary (e_id, amount, date_set) VALUES (?, ?, CURDATE())";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(empId));
                ps.setDouble(2, Double.parseDouble(salary));
                int rows = ps.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Salary set successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to set salary.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Back button logic
        backBtn.addActionListener(e -> {
            dispose();
            new MainUI();
        });

        add(panel);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
