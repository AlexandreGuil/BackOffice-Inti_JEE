package com.inti.fromation.projetspring.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categorie_id")
    private long idCategorie;
    @NotEmpty
    @Column(name = "designation")
    private String nomCategorie;
    @Column(name = "photo")
    private Byte[] photo;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("categorie")
    private List<Produit> produits;

    public Categorie(Long idCategorie, String nomCategorie, Byte[] photo, String description){
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
        this.photo = photo;
        this.description = description;
    }
}
