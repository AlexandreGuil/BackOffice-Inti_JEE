package com.inti.fromation.projetspring.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "client")
public class Client implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long idClient;
    @Column(name = "nom_client")
    private String nomClient;

    @Column(name = "adresse")
    private String adresse;
    @Column(name = "email")
    private String email;
    @Column(name = "numerot_telephone")
    private String tel;

    @OneToMany(mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Commande> commandes;


}
