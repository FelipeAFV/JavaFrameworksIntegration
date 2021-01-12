package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@Column(name = "employee_id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "salary")
	private double salary;
	
	
	/*Se especifica la relacion manager-empleado
	 * un manager puede tener muchos empleados a su cargo
	 * se especifica mapped by para que no se cree la tabla
	 * asociativa, la fk de un manager pertenecerá al campo
	 * manager_id de un empleado
	 * */
	@OneToMany(mappedBy = "manager")
	private List<Employee> employees;
	
	/*Se establece la relacion empleado-manager
	el empleado tendra la pk de un manager
	en la columna manager_id*/
	
	@ManyToOne()
	@JoinColumn(name = "manager_id")
	private Employee manager;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department dept;
	
	

	public Employee() {
		super();
	}
	
	public Employee(int id, String firstName, String lastName, double salary, Employee manager, Department dept) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.manager = manager;
		this.dept = dept;
	}
	
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", managerId=" + ", dept=" + dept + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	
	
}
