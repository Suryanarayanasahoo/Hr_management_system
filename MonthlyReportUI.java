import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MonthlyReportUI extends JFrame {

    public MonthlyReportUI() {
        setTitle("Monthly Report");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setText("Monthly report will appear here...");

        JScrollPane scrollPane = new JScrollPane(reportArea);

        JButton backBtn = new JButton("Back");

        backBtn.addActionListener(e -> {
            dispose();
            new MainUI();
        });

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(backBtn, BorderLayout.SOUTH);

        add(panel);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
