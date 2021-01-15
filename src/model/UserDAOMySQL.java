package model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import service.SessionFactoryProvider;

@Component("userDao")
public class UserDAOMySQL implements UserDAO {

	@Override
	public boolean checkUser(String username, String password) {
		Session s = SessionFactoryProvider.getSessionFactory().openSession();
		
		try {
			
			
			Query q = s.createQuery("from User as us  where us.username = :username and us.password = :password");
			q.setParameter("username", username);
			q.setParameter("password", password);
			
			List<User> userResult = q.list();
			
			//EL resultado es una lista de array de objetos, en este caso la lista
			//tiene un solo array y este array tiene dos onjetos, el employee y el job involucrados 
			//en el join
			Iterator<User> itr = userResult.iterator();
			
			User user = null;
			
			if (itr.hasNext()) {
				user = itr.next();
			}
			
			
			if (user != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		} finally {
			s.close();
		}
	}

}
