package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Employee;
import model.EmployeeDAO;

@Action(value = "getDataForEdit", results = {@Result(name = "success", location = "/employeeEdit.jsp"),
@Result(name = "error", location = "/error.jsp"), @Result(name = "input", location = "/error.jsp")})
public class EmployeeEditSupportAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee employee;
	private String id;
	
	@Autowired
	@Qualifier("empDao")
	private EmployeeDAO empDao;
	
	
	@Override
	public String execute() throws Exception {
		try {
			
			System.out.println(id);

			System.out.println(empDao);
			int empId = Integer.parseInt(id);
			employee  = empDao.selectEmployee(empId);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}



	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeDAO getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmployeeDAO empDao) {
		this.empDao = empDao;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
