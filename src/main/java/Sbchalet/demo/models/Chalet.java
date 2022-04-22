package Sbchalet.demo.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Chalet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_chalet")
	private int id;
	private String description;
	private int prix;
	private String nom;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "chalet", orphanRemoval = true)

	private Set<Reservation> reservation;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE }, mappedBy = "chalet")
	private List<DatabaseFile> images = null;

	public Chalet() {
	}

	public Chalet(int id_chalet, String description, int prix, String nom) {
		super();
		this.id = id_chalet;
		this.description = description;
		this.prix = prix;
		this.nom = nom;
	}

	public int getId_chalet() {
		return id;
	}

	public void setId_chalet(int id_chalet) {
		this.id = id_chalet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@JsonBackReference
	public Set<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}

	public List<DatabaseFile> getImages() {
		return images;
	}

	public void setImages(List<DatabaseFile> images) {
		this.images = images;
	}

}
