package Sbchalet.demo.payload.request;

import java.util.Date;

import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.models.User;

public class ReservationRequest {

	private int id;
	private Date dateDeDebut;
	private Date dateDeDefin;
	private int chalet;
	private float nbNuites;
	private float totalPrix;
	
	private User user;
	
	public ReservationRequest() {
		super();
	}
	
	
	
	public ReservationRequest(Date dateDeDebut, Date dateDeDefin, int chalet, float nbNuites, float totalPrix) {
		super();
		this.dateDeDebut = dateDeDebut;
		this.dateDeDefin = dateDeDefin;
		this.chalet = chalet;
		this.nbNuites = nbNuites;
		this.totalPrix = totalPrix;
	}



	public ReservationRequest(Date dateDeDebut, Date dateDeDefin, int chalet) {
		super();
		this.dateDeDebut = dateDeDebut;
		this.dateDeDefin = dateDeDefin;
		this.chalet = chalet;
	}
	public int getId() {
		return id;
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
	public int getChalet() {
		return chalet;
	}
	public void setChalet(int chalet) {
		this.chalet = chalet;
	}



	public float getNbNuites() {
		return nbNuites;
	}



	public void setNbNuites(float nbNuites) {
		this.nbNuites = nbNuites;
	}



	public float getTotalPrix() {
		return totalPrix;
	}



	public void setTotalPrix(float totalPrix) {
		this.totalPrix = totalPrix;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
}
