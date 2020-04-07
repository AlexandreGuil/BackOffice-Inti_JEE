package com.inti.formation.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idCommande;
	private Date dateCommande;
	private Client client;
	private List<LigneCommande> ligneDecommande;

	public Commande() {
	}

	public Commande(Date dateCommande, Client client, List<LigneCommande> ligneDecommande) {
		this.dateCommande = dateCommande;
		this.client = client;
		this.ligneDecommande = ligneDecommande;
	}

	public Commande(Long idCommande, Date dateCommande, Client client, List<LigneCommande> ligneDecommande) {
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.client = client;
		this.ligneDecommande = ligneDecommande;
	}

	/**
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO) Generate automaticaly the
	 *                          Primary Key value with the more apropriated strategy
	 *                          to avoid the drop between id values
	 *
	 */

	@Id
	@Column(name = "COMMANDE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	/**
	 * 
	 * @Temporal(TemporalType.DATE) Instanciate a date class in the table
	 * 
	 */

	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_COMMANDE")
	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	/**
	 * 
	 * @ManyToOne(fetch = FetchType.EAGER) Defines a many valued association with
	 *                  many to one multiplicity : In our case one caterorie contain
	 *                  many products, and one product is linked to one category
	 * 
	 * @JoinColumn(name = "CATEGORIE_ID", referencedColumnName = "CATEGORIE_ID")
	 *                  Specifies a column for joining an entity association or
	 *                  element collection If the JoinColumn annotation itself is
	 *                  defaulted, a single join column is assumed and the default
	 *                  values apply
	 * 
	 *                  name: The name of the foreign key column in the categorie
	 *                  table
	 * 
	 *                  referencedColumnName: The name of the column referenced by
	 *                  this foreign key column in the categorie table
	 * 
	 * @return the categorie object liked with the product liked by the n:1 relation
	 * 
	 */

	@Basic(optional = false)
	@Column(name = "CLIENT")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLIENT_ID", referencedColumnName = "CLIENT_ID")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * 
	 * @OneToMany(mappedBy = "commande", fetch = FetchType.LAZY) Defines a many
	 *                     valued association with one to many multiplicity : In our
	 *                     case one command contain many LigneCommande, and one
	 *                     product is linked to one LigneCommande
	 * 
	 *                     mappedBy: The command field in the LigneCommande table
	 *                     that owns the relationship
	 * 
	 */

	@Basic(optional = false)
	@OneToMany(mappedBy = "commande", fetch = FetchType.LAZY)
	@OrderBy("idCommande")
	public List<LigneCommande> getLigneDecommande() {
		return ligneDecommande;
	}

	public void setLigneDecommande(List<LigneCommande> ligneDecommande) {
		this.ligneDecommande = ligneDecommande;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + ", client=" + client
				+ ", ligneDecommande=" + ligneDecommande + "]";
	}
}