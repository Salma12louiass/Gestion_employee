package Model;

public class Employee {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private double salaire;
    private Role role;
    private Poste poste;
    private int solde;

    public Employee(String nom, String prenom, String email, String phone, double salaire, Role role, Poste poste) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.salaire = salaire;
        this.role = role;
        this.poste = poste;
    }

    public Employee() {

    }

    public Employee(String string, String string2, String string3, String string4, double double1, int int1, Role role2, Poste poste2) {
        this.nom = string;
        this.prenom = string2;
        this.email = string3;
        this.phone = string4;
        this.salaire = double1;
        this.solde=int1;
        this.role = role2;
        this.poste = poste2;	}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public double getSalaire() { return salaire; }
    public void setSalaire(double salaire) { this.salaire = salaire; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public Poste getPoste() { return poste; }
    public void setPoste(Poste poste) { this.poste = poste; }
    public int getSolde() {
        return solde;
    }

    public void setnom(String nouveauNom) {
    }
}