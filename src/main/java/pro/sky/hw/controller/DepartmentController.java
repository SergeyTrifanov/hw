package pro.sky.hw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw.model.DepartmentService;
import pro.sky.hw.model.Employee;


import java.util.Map;
import java.util.Set;

@RestController
public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments/max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/departments/min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam(value = "departmentId") int departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/departments/all")
    public Map<Integer, Set<Employee>> departmentEmployeeList(@RequestParam(value = "departmentId", required = false) String departmentId) {

        int id;
        if (departmentId == null) {
            return departmentService.allDepartmentsEmployeeList();
        }
        try {
            id = Integer.parseInt(departmentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return departmentService.departmentEmployeeList(id);

    }
}
