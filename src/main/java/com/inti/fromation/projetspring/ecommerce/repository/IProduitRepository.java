package com.inti.fromation.projetspring.ecommerce.repository;


import com.inti.fromation.projetspring.ecommerce.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProduitRepository extends JpaRepository<Produit, Long> {

    @Query("select p from Produit p where p.nomProduit like %:mot% or p.description like %:mot%")
    public List<Produit> findByProduitsParMotCle(@Param("mot") String mot);

    @Query("select p from Produit p where p.categorie.idCategorie= :idCategorie")
    public List<Produit> findByProduitsParCategorie(@Param("idCategorie") Long idCategorie);

    @Query("select p from Produit p where p.selectione=true")
    public List<Produit> findByProduitsSelectionnes();

}
