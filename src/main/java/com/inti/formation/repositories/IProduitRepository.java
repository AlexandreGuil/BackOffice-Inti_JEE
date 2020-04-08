package com.inti.formation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.formation.entities.Produit;

@Repository("prodRepo")
public interface IProduitRepository extends JpaRepository<Produit, Long>{
	
	@Query("SELECT p FROM Produit p "
			+ "WHERE p.nomProduit LIKE "
			+ "%:kw% OR p.description LIKE %:kw%")
	public List<Produit> findProductByKeyWord(@Param("kw") String kw);
	
	@Query("SELECT p FROM Produit p "
			+ "WHERE p.categorie.idCategorie "
			+ "= :idCategorie")
	public List<Produit> findProductByCategory(@Param("idCategorie") Long idCategorie);
	
	@Query("SELECT p FROM Produit p "
			+ "WHERE p.selection=true")
	public List<Produit> findSelectedProducts();
		
}
