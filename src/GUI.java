import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;

public class GUI {

    private Map<String, Friend> friends = new HashMap<>();
    private DefaultTableModel balanceModel;
    private JComboBox<String> payerCombo;

    public void show() {
        JFrame frame = new JFrame("Smart Expense Splitter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        // ----------------- Top Panel: Add Friend -----------------
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createTitledBorder("Add Friend"));
        JTextField friendField = new JTextField(15);
        JButton addFriendButton = new JButton("Add");
        topPanel.add(friendField);
        topPanel.add(addFriendButton);

        // ----------------- Middle Panel: Add Expense -----------------
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(BorderFactory.createTitledBorder("Add Expense"));
        JTextField amountField = new JTextField(10);
        payerCombo = new JComboBox<>();
        JButton addExpenseButton = new JButton("Add Expense");
        middlePanel.add(new JLabel("Amount:"));
        middlePanel.add(amountField);
        middlePanel.add(new JLabel("Paid by:"));
        middlePanel.add(payerCombo);
        middlePanel.add(addExpenseButton);

        // ----------------- Bottom Panel: Balances -----------------
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Balances"));
        balanceModel = new DefaultTableModel(new Object[] { "Friend", "Balance" }, 0);
        JTable balanceTable = new JTable(balanceModel) {
            public Component prepareRenderer(javax.swing.table.TableCellRenderer renderer, int row, int col) {
                Component c = super.prepareRenderer(renderer, row, col);
                if (col == 1) {
                    double val = Double.parseDouble(getValueAt(row, col).toString());
                    c.setForeground(val >= 0 ? Color.GREEN.darker() : Color.RED);
                }
                return c;
            }
        };
        JScrollPane scrollPane = new JScrollPane(balanceTable);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        // ----------------- Add Panels to Frame -----------------
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // ----------------- Add Friend Action -----------------
        addFriendButton.addActionListener(e -> {
            String name = friendField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Enter a name!");
            } else if (friends.containsKey(name)) {
                JOptionPane.showMessageDialog(frame, "Friend already exists!");
            } else {
                friends.put(name, new Friend(name));
                payerCombo.addItem(name); // update dropdown
                JOptionPane.showMessageDialog(frame, name + " added!");
                friendField.setText("");
                updateBalances();
            }
        });

        // ----------------- Add Expense Action -----------------
        addExpenseButton.addActionListener(e -> {
            String amountText = amountField.getText().trim();
            String payerName = (String) payerCombo.getSelectedItem();
            if (amountText.isEmpty() || payerName == null) {
                JOptionPane.showMessageDialog(frame, "Enter amount and select payer!");
                return;
            }
            try {
                double amount = Double.parseDouble(amountText);
                splitExpense(amount, payerName);
                amountField.setText("");
                updateBalances();
                JOptionPane.showMessageDialog(frame, "Expense added and split!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid amount!");
            }
        });

        frame.setVisible(true);
    }

    private void splitExpense(double amount, String payerName) {
        int totalFriends = friends.size();
        double share = amount / totalFriends;

        for (Friend f : friends.values()) {
            if (!f.getName().equals(payerName)) {
                f.subtractBalance(share);
            } else {
                f.addBalance(amount - share);
            }
        }
    }

    private void updateBalances() {
        balanceModel.setRowCount(0); // clear table
        for (Friend f : friends.values()) {
            balanceModel.addRow(new Object[] { f.getName(), String.format("%.2f", f.getBalance()) });
        }
    }
}
