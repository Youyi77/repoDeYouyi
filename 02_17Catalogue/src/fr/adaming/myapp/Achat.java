package fr.adaming.myapp;
import java.util.*;

public class Achat {
	private ArrayList<Produit> tabProdInterne= new ArrayList<>();
	private Client c;
	private Date d;
	
	public Achat(Client c, Date d) {
		this.c = c;
		this.d=d;
	}

	public ArrayList<Produit> getTabProdInterne() {
		return tabProdInterne;
	}

	public void setTabProdInterne(ArrayList<Produit> tabProdInterne) {
		this.tabProdInterne = tabProdInterne;
	}

	public Client getC() {
		return c;
	}

	public void setC(Client c) {
		this.c = c;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return "Achat [tabProdInterne=" + tabProdInterne + ", c=" + c + ", d="
				+ d + "]";
	}

	
	

}
