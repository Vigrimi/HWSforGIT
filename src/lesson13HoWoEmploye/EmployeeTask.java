package lesson13HoWoEmploye;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(20);
        System.out.println("\nДописать метод employeeGenerator.\n");
        for (Employee em : employees)
        {
            System.out.println(em);
        }
        // Дописать метод employeeGenerator и
        // отсортировать его по:
        // имени
        Comparator<Employee> comparByName = new Employee.NameComparator() ;
        List<Employee> employeesComparByName = employees;
        Collections.sort(employeesComparByName, comparByName);
        System.out.println("\nотсортировать его по: имени \n" + employeesComparByName);

        // имени и зарплате
        Comparator<Employee> comparByNameAndSalary = new Employee.NameComparator()
                .thenComparing(new Employee.SalaryComparator()) ;
        List<Employee> employeesComparByNameAndSalary = employees;
        Collections.sort(employeesComparByNameAndSalary, comparByNameAndSalary);
        System.out.println("\nотсортировать его по: имени и зарплате \n" + employeesComparByNameAndSalary);

        // имени, зарплате, возрасту и компании
        Comparator<Employee> comparByNameSalaryAgeCompany = new Employee.NameComparator()
                .thenComparing(new Employee.SalaryComparator()).thenComparing(new Employee.AgeComparator())
                .thenComparing(new Employee.CompanyComparator());
        List<Employee> employeesComparByNameSalaryAgeCompany = employees;
        Collections.sort(employeesComparByNameSalaryAgeCompany,comparByNameSalaryAgeCompany);
        System.out.println("\nотсортировать его по: имени, зарплате, возрасту и компании \n"
                + employeesComparByNameSalaryAgeCompany);


    }
}