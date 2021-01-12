package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component("empDao")
public class EmployeeDAOMySQL implements EmployeeDAO {

	@Override
	public boolean addEmployee(Employee emp) {
		Session s = SessionFactoryProvider.getSessionFactory().openSession();
		Transaction trans = s.beginTransaction();
		try {
			s.save(emp);
			trans.commit();
			return true;
		} catch (Exception e) {
			trans.rollback();
			return false;
		} finally {
			s.close();
		}
		
	}

	@Override
	public Employee deleteEmployee(int id) {
		Session s = SessionFactoryProvider.getSessionFactory().openSession();
		Transaction trans = s.beginTransaction();
		try {
			Employee emp = s.get(Employee.class, id);
			if (emp != null) {
				s.delete(emp);
			} else {
				System.out.println("No se encuentra el empleado "+ id);
			}
			trans.commit();
			return emp;
		} catch (Exception e) {
			trans.rollback();
			return null;
			// TODO: handle exception
		} finally {
			s.close();
		}
	}

	@Override
	public void updateEmployee(Employee emp) {
		Session s = SessionFactoryProvider.getSessionFactory().openSession();
		Transaction trans = s.beginTransaction();
		try {
			s.update(emp);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			// TODO: handle exception
		} finally {
			s.close();
		}
	}

	@Override
	public Employee selectEmployee(int id) {
		Session s = SessionFactoryProvider.getSessionFactory().openSession();
		try {
			Employee emp = s.get(Employee.class, id);
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
			return new Employee();
		} finally {
			s.close();
		}
	}

	@Override
	public List<Employee> employeeList() {
		Session s = SessionFactoryProvider.getSessionFactory().openSession();
		System.out.println("Listando empleados");
		
		 // Se CriteriaBuilder
        CriteriaBuilder builder = s.getCriteriaBuilder();

        // se crea una query especificando que se desean obtener todos los datos
        //de tipo Employee
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        
        // Se especifica desde donde se traeran los datos
        criteria.from(Employee.class);
		try {
	        // Execute query
	        List<Employee> emps = s.createQuery(criteria).getResultList();
			return emps;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Employee>();
		} finally {
			s.close();
		}
	}

}
