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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO)
	 * Generate automaticaly the Primary Key value with the
	 * more apropriated strategy to avoid the drop between id values
	 *
	 */
	
	@Id
	@Column(name = "COMMANDE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCommande;
	
	/**
	 * 
	 * @Temporal(TemporalType.DATE)
	 * 
	 */
	
	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_COMMANDE")
	private Date dateCommande;
	
	/**
	 * 
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * Defines a many valued association with many to one multiplicity :
	 * In our case one caterorie contain many products, and one product is linked to one category
	 * 
	 * @JoinColumn(name = "CATEGORIE_ID", referencedColumnName = "CATEGORIE_ID")
	 * Specifies a column for joining an entity association or element collection 
	 * If the JoinColumn annotation itself is defaulted, a single join column is assumed and the default values apply
	 * 
	 * name: The name of the foreign key column in the categorie table
	 * 
	 * referencedColumnName: The name of the column referenced by this foreign key column in the categorie table
	 * 
	 * @return the categorie object liked with the product liked by the n:1 relation
	 * 
	 */
	
	@Basic(optional = false)
	@Column(name = "CLIENT")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLIENT_ID", referencedColumnName = "CLIENT_ID")
	private Client client;
	
	@Basic(optional = false)
	@OneToMany(mappedBy = "commande", fetch = FetchType.LAZY)
	private List<LigneCommande> ligneDecommande;
	
}