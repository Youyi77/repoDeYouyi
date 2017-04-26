package com.adaming.myapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long id;
	private String label;
	
	public Produit() {
		// TODO Auto-generated constructor stub
	}

	
	public Produit(String label) {
		super();
		this.label = label;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Produit [id=" + id + ", label=" + label + "]";
	}
	
	
}
