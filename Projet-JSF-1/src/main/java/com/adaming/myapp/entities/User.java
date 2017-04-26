package com.adaming.myapp.entities;


import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	private String nomUser;
	private String pseudoUser;
	
	public User(String nomUser, String pseudoUser) {
		super();
		this.nomUser = nomUser;
		this.pseudoUser = pseudoUser;
	}
	
	

	public User() {

	}



	/**
	 * @return the idUser
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the nomUser
	 */
	public String getNomUser() {
		return nomUser;
	}

	/**
	 * @param nomUser the nomUser to set
	 */
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	/**
	 * @return the pseudoUser
	 */
	public String getPseudoUser() {
		return pseudoUser;
	}

	/**
	 * @param pseudoUser the pseudoUser to set
	 */
	public void setPseudoUser(String pseudoUser) {
		this.pseudoUser = pseudoUser;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nomUser=" + nomUser
				+ ", pseudoUser=" + pseudoUser + "]";
	}
	
	
	
	
	

}
