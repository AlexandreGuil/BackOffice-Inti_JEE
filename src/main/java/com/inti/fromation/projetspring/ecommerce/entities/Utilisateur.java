package com.inti.fromation.projetspring.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@SuppressWarnings("ALL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilisateur_id")
    private long IdUtilisateur;
    @Column(name = "nom_utilisateur")
    private String nomUtilisateur;
    @Column(name = "mot_de_passe")
    private String motDePasse;
    @Column(name = "actif")
    private boolean actif;

    @OneToMany
    @JoinColumn(name = "utilisateur_id")
    private Collection<Role> roles;

}
