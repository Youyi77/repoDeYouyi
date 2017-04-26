package com.adaming.myapp.bean;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.User;
import com.adaming.myapp.service.IUserService;

@Component("userBean")
@Scope(value = "session")
// On peut indiquer le scope ici (non obligatoire) (request pour recrée à chaque
// clic)
// @ApplicationScoped //Instancie le bean une seule fois au démarrage du serveur
// et le rend accessible à tous les users. durée de vie liée au serveur.
public class UserBean {
	private Integer nbr1;
	private Integer nbr2;
	private Integer result;
	private Long idUser;
	private String nomUser;
	private String pseudoUser;
	private Long idUser2;
	private String nomUser2;
	private String pseudoUser2;
	private User user;
	@Inject
	private IUserService service;
	private List<User> users;
	private String label;

	public void forward() {
		label="bonjour";
		System.out.println(label);
	}

	public String redirect() {
		return "redirect?faces-redirect=true";
	}

	public void getAll() {
		users = service.getAll();
	}

	public void calculer(Integer nbr1, Integer nbr2) {
		result = nbr1 + nbr2;

	}

	public void addUser(String nomUser, String pseudoUser) {
		;
		User u = new User(nomUser, pseudoUser);
		;
		service.addUser(u);
		getAll();

	}

	public void reset() {
		nomUser = "";
		pseudoUser = "";
	}

	public void delete(Long idUser) {
		System.out.println("ok");
		service.deleteUser(idUser);
		users = service.getAll();
	}

	public void updateUser(Long idUser2, String nomUser2, String pseudoUser2) {
		User u = service.getOneById(idUser2);
		u.setNomUser(nomUser2);
		u.setPseudoUser(pseudoUser2);
		service.updateUser(u);
		users = service.getAll();

	}

	/*
	 * public void preUpdate(Long idUser,String nomUser,String pseudoUser){
	 * System.out.println("Je suis l'essence même de la magie"); idUser2=idUser;
	 * nomUser2=nomUser; pseudoUser2=pseudoUser; }
	 */

	public void getOne(Long idUser) {
		user = service.getOneById(idUser);
		System.out.println("getOne " + user);
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the nomUser
	 */
	public String getNomUser() {
		return nomUser;
	}

	/**
	 * @param nomUser
	 *            the nomUser to set
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
	 * @param pseudoUser
	 *            the pseudoUser to set
	 */
	public void setPseudoUser(String pseudoUser) {
		this.pseudoUser = pseudoUser;
	}

	public UserBean() {
		System.out.println("OK-----:)-----OK");
	}

	/**
	 * @return the nbr1
	 */
	public Integer getNbr1() {
		return nbr1;
	}

	/**
	 * @param nbr1
	 *            the nbr1 to set
	 */
	public void setNbr1(Integer nbr1) {
		this.nbr1 = nbr1;
	}

	/**
	 * @return the nbr2
	 */
	public Integer getNbr2() {
		return nbr2;
	}

	/**
	 * @param nbr2
	 *            the nbr2 to set
	 */
	public void setNbr2(Integer nbr2) {
		this.nbr2 = nbr2;
	}

	/**
	 * @return the result
	 */
	public Integer getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Integer result) {
		this.result = result;
	}

	/**
	 * @return the idUser
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser
	 *            the idUser to set
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the idUser2
	 */
	public Long getIdUser2() {
		return idUser2;
	}

	/**
	 * @param idUser2
	 *            the idUser2 to set
	 */
	public void setIdUser2(Long idUser2) {
		this.idUser2 = idUser2;
	}

	/**
	 * @return the nomUser2
	 */
	public String getNomUser2() {
		return nomUser2;
	}

	/**
	 * @param nomUser2
	 *            the nomUser2 to set
	 */
	public void setNomUser2(String nomUser2) {
		this.nomUser2 = nomUser2;
	}

	/**
	 * @return the pseudoUser2
	 */
	public String getPseudoUser2() {
		return pseudoUser2;
	}

	/**
	 * @param pseudoUser2
	 *            the pseudoUser2 to set
	 */
	public void setPseudoUser2(String pseudoUser2) {
		this.pseudoUser2 = pseudoUser2;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

}
