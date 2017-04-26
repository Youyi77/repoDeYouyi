package fr.adaming.myapp;

public class TestRole {
public static void main(String[] args) {
	
	Role admin = new Role(1, "Admin");
	Role utilisateur = new Role(2, "Utilisateur");
	Role moderateur = new Role(3, "Modérateur");
	
	Implementrole test = new Implementrole();
	test.addRole(admin);
	test.addRole(utilisateur);
	test.addRole(moderateur);
	
	test.getAllRole();
	
	User julie = new User(1,"Julie", "intijee");
	User remi = new User(2,"Rémi", "gsfsuofgj");
	User jeanpierre = new User(3,"Jean-Pierre","iopoloa");
	
	/*julie.setRole(1);
	julie.setRole(1);*/
	
	test.addUser(julie,1);
	test.addUser(remi,2);
	test.addUser(jeanpierre,3);
	test.getAllUser();
	try {
		System.out.println(test.getUser(3));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		System.out.println(test.checkName("mi"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
