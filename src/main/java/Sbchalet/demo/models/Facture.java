package Sbchalet.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Temporal(TemporalType.DATE) // pour avoir le type de date
	private Date DateFacture;
	private float montant;

	@OneToOne
	private Reservation reservation;

	public Facture() {

	}

	public Facture(int id, Date dateFacture, float montant) {
		super();
		this.id = id;
		DateFacture = dateFacture;
		this.montant = montant;
	}

	public Facture(Date dateFacture, float montant, Reservation reservation) {
		super();
		DateFacture = dateFacture;
		this.montant = montant;
		this.reservation = reservation;
	}

	public Facture(int id, Date dateFacture, float montant, Reservation reservation) {
		super();
		this.id = id;
		DateFacture = dateFacture;
		this.montant = montant;
		this.reservation = reservation;
	}

	public int getId() {
		return id;
	}

	public void setId_Facture(int id_Facture) {
		this.id = id_Facture;
	}

	public Date getDateFacture() {
		return DateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		DateFacture = dateFacture;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	@JsonManagedReference
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
