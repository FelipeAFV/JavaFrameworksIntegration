package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import model.Employee;

public class EmployeeService {
	
	public void getJobInfo(int empId) {
		
		Session s = SessionFactoryProvider.getSessionFactory().openSession();
		
		try {
			
			Query q = s.createQuery("from Employee as emp join emp.job where emp.id = "+ empId);
			List<Object[]> empResult = q.getResultList();
			
			//EL resultado es una lista de array de objetos, en este caso la lista
			//tiene un solo array y este array tiene dos onjetos, el employee y el job involucrados 
			//en el join
			Iterator<Object[]> itr = empResult.iterator();
			
			Employee emp = null;
			
			if (itr.hasNext()) {
				Object[] data = itr.next();
				emp = (Employee) data[0];
			}
			
			
			if (emp != null) {
				System.out.println(emp);
			} else {
				System.out.println("El empleado con id " + empId + " no existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			s.close();
		}
	}
}
