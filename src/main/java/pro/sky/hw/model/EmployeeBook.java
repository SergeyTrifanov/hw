package pro.sky.hw.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeBook {

    Map<String, Employee> eBook;

    public EmployeeBook() {
        this.eBook = new HashMap<>();
    }

    public Employee add(Employee e){
        if(e == null){
            throw new IllegalArgumentException("Illegal argument in method EmployeeBook.add()!");
        }
        String key = e.getFirstName() + e.getMiddleName() + e.getLastName();
        eBook.put(key, e);
        return eBook.get(key);
    }

    public Employee add(String firsName, String middleName, String lastName, int department, double salary){
        Employee e = new Employee(firsName, middleName, lastName, department, salary);
        String key = e.getFirstName() + e.getMiddleName() + e.getLastName();
        eBook.put(key, e);
        return eBook.get(key);
    }

    public Employee remove(String firstName, String middleName, String lastName){
        String key = firstName + middleName + lastName;
        if(eBook.containsKey(key))
            return eBook.remove(key);
        else
            throw new RuntimeException("There is no employee with such first, middle and last names!");
    }

    public Employee find(String firstName, String middleName, String lastName){
        String key = firstName + middleName + lastName;
        if(eBook.containsKey(key))
            return eBook.get(key);
        else
            throw new RuntimeException("There is no employee with such first, middle and last names!");
    }

    public Map<String, Employee> allEmployeeList(){
        return eBook;
    }

    public Employee findEmployeeWithMaxSalary(int department){
        String key = eBook.keySet().stream()
                .filter(s -> eBook.get(s).getDepartment() == department)
                .max(Comparator.comparingDouble(s -> eBook.get(s).getSalary()))
                .orElseThrow(() -> new RuntimeException("Wrong department number in the " +
                        "eBook.findEmployeeWithMaxSalary() method"));
        return eBook.get(key);
    }

    public Employee findEmployeeWithMinSalary(int department){
        String key = eBook.keySet().stream()
                .filter(s -> eBook.get(s).getDepartment() == department)
                .min(Comparator.comparingDouble(s -> eBook.get(s).getSalary()))
                .orElseThrow(() -> new RuntimeException("Wrong department number in the " +
                        "eBook.findEmployeeWithMaxSalary() method"));
        return eBook.get(key);
    }

    public Map<Integer, Set<Employee>> listOfDepartment(int department){
        return  eBook.keySet().stream()
                .filter(s -> eBook.get(s).getDepartment() == department)
                .map(s -> eBook.get(s))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
    }

    public Map<Integer, Set<Employee>> allEmployeeListByDepartments(){
        return  eBook.keySet().stream()
                .map(s -> eBook.get(s))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
    }

}