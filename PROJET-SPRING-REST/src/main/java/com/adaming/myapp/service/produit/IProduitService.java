package com.adaming.myapp.service.produit;

import java.util.List;

import com.adaming.myapp.entities.Produit;


public interface IProduitService {

	Produit createProduit(Produit c);

	Produit getOneProduit(Long id);

	void deleteProduit(Long id);

	Produit updateProduit(Produit c);

	List<Produit> getAllProduits();
}
