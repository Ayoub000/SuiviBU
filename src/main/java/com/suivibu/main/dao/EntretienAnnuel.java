package com.suivibu.main.dao;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "entretienannuel")
public class EntretienAnnuel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEA;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date date;
	
	private String commentaire;
	
	private boolean realise;
	
	@JsonBackReference(value="eaconsultant")
	@ManyToOne
	@JoinColumn(name="idConsultant", nullable=false)
	private Consultant consultant;
	
	
	public EntretienAnnuel() {}

	
	

	public EntretienAnnuel(long idEA, Date date, String commentaire, boolean realise, Consultant consultant) {
		super();
		this.idEA = idEA;
		this.date = date;
		this.commentaire = commentaire;
		this.realise = realise;
		this.consultant = consultant;
	}





	public long getIdEA() {
		return idEA;
	}


	public void setIdEA(long idEA) {
		this.idEA = idEA;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public boolean isRealise() {
		return realise;
	}


	public void setRealise(boolean realise) {
		this.realise = realise;
	}


	public Consultant getConsultant() {
		return consultant;
	}


	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

	
	
	
}
