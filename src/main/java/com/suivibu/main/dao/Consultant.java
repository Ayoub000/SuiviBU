package com.suivibu.main.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "consultant")
public class Consultant {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idConsultant;
	
	private String statut;
	private String nom;
	private String prenom;
	private String mail;
	private String tel;
	private boolean pro;
	private String trigramme;
	private boolean validationPE;
	private double salaireAnBrut;
	private double HJMN;
	private double HJMN1;
	private double margeJour;
	private double pourcentMarge;
	private double partTicketResto;
	private double fraisDeplacementJr;
	private double k2;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEntreeClient;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDernierDej;
	
	@JsonManagedReference(value="sptconsultant")
	@OneToMany(mappedBy="consultant", cascade = CascadeType.ALL)
    private Set<SuiviProjetTalent> spts = new HashSet<>();

	@JsonManagedReference(value="spcconsultant")
	@OneToMany(mappedBy="consultant", cascade = CascadeType.ALL)
    private Set<SuiviProjetClient> spcs = new HashSet<>();

	@JsonManagedReference(value="eaconsultant")
	@OneToMany(mappedBy="consultant", cascade = CascadeType.ALL)
    private Set<EntretienAnnuel> eas = new HashSet<>();
	
	@JsonBackReference(value="consultantclient")
	@ManyToOne
    @JoinColumn(name="idClient", nullable=false)
    private Client client;
	
	@JsonBackReference(value="consultantutilisateur")
	@ManyToOne
    @JoinColumn(name="idUtilisateur", nullable=false)
    private Utilisateur utilisateur;
	
	
	
	public Consultant() {}

	public Consultant(long idConsultant, String statut, String nom, String prenom, String mail, String tel, boolean pro,
			String trigramme, boolean validationPE, double salaireAnBrut, double hJMN, double hJMN1, double margeJour,
			double pourcentMarge, double partTicketResto, double fraisDeplacementJr, double k2, Date dateEntreeClient,
			Date dateDernierDej, Set<SuiviProjetTalent> spts, Set<SuiviProjetClient> spcs, Set<EntretienAnnuel> eas,
			Client client, Utilisateur utilisateur) {
		super();
		this.idConsultant = idConsultant;
		this.statut = statut;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.tel = tel;
		this.pro = pro;
		this.trigramme = trigramme;
		this.validationPE = validationPE;
		this.salaireAnBrut = salaireAnBrut;
		HJMN = hJMN;
		HJMN1 = hJMN1;
		this.margeJour = margeJour;
		this.pourcentMarge = pourcentMarge;
		this.partTicketResto = partTicketResto;
		this.fraisDeplacementJr = fraisDeplacementJr;
		this.k2 = k2;
		this.dateEntreeClient = dateEntreeClient;
		this.dateDernierDej = dateDernierDej;
		this.spts = spts;
		this.spcs = spcs;
		this.eas = eas;
		this.client = client;
		this.utilisateur = utilisateur;
	}

	public long getIdConsultant() {
		return idConsultant;
	}

	public void setIdConsultant(long idConsultant) {
		this.idConsultant = idConsultant;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public boolean isPro() {
		return pro;
	}

	public void setPro(boolean pro) {
		this.pro = pro;
	}

	public String getTrigramme() {
		return trigramme;
	}

	public void setTrigramme(String trigramme) {
		this.trigramme = trigramme;
	}

	public boolean isValidationPE() {
		return validationPE;
	}

	public void setValidationPE(boolean validationPE) {
		this.validationPE = validationPE;
	}

	public double getSalaireAnBrut() {
		return salaireAnBrut;
	}

	public void setSalaireAnBrut(double salaireAnBrut) {
		this.salaireAnBrut = salaireAnBrut;
	}

	public double getHJMN() {
		return HJMN;
	}

	public void setHJMN(double hJMN) {
		HJMN = hJMN;
	}

	public double getHJMN1() {
		return HJMN1;
	}

	public void setHJMN1(double hJMN1) {
		HJMN1 = hJMN1;
	}

	public double getMargeJour() {
		return margeJour;
	}

	public void setMargeJour(double margeJour) {
		this.margeJour = margeJour;
	}

	public double getPourcentMarge() {
		return pourcentMarge;
	}

	public void setPourcentMarge(double pourcentMarge) {
		this.pourcentMarge = pourcentMarge;
	}

	public double getPartTicketResto() {
		return partTicketResto;
	}

	public void setPartTicketResto(double partTicketResto) {
		this.partTicketResto = partTicketResto;
	}

	public double getFraisDeplacementJr() {
		return fraisDeplacementJr;
	}

	public void setFraisDeplacementJr(double fraisDeplacementJr) {
		this.fraisDeplacementJr = fraisDeplacementJr;
	}

	public double getK2() {
		return k2;
	}

	public void setK2(double k2) {
		this.k2 = k2;
	}

	public Date getDateEntreeClient() {
		return dateEntreeClient;
	}

	public void setDateEntreeClient(Date dateEntreeClient) {
		this.dateEntreeClient = dateEntreeClient;
	}

	public Date getDateDernierDej() {
		return dateDernierDej;
	}

	public void setDateDernierDej(Date dateDernierDej) {
		this.dateDernierDej = dateDernierDej;
	}

	public Set<SuiviProjetTalent> getSpts() {
		return spts;
	}

	public void setSpts(Set<SuiviProjetTalent> spts) {
		this.spts = spts;
	}

	public Set<SuiviProjetClient> getSpcs() {
		return spcs;
	}

	public void setSpcs(Set<SuiviProjetClient> spcs) {
		this.spcs = spcs;
	}

	public Set<EntretienAnnuel> getEas() {
		return eas;
	}

	public void setEas(Set<EntretienAnnuel> eas) {
		this.eas = eas;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	
}
