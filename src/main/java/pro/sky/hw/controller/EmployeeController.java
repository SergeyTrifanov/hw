package pro.sky.hw.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw.model.Employee;
import pro.sky.hw.model.EmployeeService;

import java.util.Map;
import java.util.Set;

@RestController
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/add")
    public Employee addEmployee(@RequestParam("firstname") String firstName,
                                @RequestParam("middlename") String middleName,
                                @RequestParam("lastname") String lastName,
                                @RequestParam("department") int department,
                                @RequestParam("salary") double salary) {
        return employeeService.addEmployee(firstName, middleName, lastName, department, salary);
    }

    @GetMapping("/employee/remove")
    public Employee removeEmployee(@RequestParam("firstname") String firstName,
                                   @RequestParam("middlename") String middleName,
                                   @RequestParam("lastname") String lastName) {
        return employeeService.removeEmployee(firstName, middleName, lastName);
    }

    @GetMapping("/employee/find")
    public Employee findEmployee(@RequestParam("firstname") String firstName,
                                 @RequestParam("middlename") String middleName,
                                 @RequestParam("lastname") String lastName) {
        return employeeService.findEmployee(firstName, middleName, lastName);
    }

    @GetMapping("/employee/list")
    public Map<String, Employee> employeeList() {
        return employeeService.allEmployeeList();
    }

    @GetMapping("/departments/max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/departments/min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam(value = "departmentId") int departmentId) {
        return employeeService.findEmployeeWithMinSalary(departmentId);
    }


    @GetMapping("/departments/all")
    public Map<Integer, Set<Employee>> departmentEmployeeList(@RequestParam(value = "departmentId", required = false) String departmentId) {

        int id;
        if (departmentId == null) {
            return employeeService.allDepartmentsEmployeeList();
        }
        try {
            id = Integer.parseInt(departmentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employeeService.departmentEmployeeList(id);

    }
}
