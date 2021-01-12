package model;

import java.util.List;

public interface EmployeeDAO {
	
	public List<Employee> employeeList();
	public boolean addEmployee(Employee emp);
	public Employee deleteEmployee(int id);
	public void updateEmployee(Employee emp);
	public Employee selectEmployee(int id);
}
