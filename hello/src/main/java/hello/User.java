
package hello;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user ;
    @OneToMany
    private List<Role> roles = new ArrayList<>();
    @Basic
    @Column(name = "nom", length = 50)
    private String nom;
    @Basic
    @Column(name = "prenom", length = 50)
    private String prenom;
    
    @Basic
    @Column(name = "motdepasse", length = 50)
    private String motdepasse;
    
    @Basic
    @Column(name = "email", length = 50)
    private String email;
    
    @Basic
    @Column(name = "contact", length = 50)
    private String contact;
    
    @Basic
    @Column(name = "username", length = 50, unique=true)
    private String username;
    
    @Transient
    private String role;
    



	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public User() {
		super();
	}


	public User(String nom, String prenom, String motdepasse, String email, String contact, String username) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.motdepasse = motdepasse;
        this.email = email;
        this.contact = contact;
        this.username = username;
	}


	public User(String nom, String prenom, String motdepasse, String email, String contact, String role, String username) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = motdepasse;
        this.email = email;
        this.contact = contact;
        this.username = username;
        this.role = role;
    }


    public Long getId_user() {
		return id_user;
	}

    
    

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}
