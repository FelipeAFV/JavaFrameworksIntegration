package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

	@Id
	@Column(name = "job_id")
	private String id;
	
	@Column(name = "job_title")
	private String title;
	
	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@OneToMany(mappedBy = "job")
	private List<Employee> employees;
	

	public Job() {
		super();
	}


	public Job(String id, String title, double minSalary, double maxSalary, List<Employee> employees) {
		super();
		this.id = id;
		this.title = title;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.employees = employees;
	}
	


	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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
