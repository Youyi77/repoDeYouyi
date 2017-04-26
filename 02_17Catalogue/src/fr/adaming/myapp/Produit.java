package fr.adaming.myapp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Produit {
	private int id;
	private String nom;
	private double prix;
	private int stock;
	private Date dateAjout;
	private ArrayList<Categorie> tabIntCat=new ArrayList<Categorie>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Scanner clavier = new Scanner(System.in);
    
	public Produit() {
		
	}
	
	public Produit(int id, String nom, double prix, int stock, String dateAjout) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		try {
			this.dateAjout=setDate(dateAjout);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public Date getDateAjout() {
		return dateAjout;
	}


	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}


	public ArrayList<Categorie> getTabIntCat() {
		return tabIntCat;
	}


	public void setTabIntCat(ArrayList<Categorie> tabIntCat) {
		this.tabIntCat = tabIntCat;
	}

	@Override
	public String toString() {
		return " [" + id + ", " + nom + ", " + prix
				+ "€, " + stock + ", maj le : " + sdf.format(dateAjout)
				+ ", " + tabIntCat + "]";
	}
	
	
	public Date setDate(String date) throws ParseException {
		Date d=sdf.parse(date);
		return d;
	}
}
