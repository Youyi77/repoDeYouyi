package fr.adaming.myapp;
import java.util.*;

public class User {
	private int idUser;
	private String pseudonyme;
	private String password;
	private List<Role> tabRole = new ArrayList<>();
	
	
	
	public User() {
	}

	public User(int idUser, String pseudonyme, String password) {
		
		this.idUser = idUser;
		this.pseudonyme = pseudonyme;
		this.password = password;
		
	}

	/*public void setRole(int idRole) {
		Implementrole test = new Implementrole();
		int x=0;
		
		
		for (Role i : tabRole){
			System.out.println(i.getIdRole()+" "+idRole);
			if (i.getIdRole()==idRole){
				++x; System.out.println(x);
			}
			
		}
		
		if (x==0) {
			ArrayList<Role> w= test.getAllRole();
			for (Role i:w){
				if (i.getIdRole()==idRole){
					tabRole.add(i);}
				}
			}
		else {System.out.println("role déjà existant !");}
				}
				
	*/
	
	public int getIdUser() {
		return idUser;
	}

	public List<Role> getTabRole() {
		return tabRole;
	}

	public void setTabRole(List<Role> tabRole) {
		this.tabRole = tabRole;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPseudonyme() {
		return pseudonyme;
	}

	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", pseudonyme=" + pseudonyme
				+ ", password=" + password + ", tabRole=" + tabRole + "]";
	}
	
	

	
	}
