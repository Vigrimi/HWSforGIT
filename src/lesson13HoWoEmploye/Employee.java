package lesson13HoWoEmploye;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee
{
    private String name;
    private String company;
    private int salary;
    private int age;

    // TODO: конструктор, геттеры и сеттеры

    public Employee(){}
    public Employee(String name, String company, int salary, int age)
    {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public static List<Employee> employeeGenerator(int num)
    {
        // метод для создания списка объектов класса Employee

        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack",
                "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами

        String[] companies = {"Microsoft", "IBM", "Google", "General Electric",
                "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(getName(names),getCompany(companies),getSalary(),getAge()) );
            // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
        }
        return employees;
    }

    public static String getName(String[] names) {
        String name = names[(int) (Math.random() * names.length)];
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCompany(String[] companies) {
        String company = companies[(int) (Math.random() * companies.length)];
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public static int getSalary() {
        int salary = (int) (Math.random() * 10_000 + 1_000);
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static int getAge() {
        int age = (int) (Math.random() * 40 + 21);
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                " ИМЯ='" + name + '\'' +
                ", КОМПАНИЯ='" + company + '\'' +
                ", З/П=" + salary +
                ", ВОЗРАСТ=" + age +
                '}';
    }

    public static class NameComparator implements Comparator<Employee>
    {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.compareToIgnoreCase(o2.name); // сравниваем по имени
        }
    }
    public static class SalaryComparator implements Comparator<Employee>
    {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.salary,o2.salary);
        }
    }
    public static class AgeComparator implements Comparator<Employee>
    {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.age,o2.age);
        }
    }
    public static class CompanyComparator implements Comparator<Employee>
    {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.company.compareToIgnoreCase(o2.company); // сравниваем по имени
        }
    }

}