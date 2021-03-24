package edu.step.hibernate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> all = EmployeeDao.getAll();
        for(Employee employee: all){
            System.out.println(employee.getName());
        }
        EmployeeDao.create(new Employee("Random 221", "Address 222", "Phoneno"));
        HibernateUtil.shutdown();
    }
}
