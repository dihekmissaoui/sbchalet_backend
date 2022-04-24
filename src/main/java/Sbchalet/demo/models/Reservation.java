package Sbchalet.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	private int id;
	@Temporal(TemporalType.DATE) // pour avoir le type de date
	private Date dateDeDebut;
	@Temporal(TemporalType.DATE)
	private Date dateDeDefin;

	@ManyToOne
    @JoinColumn(name="user_id")
	private User user;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)	
    @JoinColumn(name="chalet_id")
	private Chalet chalet;

//	@OneToOne
//	private Facture facture;

	public Reservation() {
	}

	public Reservation(int id, Date dateDeDebut, Date dateDeDefin, User user, Chalet chalet) {
		super();
		this.id = id;
		this.dateDeDebut = dateDeDebut;
		this.dateDeDefin = dateDeDefin;
		this.user = user;
		this.chalet = chalet;
	}

	public Reservation(Date dateDeDebut, Date dateDeDefin, User user, Chalet chalet, Facture facture) {
		super();
		this.dateDeDebut = dateDeDebut;
		this.dateDeDefin = dateDeDefin;
		this.user = user;
		this.chalet = chalet;
	}

	public Reservation(Date dateDeDebut, Date dateDeDefin, Chalet chalet) {
		super();
		this.dateDeDebut = dateDeDebut;
		this.dateDeDefin = dateDeDefin;
		this.chalet = chalet;
	}
	

	public Reservation(Date dateDeDebut, Date dateDeDefin) {
		super();
		this.dateDeDebut = dateDeDebut;
		this.dateDeDefin = dateDeDefin;
	}
	
	

	public Reservation(int id, Date dateDeDebut, Date dateDeDefin) {
		super();
		this.id = id;
		this.dateDeDebut = dateDeDebut;
		this.dateDeDefin = dateDeDefin;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Chalet getChalet() {
		return chalet;
	}

	public void setChalet(Chalet chalet) {
		this.chalet = chalet;
	}

	public int getId() {
		return id;
	}

	
	

}
