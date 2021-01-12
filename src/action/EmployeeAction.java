package action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import model.Department;
import model.Employee;
import model.EmployeeDAO;


public class EmployeeAction  {
	
	private String employeeId;
	private String firstName;
	private String lastName;
	private String salary;
	private String departmentId;
	private String managerId;
	private String message;
	
	private Employee employee;
	
	private List<Employee> employees;

	@Autowired
	@Qualifier("empDao")
	EmployeeDAO empDao;
	
	
	@Action(value = "insertEmployee", results = {@Result(name = "success", location = "/employeeInsertSuccess.jsp"),
			@Result(name = "error", location = "/error.jsp"), @Result(name = "input", location = "/employeeForm.jsp")}) 
	@RequiredStringValidator(type = ValidatorType.SIMPLE,fieldName = "employeeId", message = "Se requiere un ID")
	public String insertEmployee() {
		
		try {
			Employee manager = new Employee();
			manager.setId(Integer.parseInt(managerId));
			Department department = new Department();
			department.setId(Integer.parseInt(departmentId));
			employee = new Employee(Integer.parseInt(employeeId), firstName, lastName, Double.parseDouble(salary),
					manager, department);
			
			empDao.addEmployee(employee);
			return "success";
		}  catch (Exception  e) {
			e.printStackTrace();
			message = e.getMessage();
			return "error";
		}
	}
	
	@Action(value = "listEmployees", results = {@Result(name = "success", location = "/employeeList.jsp"),
			@Result(name = "error", location = "/error.jsp"), @Result(name = "input", location = "/error.jsp")})
	public String listEmployees() {
		System.out.println("Listando empleados 1");
		try {
			employees = empDao.employeeList();
			message = "Este es un mensaje";
			//Se obtiene el objeto request y se agrega la informacion con la lista de empleados
			//para que esta este disponible en la vista
			Map<String, List<Employee>> request = (Map<String, List<Employee>>) ActionContext.getContext().get("request");
			request.put("employees",employees);

			return "success";
		} catch (Exception e) {
			message = e.getMessage();
			return "error";
		}
		
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EmployeeDAO getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmployeeDAO empDao) {
		this.empDao = empDao;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	

	
	
}
