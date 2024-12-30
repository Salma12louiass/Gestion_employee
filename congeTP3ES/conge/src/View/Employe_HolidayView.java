package View;

import DAO.EmployeDAOimpl;
import Model.Employe;
import Model.EmployeModel;
import Model.Post;
import Model.Role;
import Model.Type_holiday;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Employe_HolidayView extends JFrame {
    // Déclarations des composants
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JPanel employeTab = new JPanel();
    private JPanel holidayTab = new JPanel();
    private JPanel Employepan = new JPanel();
    private JPanel Holidaypan = new JPanel();
    private JPanel Display_Table_employe = new JPanel();
    private JPanel Display_Table_holiday = new JPanel();
    private final JPanel Forme_employe = new JPanel();
    private final JPanel Forme_holiday = new JPanel();
    private JPanel panButton_employe = new JPanel();
    private JPanel panButton_holiday = new JPanel();

    private JLabel label_nom = new JLabel("Nom");
    private JLabel label_prenom = new JLabel("Prenom");
    private JLabel label_email = new JLabel("Email");
    private JLabel label_tele = new JLabel("Téléphone");
    private JLabel label_salaire = new JLabel("Salaire");
    private JLabel label_role = new JLabel("Role");
    private JLabel label_poste = new JLabel("Poste");

    private JLabel label_employe = new JLabel("Nom de l'employé");
    private JLabel label_startDate = new JLabel("Date de début (YYYY-MM-DD)");
    private JLabel label_endDate = new JLabel("Date de fin (YYYY-MM-DD)");
    private JLabel label_type = new JLabel("Type");

    private JComboBox<Type_holiday> TypeComboBox = new JComboBox<>(Type_holiday.values());
    private JTextField text_nom = new JTextField();
    private JTextField text_prenom = new JTextField();
    private JTextField text_email = new JTextField();
    private JTextField text_tele = new JTextField();
    private JTextField text_salaire = new JTextField();
    private JComboBox<Role> roleComboBox = new JComboBox<>(Role.values());
    private JComboBox<Post> posteComboBox = new JComboBox<>(Post.values());

    private JComboBox<String> text_employe = new JComboBox<>();
    private JTextField text_startDate = new JTextField("");
    private JTextField text_endDate = new JTextField("");

    private JButton addButton_employe = new JButton("Ajouter");
    private JButton updateButton_employe = new JButton("Modifier");
    private JButton deleteButton_employe = new JButton("Supprimer");
    private JButton displayButton_employe = new JButton("Afficher");
    private JButton importer = new JButton("Importer");
    private JButton exporter = new JButton("Exporter");

    private JButton addButton_holiday = new JButton("Ajouter");
    private JButton updateButton_holiday = new JButton("Modifier");
    private JButton deleteButton_holiday = new JButton("Supprimer");
    private JButton displayButton_holiday = new JButton("Afficher");

    JPanel pan0 = new JPanel(new BorderLayout());
    public static String[] columnNames_employe = {"ID", "Nom", "Prenom", "Email", "Téléphone", "Salaire", "Role", "Poste", "Solde"};
    public static DefaultTableModel tableModel = new DefaultTableModel(columnNames_employe, 0);
    public static JTable Tableau = new JTable(tableModel);

    JPanel pan1 = new JPanel(new BorderLayout());
    public static String[] columnNames_holiday = {"ID", "Nom Employé", "Date Début", "Date Fin", "Type"};
    public static DefaultTableModel tableModel1 = new DefaultTableModel(columnNames_holiday, 0);
    public static JTable Tableau1 = new JTable(tableModel1);

    public Employe_HolidayView() {
        setTitle("Gestion des Employés et des Congés");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Couleurs principales
        Color primaryColor = new Color(70, 130, 180); // Bleu
        Color secondaryColor = Color.WHITE;          // Blanc
        Color buttonColor = new Color(30, 144, 255); // Bleu vif

        getContentPane().setBackground(secondaryColor);

        // Configurer le titre de la fenêtre
        JLabel titleLabel = new JLabel("Gestion des Employés et Congés", JLabel.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(primaryColor);
        titleLabel.setForeground(secondaryColor);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setPreferredSize(new Dimension(1000, 50));
        add(titleLabel, BorderLayout.NORTH);

        add(tabbedPane);

        configureTab(employeTab, Employepan, Display_Table_employe, Tableau, panButton_employe, Forme_employe, true, buttonColor);
        configureTab(holidayTab, Holidaypan, Display_Table_holiday, Tableau1, panButton_holiday, Forme_holiday, false, buttonColor);

        tabbedPane.addTab("Employé", employeTab);
        tabbedPane.addTab("Congés", holidayTab);

        remplaire_les_employes();
        setVisible(true);
    }

    private void configureTab(JPanel tab, JPanel mainPanel, JPanel displayTablePanel, JTable table, JPanel buttonPanel, JPanel formPanel, boolean isEmployeTab, Color buttonColor) {
        tab.setLayout(new BorderLayout());
        tab.add(mainPanel, BorderLayout.CENTER);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(displayTablePanel, BorderLayout.CENTER);
        table.setFillsViewportHeight(true);
        table.setPreferredScrollableViewportSize(new Dimension(900, 500));
        JPanel tableContainer = new JPanel(new BorderLayout());
        tableContainer.add(new JScrollPane(table), BorderLayout.CENTER);
        displayTablePanel.add(tableContainer);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        if (isEmployeTab) {
            styleButton(addButton_employe, buttonColor);
            styleButton(updateButton_employe, buttonColor);
            styleButton(deleteButton_employe, buttonColor);
            styleButton(displayButton_employe, buttonColor);
            styleButton(importer, buttonColor);
            styleButton(exporter, buttonColor);

            buttonPanel.add(addButton_employe);
            buttonPanel.add(updateButton_employe);
            buttonPanel.add(deleteButton_employe);
            buttonPanel.add(displayButton_employe);
            buttonPanel.add(importer);
            buttonPanel.add(exporter);
        } else {
            styleButton(addButton_holiday, buttonColor);
            styleButton(updateButton_holiday, buttonColor);
            styleButton(deleteButton_holiday, buttonColor);
            styleButton(displayButton_holiday, buttonColor);

            buttonPanel.add(addButton_holiday);
            buttonPanel.add(updateButton_holiday);
            buttonPanel.add(deleteButton_holiday);
            buttonPanel.add(displayButton_holiday);
        }

        mainPanel.add(formPanel, BorderLayout.NORTH);
        formPanel.setLayout(new GridLayout(isEmployeTab ? 7 : 4, 2, 10, 10));

        if (isEmployeTab) {
            addFormFields(formPanel, label_nom, text_nom);
            addFormFields(formPanel, label_prenom, text_prenom);
            addFormFields(formPanel, label_email, text_email);
            addFormFields(formPanel, label_tele, text_tele);
            addFormFields(formPanel, label_salaire, text_salaire);
            addFormFields(formPanel, label_role, roleComboBox);
            addFormFields(formPanel, label_poste, posteComboBox);
        } else {
            addFormFields(formPanel, label_employe, text_employe);
            addFormFields(formPanel, label_startDate, text_startDate);
            addFormFields(formPanel, label_endDate, text_endDate);
            addFormFields(formPanel, label_type, TypeComboBox);
        }
    }

    private void addFormFields(JPanel panel, JLabel label, JComponent input) {
        panel.add(label);
        panel.add(input);
    }

    private void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }

    public void remplaire_les_employes() {
        List<Employe> Employes = new EmployeModel(new EmployeDAOimpl()).displayEmploye();
        text_employe.removeAllItems();
        for (Employe elem : Employes) {
            text_employe.addItem(elem.getId() + " - " + elem.getNom() + " " + elem.getPrenom());
        }
    }

// Getters
    public int getId_employe() {
        return Integer.parseInt(text_employe.getSelectedItem().toString().split(" - ")[0]);
    }

    public String getNom() {
        return text_nom.getText();
    }

    public JTable getTable() {
        return (JTable) Display_Table_employe.getComponent(0);
    }

    public String getPrenom() {
        return text_prenom.getText();
    }

    public String getEmail() {
        return text_email.getText();
    }

    public String getTelephone() {
        return text_tele.getText();
    }

    public double getSalaire() {
        return Double.parseDouble(text_salaire.getText());
    }

    public Role getRole() {
        return (Role) roleComboBox.getSelectedItem();
    }

    public Post getPoste() {
        return (Post) posteComboBox.getSelectedItem();
    }

    public JButton getaddButton_employe() {
        return addButton_employe;
    }

    public JButton getupdateButton_employe() {
        return updateButton_employe;
    }

    public JButton getdeleteButton_employe() {
        return deleteButton_employe;
    }

    public JButton getdisplayButton_employe() {
        return displayButton_employe;
    }

    public JButton getimporter() {
        return importer;
    }

    public JButton getexporter() {
        return exporter;
    }

    public JButton getaddButton_holiday() {
        return addButton_holiday;
    }

    public JButton getupdateButton_holiday() {
        return updateButton_holiday;
    }

    public JButton getdeleteButton_holiday() {
        return deleteButton_holiday;
    }

    public JButton getdisplayButton_holiday() {
        return displayButton_holiday;
    }

    public String getStartDate() {
        return text_startDate.getText();
    }

    public String getEndDate() {
        return text_endDate.getText();
    }

    public Type_holiday getType_holiday() {
        return (Type_holiday) TypeComboBox.getSelectedItem();
    }

    // methods d'affichage des messages
    public void afficherMessageErreur(String message) {
        JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public void afficherMessageSucces(String message) {
        JOptionPane.showMessageDialog(this, message, "Succès", JOptionPane.INFORMATION_MESSAGE);
    }

    // methodes de vider les champs
    public void viderChamps_em() {
        text_nom.setText("");
        text_prenom.setText("");
        text_email.setText("");
        text_tele.setText("");
        text_salaire.setText("");
        roleComboBox.setSelectedIndex(0);
        posteComboBox.setSelectedIndex(0);
    }

    public void viderChamps_ho() {
        text_startDate.setText("");
        text_endDate.setText("");
        TypeComboBox.setSelectedIndex(0);
    }

    // methodes de remplir les champs
    public void remplaireChamps_em(int id, String nom, String prenom, String email, String telephone, double salaire, Role role, Post poste) {
        text_nom.setText(nom);
        text_prenom.setText(prenom);
        text_email.setText(email);
        text_tele.setText(telephone);
        text_salaire.setText(String.valueOf(salaire));
        roleComboBox.setSelectedItem(role);
        posteComboBox.setSelectedItem(poste);
    }

    public void remplaireChamps_ho(int id_employe, String date_debut, String date_fin, Type_holiday type) {
        List<Employe> Employes = new EmployeModel(new EmployeDAOimpl()).displayEmploye();
        text_employe.removeAllItems();
        for (Employe elem : Employes) {
            if (elem.getId() == id_employe) {
                text_employe.addItem(elem.getId() + " - " + elem.getNom() + " " + elem.getPrenom());
                text_employe.setSelectedItem(elem.getId() + " - " + elem.getNom() + " " + elem.getPrenom());
            }
        }
        text_startDate.setText(date_debut);
        text_endDate.setText(date_fin);
        TypeComboBox.setSelectedItem(type);
    }

    // methodes de test des champs
    public boolean testChampsVide_em() {
        return text_nom.getText().equals("") || text_prenom.getText().equals("") || text_email.getText().equals("") || text_tele.getText().equals("") || text_salaire.getText().equals("");
    }

    public boolean testChampsVide_ho() {
        return text_employe.getSelectedItem().equals("") || text_startDate.getText().equals("") || text_endDate.getText().equals("") || TypeComboBox.getSelectedItem().equals("");
    }
}
