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
@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id_Facture")
   private int id_Facture;
   @Temporal(TemporalType.DATE) // pour avoir le type de date
   private Date DateFacture;
   private float montant ;
   
   
   @OneToOne 
   private Reservation reservation ;
   
   public Facture () {
	   
   }
public Facture(int id_Facture, Date dateFacture, float montant , Reservation reservation) {
	super();
	this.id_Facture = id_Facture;
	DateFacture = dateFacture;
	this.montant = montant;
	this.reservation=reservation;
}
public int getId_Facture() {
	return id_Facture;
}
public void setId_Facture(int id_Facture) {
	this.id_Facture = id_Facture;
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
