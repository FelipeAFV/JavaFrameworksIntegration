package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
	
	@Id
	@Column(name = "department_id")
	private int id;
	
	@Column(name = "department_name")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
	private Employee manager;
	
	@OneToMany(mappedBy = "dept")
	private List<Employee> employees;
	
	

	public Department() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Department(int id, String name, Employee manager, List<Employee> employees) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.employees = employees;
	}


	
	

	
	

	
}
