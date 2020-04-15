package com.inti.fromation.projetspring.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "commande")
public class Commande implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande_id")
    private long idCommande;
    private Date dateCommande;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties("commandes")
    private Client client;

    @OneToMany(mappedBy = "commande")
    @JsonIgnoreProperties("commande")
    private List<LigneCommande> ligneCommandes;

}
