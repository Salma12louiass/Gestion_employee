//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HolidayView extends JFrame {
    public JTable holidayTable;
    public JButton addButton;
    public JButton listButton;
    public JButton deleteButton;
    public JButton modifyButton;
    public JButton switchViewButton;
    public JComboBox<String> employeeNameComboBox;
    public JTextField startDateField;
    public JTextField endDateField;
    public JComboBox<String> typeCombo;

    public HolidayView() {
        this.setTitle("Gestion des Congés");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(3);
        this.setLayout(new BorderLayout());
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(58, 115, 173));
        JLabel headerLabel = new JLabel("Gestion des Congés", 0);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", 1, 24));
        this.switchViewButton = this.createStyledButton("Gérer les Employés");
        this.switchViewButton.setBackground(new Color(255, 204, 102));
        this.switchViewButton.setForeground(Color.BLACK);
        headerPanel.add(headerLabel, "Center");
        headerPanel.add(this.switchViewButton, "East");
        this.add(headerPanel, "North");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, 1));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 245, 245));
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        inputPanel.setBackground(new Color(245, 245, 245));
        inputPanel.add(new JLabel("Employé Nom Complet:"));
        this.employeeNameComboBox = new JComboBox();
        this.styleComboBox(this.employeeNameComboBox);
        inputPanel.add(this.employeeNameComboBox);
        inputPanel.add(new JLabel("Date Début:"));
        this.startDateField = new JTextField();
        this.styleTextField(this.startDateField);
        inputPanel.add(this.startDateField);
        inputPanel.add(new JLabel("Date Fin:"));
        this.endDateField = new JTextField();
        this.styleTextField(this.endDateField);
        inputPanel.add(this.endDateField);
        inputPanel.add(new JLabel("Type de Congé:"));
        this.typeCombo = new JComboBox(new String[]{"CONGE_PAYE", "CONGE_MALADIE", "CONGE_NON_PAYE"});
        this.styleComboBox(this.typeCombo);
        inputPanel.add(this.typeCombo);
        mainPanel.add(inputPanel);
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        tablePanel.setBackground(Color.WHITE);
        JLabel tableTitle = new JLabel("Liste des Congés", 0);
        tableTitle.setFont(new Font("Arial", 1, 16));
        tablePanel.add(tableTitle, "North");
        this.holidayTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(this.holidayTable);
        tablePanel.add(tableScrollPane, "Center");
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(tablePanel);
        this.add(mainPanel, "Center");
        JPanel buttonPanel = new JPanel(new FlowLayout(1, 15, 10));
        buttonPanel.setBackground(new Color(240, 240, 240));
        this.addButton = this.createStyledButton("Ajouter");
        buttonPanel.add(this.addButton);
        this.listButton = this.createStyledButton("Afficher");
        buttonPanel.add(this.listButton);
        this.deleteButton = this.createStyledButton("Supprimer");
        buttonPanel.add(this.deleteButton);
        this.modifyButton = this.createStyledButton("Modifier");
        buttonPanel.add(this.modifyButton);
        this.add(buttonPanel, "South");
    }

    private void styleTextField(JTextField textField) {
        textField.setFont(new Font("Arial", 0, 14));
        textField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }

    private void styleComboBox(JComboBox<String> comboBox) {
        comboBox.setFont(new Font("Arial", 0, 14));
        comboBox.setBackground(Color.WHITE);
        comboBox.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
    }

    private JButton createStyledButton(String text) {
        final JButton button = new JButton(text);
        button.setFont(new Font("Arial", 0, 14));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(Cursor.getPredefinedCursor(12));
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(100, 160, 210));
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180));
            }
        });
        return button;
    }
}
