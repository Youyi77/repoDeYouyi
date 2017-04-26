package com.adaming.myapp.service.produit;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.produit.IProduitDao;
import com.adaming.myapp.entities.Produit;
@Transactional
public class ProduitServiceImpl implements IProduitService {

    private IProduitDao dao;

	
	public void setDao(IProduitDao dao) {
		this.dao = dao;
		System.out.println("<----dao Produit injected---->");
	}

	@Override
	public Produit createProduit(Produit c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public Produit getOneProduit(Long id) {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}

	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Produit updateProduit(Produit c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
