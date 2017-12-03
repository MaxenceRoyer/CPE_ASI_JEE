package ejbModule;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.cpe.model.UserModel;

/**
 * @author Camille
 * UserDao
 */
@Stateless
public class UserDao {

	@PersistenceContext
	EntityManager em;
	
	public void save(UserModel user){
		em.persist(user);
	}
	
	public List<UserModel> listUser() {
		List<UserModel> userList = new ArrayList<UserModel>();
				
				userList = (List<UserModel>)em.createQuery("from UserModel").getResultList();
				
		return userList;
	}
	
	public UserModel getUser(Integer id){
		return (UserModel) em.createQuery("from User u where u.id = :id")
		.setParameter("id", id)
		.getSingleResult();
	}
}

