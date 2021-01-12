package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
	
	@Id
	@Column(name = "department_id")
	private int id;
	
	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@OneToMany(mappedBy = "dept")
	private List<Employee> employees;
	
	

	public Department() {
		super();
	}

	public Department(int id, double minSalary, double maxSalary, List<Employee> employees) {
		super();
		this.id = id;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.employees = employees;
	}
	
	

	@Override
	public String toString() {
		return "Department [id=" + id + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary + ", employees="
				+ employees + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
