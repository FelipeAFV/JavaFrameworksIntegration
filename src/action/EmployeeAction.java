package action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.InterceptorRef;
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
import model.Job;


public class EmployeeAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int employeeId;
	private String firstName;
	private String lastName;
	private double salary;
	private int departmentId;
	private int managerId;
	private String jobId;
	private String message;
	
	private Employee employee;
	
	private List<Employee> employees;

	@Autowired
	@Qualifier("empDao")
	EmployeeDAO empDao;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	
	public String insertEmployee() {
		
		try {
			System.out.println("Manager id = "+ managerId);
			Employee manager = new Employee();
			manager.setId(managerId);
			Department department = new Department();
			department.setId(departmentId);
			Job job = new Job();
			job.setId(jobId);
			employee = new Employee(employeeId, firstName, lastName, salary,
					manager, department, job);
			
			empDao.addEmployee(employee);
			return "success";
		}  catch (Exception  e) {
			e.printStackTrace();
			message = e.getMessage();
			return "error";
		}
	}
	
	

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

	public String editEmployee() {
		try {
			Employee manager = new Employee();
			manager.setId(managerId);
			Department department = new Department();
			department.setId(departmentId);
			Job job = new Job();
			job.setId(jobId);
			employee = new Employee(employeeId, firstName, lastName, salary,
					manager, department, job);
			empDao.updateEmployee(employee);
			return "success";
		} catch (Exception e) {
			return "error";
		}
		
	}
	

	public String deleteEmployee() {
		try {
			
			//El id es pasado a traves de la url, y struts se encarga de settear el
			//id automaticamente, el parametro de la url debe llamarse igual que el atributo de
			//esta clase
			empDao.deleteEmployee(employeeId);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public EmployeeDAO getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmployeeDAO empDao) {
		this.empDao = empDao;
	}
	
	

	
	
}
