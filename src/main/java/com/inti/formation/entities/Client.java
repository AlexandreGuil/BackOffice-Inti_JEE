package com.inti.formation.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idClient; // Primary key

	// begin signup informations

	private String nomClient;
	private String prenomClient;

	// begin signin informations

	private String email;
	private String motDePasse;

	// end signin informations

	// end signup informations

	private String adresse;
	private String tel;
	private List<Commande> commandes; // list of commande allready made by the client but not delivered yet

	/**
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO) Generate automaticaly the
	 *                          Primary Key value with the more apropriated strategy
	 *                          to avoid the drop between id values
	 *
	 */

	@Id
	@Column(name = "CLIENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	@Basic(optional = false)
	@Column(name = "NOM_CLIENT")
	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	@Basic(optional = false)
	@Column(name = "PRENOM_CLIENT")
	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	@Basic(optional = true)
	@Column(name = "ADRESSE")
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Basic(optional = false)
	@Column(name = "ADRESSE_E_MAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic(optional = false)
	@Column(name = "MOT_DE_PASSE")
	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Basic(optional = true)
	@Column(name = "NUMEROT_DE_TELEPHONE")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 
	 * @OneToMany(mappedBy = "", cascade = CascadeType.REMOVE, fetch =
	 *                     FetchType.LAZY)
	 * 
	 *                     Defines a many valued association with one to many
	 *                     multiplicity : In our case one categorie contain many
	 *                     products, and one product is linked to one category
	 * 
	 *                     mappedBy: The categorie field in the Produit table that
	 *                     owns the relationship
	 * 
	 *                     cascade: The drop of the cotegorie lead to the drop of
	 *                     all the product link with this cotegorie
	 * 
	 *                     @OrderBy("designation ASC")
	 * 
	 *                     "nomCategorie ASC": sort the table with alphanuméric
	 *                     order of the categorie name
	 * 
	 * @return a list of the product object link with this categorie
	 * 
	 */

	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@OrderBy("idCommande")
	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", adresse=" + adresse + ", email=" + email + ", motDePasse=" + motDePasse + ", tel=" + tel
				+ ", commandes=" + commandes + "]";
	}

}
