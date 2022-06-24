package pro.sky.hw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw.model.Employee;
import pro.sky.hw.model.EmployeeService;

import java.util.Map;

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

}