package eascpkg;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttendanceMarkingApp extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel cardPanel, selectionPanel, tablePanel;
    private JComboBox<String> dayOrderCombo, classCombo, sectionCombo;
    private JTable attendanceTable;
    private DefaultTableModel tableModel;

    public AttendanceMarkingApp() {
        // Frame settings
        setTitle("Faculty Attendance Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Selection Panel (Day Order, Class, Section)
        selectionPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel dayOrderLabel = new JLabel("Day Order:");
        dayOrderCombo = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
        JLabel classLabel = new JLabel("Class:");
        classCombo = new JComboBox<>(new String[]{"Class A", "Class B", "Class C"});
        JLabel sectionLabel = new JLabel("Section:");
        sectionCombo = new JComboBox<>(new String[]{"Section 1", "Section 2", "Section 3"});

        JButton showTableButton = new JButton("Show Student List");

        // Add components to selection panel
        selectionPanel.add(dayOrderLabel);
        selectionPanel.add(dayOrderCombo);
        selectionPanel.add(classLabel);
        selectionPanel.add(classCombo);
        selectionPanel.add(sectionLabel);
        selectionPanel.add(sectionCombo);
        selectionPanel.add(new JLabel()); // Empty placeholder
        selectionPanel.add(showTableButton);

        // Table Panel
        tablePanel = new JPanel(new BorderLayout());

        // Columns: S.No, Student ID, Student Name, Attendance
        String[] columnNames = {"S.No", "Student ID", "Student Name", "Attendance"};
        tableModel = new DefaultTableModel(columnNames, 0);
        attendanceTable = new JTable(tableModel) {
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 3 ? Boolean.class : String.class;
            }
        };

        JScrollPane tableScrollPane = new JScrollPane(attendanceTable);
        JButton submitButton = new JButton("Submit Attendance");

        tablePanel.add(tableScrollPane, BorderLayout.CENTER);
        tablePanel.add(submitButton, BorderLayout.SOUTH);

        // Card layout: add both panels
        cardPanel.add(selectionPanel, "SelectionPanel");
        cardPanel.add(tablePanel, "TablePanel");

        add(cardPanel);

        // Show the table when the "Show Student List" button is clicked
        showTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                populateStudentTable();
                cardLayout.show(cardPanel, "TablePanel");
            }
        });

        // Action for submit button (just for example)
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Attendance submitted successfully!");
            }
        });
    }

    // Method to populate student data into the table
    private void populateStudentTable() {
        // Clear existing rows
        tableModel.setRowCount(0);

        // Sample student data
        String[][] students = {
            {"1", "S001", "John Doe"},
            {"2", "S002", "Jane Smith"},
            {"3", "S003", "Sam Brown"},
        };

        // Add student rows with checkboxes checked by default
        for (String[] student : students) {
            tableModel.addRow(new Object[]{student[0], student[1], student[2], true});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AttendanceMarkingApp().setVisible(true);
        });
    }
}
