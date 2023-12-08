package hello;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
    @Column(name = "id_role")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_role;
	
	@Basic
    @Column(name = "code", length = 15)
	private String code;
	
	@Basic
    @Column(name = "libelle", length = 50)
	private String libelle;
	
	
	
	public Role(Long id_role) {
		super();
		this.id_role = id_role;
	}

	public Role() {
		super();
	}

	public Role(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}
	
	public Long getId_role() {
		return id_role;
	}

	public void setId_role(Long id_role) {
		this.id_role = id_role;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
