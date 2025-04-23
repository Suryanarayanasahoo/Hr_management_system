package leave_management;

import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Leave Management System - Main Menu");

        JButton applyLeaveBtn = new JButton("Apply for Leave");
        JButton viewStatusBtn = new JButton("View Leave Status");
        JButton approveRejectBtn = new JButton("Approve/Reject Leave");
        JButton historyBtn = new JButton("Leave History");
        JButton exitBtn = new JButton("Exit");

        applyLeaveBtn.setBounds(100, 30, 200, 30);
        viewStatusBtn.setBounds(100, 70, 200, 30);
        approveRejectBtn.setBounds(100, 110, 200, 30);
        historyBtn.setBounds(100, 150, 200, 30);
        exitBtn.setBounds(100, 190, 200, 30);

        add(applyLeaveBtn);
        add(viewStatusBtn);
        add(approveRejectBtn);
        add(historyBtn);
        add(exitBtn);

        applyLeaveBtn.addActionListener(e -> {
            dispose();
            new ApplyLeave();
        });

        viewStatusBtn.addActionListener(e -> {
            dispose();
            new ViewLeaveStatus();
        });

        approveRejectBtn.addActionListener(e -> {
            dispose();
            new ApproveRejectLeave();
        });

        historyBtn.addActionListener(e -> {
            dispose();
            new LeaveHistory();
        });

        exitBtn.addActionListener(e -> System.exit(0));

        setSize(420, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MainMenu();
    }
}

