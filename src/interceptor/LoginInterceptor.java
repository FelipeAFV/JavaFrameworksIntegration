package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		Map<String, Object> session = context.getSession();
		
		System.out.println("Comprobando login");
		//Se revisa si el usuario está loggeado
		
		boolean state;
		Object logStatus = session.get("logged");
		if (logStatus == null) {
			state = false;
			session.put("logged", state);
		} else {
			state = (Boolean) logStatus;
		}
		
		if (state) {
			System.out.println("Usuario Loggeado");
			//Se llama a la siguiente accion en la stack
			return invocation.invoke();
		} else {
			System.out.println("Permiso denegado");
			return "login";
		}
		
	}

}
