package Sbchalet.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class Reservation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4667184954534741481L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int idResarvation;
	@Temporal(TemporalType.DATE) // pour avoir le type de date
	private Date dateDeDebut;
	@Temporal(TemporalType.DATE)
	private Date dateDeDefin;

	@ManyToOne
	private User user;

	@ManyToOne
	private Chalet chalet;

	@OneToOne
	private Facture facture;

	public Reservation() {
	}

	public Reservation(int idResarvation, Date dateDeDebut, Date dateDeDefin, User user, Chalet chalet) {
		super();
		this.idResarvation = idResarvation;
		this.dateDeDebut = dateDeDebut;
		this.dateDeDefin = dateDeDefin;
		this.user = user;
		this.chalet = chalet;
	}

	public Chalet getChalet() {
		return chalet;
	}

	public void setChalet(Chalet chalet) {
		this.chalet = chalet;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getIdResarvation() {
		return idResarvation;
	}

	public void setIdResarvation(int idResarvation) {
		this.idResarvation = idResarvation;
	}

	public Date getDateDeDebut() {
		return dateDeDebut;
	}

	public void setDateDeDebut(Date dateDeDebut) {
		this.dateDeDebut = dateDeDebut;
	}

	public Date getDateDeDefin() {
		return dateDeDefin;
	}

	public void setDateDeDefin(Date dateDeDefin) {
		this.dateDeDefin = dateDeDefin;
	}

	@Override
	public String toString() {
		return "Reservation [idResarvation=" + idResarvation + ", dateDeDebut=" + dateDeDebut + ", dateDeDefin="
				+ dateDeDefin + ", user=" + user + ", chalet=" + chalet + ", facture=" + facture + "]";
	}

}
