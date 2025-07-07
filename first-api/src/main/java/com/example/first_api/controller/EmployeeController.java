package com.example.first_api.controller;

import com.example.first_api.model.Employee;
import com.example.first_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/insert")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/delete")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Employee>> getAllEmployees(@PathVariable int id) {
        Optional<Employee> employee = employeeService.getEmployeesByIdEmp(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
