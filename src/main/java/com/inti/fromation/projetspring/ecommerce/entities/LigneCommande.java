package com.inti.fromation.projetspring.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("ALL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ligne_de_commande")
public class LigneCommande implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ligne_commande_id")
    private long idLigneDeCommande;
    @Column(name = "quantite")
    private int quantite;
    @Column(name = "prix")
    private double prix;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    @JsonIgnoreProperties("ligneCommandes")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

}
