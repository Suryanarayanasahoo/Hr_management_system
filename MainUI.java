import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {

    public MainUI() {
        setTitle("Payroll Management System");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton setSalaryBtn = new JButton("Set Salary");
        JButton generateSlipBtn = new JButton("Generate Pay Slip");
        JButton reportBtn = new JButton("Monthly Report");
        JButton exitBtn = new JButton("Exit");

        // Add buttons to the panel with spacing
        for (JButton btn : new JButton[]{setSalaryBtn, generateSlipBtn, reportBtn, exitBtn}) {
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(250, 30));
            panel.add(btn);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // Action listeners for buttons
        setSalaryBtn.addActionListener(e -> {
            dispose();
            new SetSalaryUI(); // Create this class
        });

        generateSlipBtn.addActionListener(e -> {
            dispose();
            new GenerateSlipUI(); // Create this class
        });

        reportBtn.addActionListener(e -> {
            dispose();
            new MonthlyReportUI(); // Create this class
        });

        exitBtn.addActionListener(e -> System.exit(0));

        add(panel);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainUI::new);
    }
}
