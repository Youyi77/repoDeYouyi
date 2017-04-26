package fr.adaming.myapp;
import java.util.*;
public interface IRoles {


	  void addUser(User u, int id);
	  void addRole(Role r);
	  void getAllUser();
	  ArrayList<Role> getAllRole();
	 List<User> getUser(int idRole) throws Exception;
	 List<User> checkName(String mot) throws Exception;
}
