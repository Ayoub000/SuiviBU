package com.suivibu.main.dao;

import java.util.Date;

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
	
	@ManyToOne
	@JoinColumn(name="idConsultant", nullable=false)
	private Consultant consultant;
	
	
	public SuiviProjetClient() {}

	public SuiviProjetClient(long idPC, Date date, String commentaire, Consultant consultant) {
		super();
		this.idPC = idPC;
		this.date = date;
		this.commentaire = commentaire;
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

	public Consultant getConsultant() {
		return consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}
	
	
	
}
