package Sbchalet.demo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Chalet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String description;
	@Column
	private double prix;
	@Column
	private String adresse;
	@Column
	private String etat;
	@Column
	private String ville;
	@Column
	private String codeZip;

	@JsonManagedReference
	@OneToMany(mappedBy = "chalet", fetch = FetchType.EAGER, targetEntity = Reservation.class, cascade = CascadeType.ALL)
	private Set<Reservation> reservations = new HashSet<Reservation>();

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "chalet")
	private List<DatabaseFile> images = new ArrayList();

	public Chalet() {
	}

	public Chalet(int id, String description, double prix, String adresse, String etat, String ville, String codeZip,
			Set<Reservation> reservation, List<DatabaseFile> images) {
		super();
		this.id = id;
		this.description = description;
		this.prix = prix;
		this.adresse = adresse;
		this.etat = etat;
		this.ville = ville;
		this.codeZip = codeZip;
		this.reservations = reservation;
		this.images = images;
	}

	public Chalet(String description, double prix, String adresse, String etat, String ville, String codeZip,
			Set<Reservation> reservation, List<DatabaseFile> images) {
		super();
		this.description = description;
		this.prix = prix;
		this.adresse = adresse;
		this.etat = etat;
		this.ville = ville;
		this.codeZip = codeZip;
		this.reservations = reservation;
		this.images = images;
	}
	
	

	public Chalet(String description, double prix, String adresse, String etat, String ville, String codeZip) {
		super();
		this.description = description;
		this.prix = prix;
		this.adresse = adresse;
		this.etat = etat;
		this.ville = ville;
		this.codeZip = codeZip;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodeZip() {
		return codeZip;
	}

	public void setCodeZip(String codeZip) {
		this.codeZip = codeZip;
	}

	public Set<Reservation> getReservation() {
		return reservations;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservations = reservation;
	}

	public List<DatabaseFile> getImages() {
		return images;
	}

	public void setImages(List<DatabaseFile> images) {
		this.images = images;
	}

	public int getId() {
		return id;
	}

}
