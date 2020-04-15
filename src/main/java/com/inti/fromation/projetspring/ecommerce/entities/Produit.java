package com.inti.fromation.projetspring.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "produit")
public class Produit implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit_id")
    private long idProduit;
    @NotEmpty
    @Column(name = "designation")
    private String nomProduit;
    @Column(name = "description")
    String description;
    @Column(name = "prix")
    private double prix;
    @Column(name = "quantite")
    private int quantite;
    @Column(name = "selectione")
    private boolean selectione;
    @Column(name = "photo")
    private String photo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorie_id")
    @JsonIgnoreProperties("produits")
    private Categorie categorie;

    public Produit(Long idProduit, String nomProduit, String description, double prix, int quantite, boolean selectione, String photo){
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.selectione = selectione;
        this.photo = photo;
    }
}
