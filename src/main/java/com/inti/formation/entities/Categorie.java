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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.ValidationException;

@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idCategorie; // Primary key
	private String nomCategorie;
	private String pathPhoto; // PATH to the img folder // @Lob private byte[] photo
	private String description;
	private List<Produit> produits; // relationship 1:n to the prodct entity

	/**
	 * 
	 * tst the validity of the input constructor ProductName and the input
	 * CategoryName like a init() function
	 * 
	 */

	@PrePersist
	@PreUpdate
	private void validData() {
		if (nomCategorie == null || "".equals(nomCategorie))
			throw new ValidationException("Nom de catégorie non valide");
		if (description == null || "".equals(nomCategorie))
			throw new ValidationException("Description de la catégorie n'est pas valide");
	}

	public Categorie() {
	}

	public Categorie(String nomCategorie, String pathPhoto, String description, List<Produit> produits) {
		this.nomCategorie = nomCategorie;
		this.pathPhoto = pathPhoto;
		this.description = description;
		this.produits = produits;
	}

	public Categorie(Long idCategorie, String nomCategorie, String pathPhoto, String description, List<Produit> produits) {
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.pathPhoto = pathPhoto;
		this.description = description;
		this.produits = produits;
	}

	/**
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO) Generate automaticaly the
	 *                          Primary Key value with the more apropriated strategy
	 *                          to avoid the drop between id values
	 *
	 */

	@Id
	@Column(name = "CATEGORIE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	@Basic(optional = false)
	@Column(name = "NOM_CATEGORIE")
	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	@Basic(optional = false)
	@Column(name = "PHOTO")
	public String getPhoto() {
		return pathPhoto;
	}

	public void setPhoto(String pathPhoto) {
		this.pathPhoto = pathPhoto;
	}

	@Basic(optional = false)
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @OneToMany(mappedBy = "categorie", cascade = CascadeType.REMOVE, fetch =
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

	@OneToMany(mappedBy = "categorie", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@OrderBy("nomCategorie ASC")
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", pathPhoto=" + pathPhoto
				+ ", description=" + description + ", produits=" + produits + "]";
	}
}
