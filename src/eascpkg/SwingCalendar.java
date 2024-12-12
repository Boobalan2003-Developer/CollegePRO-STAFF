/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eascpkg;

/**
 *
 * @author booba
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class SwingCalendar {

    public static void main(String[] args) {
        // Create and set up the main frame
        JFrame frame = new JFrame("Swing Calendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a panel to hold the calendar components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Dropdowns for month and year selection
        JComboBox<String> monthComboBox = new JComboBox<>();
        JComboBox<Integer> yearComboBox = new JComboBox<>();

        // Populate month dropdown
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(YearMonth.of(2000, i).getMonth()
                    .getDisplayName(TextStyle.FULL, Locale.getDefault()));
        }

        // Populate year dropdown (e.g., 1980 to 2100)
        for (int i = 1980; i <= 2100; i++) {
            yearComboBox.addItem(i);
        }

        // Set default selection to current month and year
        LocalDate currentDate = LocalDate.now();
        monthComboBox.setSelectedIndex(currentDate.getMonthValue() - 1);
        yearComboBox.setSelectedItem(currentDate.getYear());

        // Panel for month and year selection
        JPanel headerPanel = new JPanel();
        headerPanel.add(monthComboBox);
        headerPanel.add(yearComboBox);
        panel.add(headerPanel, BorderLayout.NORTH);

        // Table to display the calendar
        JTable calendarTable = new JTable();
        String[] columnNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        calendarTable.setModel(tableModel);

        // Disable editing in the table
        calendarTable.setEnabled(false);

        // Add table to the center of the panel
        JScrollPane scrollPane = new JScrollPane(calendarTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Function to update the calendar
        Runnable updateCalendar = () -> {
            int month = monthComboBox.getSelectedIndex() + 1;
            int year = (int) yearComboBox.getSelectedItem();

            // Clear the table model
            tableModel.setRowCount(0);

            // Get the number of days in the selected month and the day of the week for the 1st
            YearMonth yearMonth = YearMonth.of(year, month);
            int daysInMonth = yearMonth.lengthOfMonth();
            int firstDayOfWeek = LocalDate.of(year, month, 1).getDayOfWeek().getValue() % 7;

            // Populate the calendar table
            int day = 1;
            for (int row = 0; day <= daysInMonth; row++) {
                Object[] week = new Object[7];
                for (int col = 0; col < 7; col++) {
                    if (row == 0 && col < firstDayOfWeek) {
                        week[col] = ""; // Empty cells before the 1st day
                    } else if (day <= daysInMonth) {
                        week[col] = day++; // Fill in the days of the month
                    } else {
                        week[col] = ""; // Empty cells after the last day
                    }
                }
                tableModel.addRow(week);
            }
        };

        // Add action listeners to update the calendar when month or year changes
        monthComboBox.addActionListener(e -> updateCalendar.run());
        yearComboBox.addActionListener(e -> updateCalendar.run());

        // Initialize the calendar display
        updateCalendar.run();

        // Add the main panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}

