package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class UrlAction extends ActionSupport {
	
	@Override
	public String execute()  {
		// TODO Auto-generated method stub
		return "error";
	}
	
	
	public String redirectEmpForm() {
		
		return "success";
	}

}
