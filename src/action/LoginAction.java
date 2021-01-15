package action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.UserDAO;

public class LoginAction  extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@Override
	public String execute() throws Exception {
		if (userDao.checkUser(username, password)) {
			ActionContext context = ActionContext.getContext();
			Map<String, Object> session = context.getSession();
			session.put("logged", (Boolean) true);
			return SUCCESS;
		} else {
			
			return "login";
		}
		
	}
	
	public String logout() {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		session.put("logged", (Boolean) false);
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
