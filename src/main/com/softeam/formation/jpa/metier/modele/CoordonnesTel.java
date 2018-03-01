package com.softeam.formation.jpa.metier.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class CoordonnesTel {
	private int version;
	private int id;

	protected String telFixe;
	protected String telPortable;
	protected String fax;
	
	public CoordonnesTel(){}
	
	@Column(name = "telfixe")
	public String getTelFixe() {
		return telFixe;
	}
	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}
	
	@Column(name = "telportable")
	public String getTelPortable() {
		return telPortable;
	}
	public void setTelPortable(String telPortable) {
		this.telPortable = telPortable;
	}
	
	@Column(name = "fax")
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Version
	@Column(name = "version_field")
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}	
}
