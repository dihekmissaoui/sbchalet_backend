package Sbchalet.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Facture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4910413982013885428L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Temporal(TemporalType.DATE) // pour avoir le type de date
	private Date DateFacture;
	private float montant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
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

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	

}
