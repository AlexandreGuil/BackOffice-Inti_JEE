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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.ValidationException;

@Entity
@Table(name = "produit")
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idProduit; // Primary key
	private String nomProduit;
	private String description;
	private Double prix;
	private Integer StockDuProduit;
	private Boolean selection;
	private String photo; // PATH to the img folder
	private Categorie categorie;
	
	/* ==================== begin test =========================== */
	
//	private List<LigneCommande> ligneDeCommande; //
	
	/* ==================== end test =========================== */

	/**
	 * 
	 * tst the validity of the input constructor ProductName and the input
	 * CategoryName like a init() function
	 * 
	 */

	@PrePersist
	@PreUpdate
	private void validData() {
		if (nomProduit == null || "".equals(nomProduit))
			throw new ValidationException("Le nom du produit n'est pas valide");
		if (description == null || "".equals(description))
			throw new ValidationException("La description du produit n'est pas valide");
	}

	public Produit() {
	}
	
	/* ==================== begin test =========================== */
	
	public Produit(String nomProduit, String description, Double prix, Integer stockDuProduit, Boolean selection,
			String photo, Categorie categorie /* ,  List<LigneCommande> ligneDeCommande */) {
		this.nomProduit = nomProduit;
		this.description = description;
		this.prix = prix;
		StockDuProduit = stockDuProduit;
		this.selection = selection;
		this.photo = photo;
		this.categorie = categorie;
//		this.ligneDeCommande = ligneDeCommande;
	}
	
	/* ==================== end test =========================== */
	
	/* ==================== begin test =========================== */
	
	public Produit(Long idProduit, String nomProduit, String description, Double prix, Integer stockDuProduit,
			Boolean selection, String photo, Categorie categorie /* , List<LigneCommande> ligneDeCommande */) {
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.description = description;
		this.prix = prix;
		StockDuProduit = stockDuProduit;
		this.selection = selection;
		this.photo = photo;
		this.categorie = categorie;
//		this.ligneDeCommande = ligneDeCommande;
	}
	
	/* ==================== end test =========================== */

	/**
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO) Generate automaticaly the
	 *                          Primary Key value with the more apropriated strategy
	 *                          to avoid the drop between id values
	 *
	 */

	@Id
	@Column(name = "PRODUIT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	@Basic(optional = false)
	@Column(name = "DESIGNATION")
	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	@Basic(optional = false)
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic(optional = false)
	@Column(name = "PRIX")
	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Basic(optional = true)
	@Column(name = "QUANTITE")
	public Integer getStockDuProduit() {
		return StockDuProduit;
	}

	public void setStockDuProduit(Integer stockDuProduit) {
		StockDuProduit = stockDuProduit;
	}

	@Basic(optional = true)
	@Column(name = "SELECTION")
	public Boolean getSelection() {
		return selection;
	}

	public void setSelection(Boolean selection) {
		this.selection = selection;
	}

	@Basic(optional = false)
	@Column(name = "PHOTO")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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
	@Column(name = "CATEGORIE")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORIE_ID", referencedColumnName = "CATEGORIE_ID")
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	/* ==================== begin test =========================== */

	/**
	 * 
	 * @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
	 * 
	 *                     Defines a many valued association with one to many
	 *                     multiplicity : In our case one products contain many
	 *                     LigneCommande, and one product is linked to one
	 *                     LigneCommande
	 * 
	 *                     mappedBy: The Produit field in the LigneCommande table
	 *                     that owns the relationship
	 * 
	 */

//	@OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
//	@OrderBy("idProduit")
//	public List<LigneCommande> getLigneDeCommande() {
//		return ligneDeCommande;
//	}
//
//	public void setLigneDeCommande(List<LigneCommande> ligneDeCommande) {
//		this.ligneDeCommande = ligneDeCommande;
//	}
	
	/* ==================== end test =========================== */

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/* ==================== begin test =========================== */
	
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", description=" + description
				+ ", prix=" + prix + ", StockDuProduit=" + StockDuProduit + ", selection=" + selection + ", photo="
				+ photo + ", categorie=" + categorie + /* ", ligneDeCommande=" +  ligneDeCommande + */ "]";
	}
	
	/* ==================== end test =========================== */
}
