import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class App {

    static class Friend {
        String name;
        double balance;

        Friend(String name) {
            this.name = name;
            this.balance = 0.0;
        }
    }

    static Map<String, Friend> friends = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::createAndShowGUI);
    }

    static void createAndShowGUI() {
        JFrame frame = new JFrame("Smart Expense Splitter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        // Top Panel - Add Friend
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createTitledBorder("Add Friend"));
        JTextField friendField = new JTextField(15);
        JButton addFriendButton = new JButton("Add");
        topPanel.add(friendField);
        topPanel.add(addFriendButton);

        // Middle Panel - placeholder for Add Expense
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(BorderFactory.createTitledBorder("Add Expense"));
        middlePanel.add(new JLabel("Coming Soon"));

        // Bottom Panel - placeholder for Balances
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Balances"));
        bottomPanel.add(new JLabel("Coming Soon"));

        // Add panels to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Add Friend Button Action
        addFriendButton.addActionListener(e -> {
            String name = friendField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Enter a name!");
            } else if (friends.containsKey(name)) {
                JOptionPane.showMessageDialog(frame, "Friend already exists!");
            } else {
                friends.put(name, new Friend(name));
                JOptionPane.showMessageDialog(frame, name + " added!");
                friendField.setText("");
            }
        });

        frame.setVisible(true);
    }
}
