package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;

import ejbModule.UserDao;
import fr.cpe.model.Role;
import fr.cpe.model.UserModel;

@Singleton
public class DataContainer {
	
	@EJB
	UserDao userDao;
	
	List<UserModel> userList = new ArrayList<UserModel>();
	
	@PostConstruct
	public void init() {
		userList.add(new UserModel("MaxenceR","max"));
		userList.add(new UserModel("CamilleC","cam"));
		userList.add(new UserModel("FlorianC","flo"));
		userList.add(new UserModel("ChristopheT","chris"));
		userList.add(new UserModel("Bilbo","bilbo"));
		userList.add(new UserModel("Barbix","Barbix"));
		userList.add(new UserModel("MarieB","marie"));
		userList.add(new UserModel("FredericC","fred"));
	}
	
	public void addUser(UserModel user){
		userDao.save(user);
	}
	
	public List<UserModel> listUser(){
		return userDao.listUser();
	}
	
	public UserModel getUser(Integer id){
		return userDao.getUser(id);
	}
	
	/**
	 * Check an user
	 * @param user
	 * @return Role
	 */
	public Role checkUser(UserModel user) {
		List<UserModel> userdb = listUser();
		for (UserModel u : userdb) {
			if (u.getLogin() == user.getLogin() && u.getPassword() == user.getPassword()) {
				return user.getRole();
			}
		}
		return Role.NONE;
	}
}
