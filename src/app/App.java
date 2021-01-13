package app;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Department;
import model.Employee;
import service.EmployeeService;
import service.SessionFactoryProvider;

public class App {
	
	public static void main(String[] args) {
//		Session session = SessionFactoryProvider.getSessionFactory().openSession();
//		
////		Department dep = new Department(1, 2000, 20000 ,new ArrayList<Employee>());		
////		Employee emp1 = new Employee(1,"Felipe","Figueroa",3000,null,dep);
////		Employee emp2 = new Employee(2,"Felipe","Vergara",4000,emp1,dep);
////		
//		Transaction t = session.beginTransaction();
//		
//		//session.save(dep);
////		session.save(emp1);
////		session.save(emp2);
//		
//		Employee emp = session.get(Employee.class, 200);
//		System.out.println(emp.getManager().getId()+ "4");
//		
////		System.out.println(emp);
//		
//		
//		t.commit();
//		session.close();
		
		EmployeeService empService = new EmployeeService();
		
		empService.getJobInfo(2);
	}

}
