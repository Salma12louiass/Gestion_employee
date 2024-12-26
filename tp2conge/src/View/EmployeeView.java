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

public class EmployeeView extends JFrame {
    public JTable employeeTable;
    public JButton addButton;
    public JButton listButton;
    public JButton deleteButton;
    public JButton modifyButton;
    public JButton switchViewButton;
    public JTextField nameField;
    public JTextField surnameField;
    public JTextField emailField;
    public JTextField phoneField;
    public JTextField salaryField;
    public JComboBox<String> roleCombo;
    public JComboBox<String> posteCombo;

    public EmployeeView() {
        this.setTitle("Gestion des Employés");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(3);
        this.setLayout(new BorderLayout());
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(58, 115, 173));
        JLabel headerLabel = new JLabel("Gestion des Employés", 0);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", 1, 24));
        this.switchViewButton = this.createStyledButton("Gérer les Congés");
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
        inputPanel.add(new JLabel("Nom:"));
        this.nameField = new JTextField();
        this.styleTextField(this.nameField);
        inputPanel.add(this.nameField);
        inputPanel.add(new JLabel("Prénom:"));
        this.surnameField = new JTextField();
        this.styleTextField(this.surnameField);
        inputPanel.add(this.surnameField);
        inputPanel.add(new JLabel("Email:"));
        this.emailField = new JTextField();
        this.styleTextField(this.emailField);
        inputPanel.add(this.emailField);
        inputPanel.add(new JLabel("Téléphone:"));
        this.phoneField = new JTextField();
        this.styleTextField(this.phoneField);
        inputPanel.add(this.phoneField);
        inputPanel.add(new JLabel("Salaire:"));
        this.salaryField = new JTextField();
        this.styleTextField(this.salaryField);
        inputPanel.add(this.salaryField);
        inputPanel.add(new JLabel("Rôle:"));
        this.roleCombo = new JComboBox(new String[]{"Admin", "Employe"});
        this.styleComboBox(this.roleCombo);
        inputPanel.add(this.roleCombo);
        inputPanel.add(new JLabel("Poste:"));
        this.posteCombo = new JComboBox(new String[]{"INGENIEURE_ETUDE_ET_DEVELOPPEMENT", "TEAM_LEADER", "PILOTE"});
        this.styleComboBox(this.posteCombo);
        inputPanel.add(this.posteCombo);
        mainPanel.add(inputPanel);
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        tablePanel.setBackground(Color.WHITE);
        JLabel tableTitle = new JLabel("Liste des Employés", 0);
        tableTitle.setFont(new Font("Arial", 1, 16));
        tablePanel.add(tableTitle, "North");
        this.employeeTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(this.employeeTable);
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
