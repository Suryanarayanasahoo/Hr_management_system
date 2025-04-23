import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GenerateSlipUI extends JFrame {

    public GenerateSlipUI() {
        setTitle("Generate Pay Slip");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel empIdLabel = new JLabel("Employee ID:");
        JTextField empIdField = new JTextField();

        JButton generateBtn = new JButton("Generate");
        JButton backBtn = new JButton("Back");

        panel.add(empIdLabel);
        panel.add(empIdField);
        panel.add(generateBtn);
        panel.add(backBtn);

        generateBtn.addActionListener(e -> {
            // Implement pay slip logic here
            JOptionPane.showMessageDialog(this, "Pay slip generated.");
        });

        backBtn.addActionListener(e -> {
            dispose();
            new MainUI();
        });

        add(panel);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
