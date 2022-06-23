package pro.sky.hw.model;

import java.util.Map;
import java.util.Set;

public interface EmployeeService {


    Employee addEmployee(String firstName, String middleName, String lastName, int department, double salary);
    Employee removeEmployee(String firstName, String middleName, String lastName);
    Employee findEmployee(String firstName, String middleName, String lastName);
    Map<String, Employee> allEmployeeList();

    Employee findEmployeeWithMaxSalary(int department);

    Employee findEmployeeWithMinSalary(int department);

    Map<Integer, Set<Employee>> departmentEmployeeList(int department);

    Map<Integer, Set<Employee>> allDepartmentsEmployeeList();

}
