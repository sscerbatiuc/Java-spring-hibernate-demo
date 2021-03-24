package edu.step.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDao {

    /**
     * Read all the Employees.
     *
     * @return a List of Employees
     */
    public static List<Employee> getAll() {
        List<Employee> emps = null;
        // sessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // conectam la baza de date
        Session session = sessionFactory.openSession();
        // initializam obiectul tranzactiei
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
           emps = session.createQuery("FROM Employee").list();
            transaction.commit();

        } catch (HibernateException ex) {
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("Eroare!");
        } finally {
            session.close();
        }
        return emps;
    }

    /**
     * Creates an employee.
     * @param emp {@link Employee}
     */
    public static void create(Employee emp) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(emp);
            transaction.commit();
        } catch (HibernateException ex) {
            if(transaction != null){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    /**
     * Delete the existing Employee.
     *
     * @param id
     */
    public static void delete(int id) {
        // Create a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            // Begin a transaction
            transaction = session.beginTransaction();
            // Get the Employee from the database.
            Employee employee = (Employee) session.get(Employee.class, id);
            // Delete the student
            session.delete(employee);
            // Commit the transaction
            transaction.commit();
        } catch (HibernateException ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }
    }

    /**
     * Update the existing Employee.
     *
     * @param id
     * @param name
     * @param phoneNo
     */
    public static void update(Integer id, String address, String name, String phoneNo) {
        // Create a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            // Begin a transaction
            transaction = session.beginTransaction();
            // Get the Employee from the database.
            Employee emp = (Employee) session.get(Employee.class, id);
            // Change the values
            emp.setName(name);
            emp.setAddress(address);
            emp.setPhoneno(phoneNo);
            // Update the student
            session.update(emp);

            // Commit the transaction
            transaction.commit();
        } catch (HibernateException ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }
    }
}
