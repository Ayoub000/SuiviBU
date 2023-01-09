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
@Table(name = "suiviprojetclient")
public class SuiviProjetClient {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPC;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date date;
	
	private String commentaire;
	
	private boolean realise;
	
	@JsonBackReference(value="spcconsultant")
	@ManyToOne
	@JoinColumn(name="idConsultant", nullable=false)
	private Consultant consultant;
	
	
	public SuiviProjetClient() {}


	public SuiviProjetClient(long idPC, Date date, String commentaire, boolean realise, Consultant consultant) {
		super();
		this.idPC = idPC;
		this.date = date;
		this.commentaire = commentaire;
		this.realise = realise;
		this.consultant = consultant;
	}


	public long getIdPC() {
		return idPC;
	}


	public void setIdPC(long idPC) {
		this.idPC = idPC;
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
