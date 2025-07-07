package com.example.first_api.service;

import com.example.first_api.model.Employee;
import com.example.first_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void insertEmployee(Employee employee) {
        Employee emp = new Employee();
        emp.setNom(employee.getNom());
        emp.setPrenom(employee.getPrenom());
        emp.setMatricule(employee.getMatricule());
        emp.setPoste(employee.getPoste());
        emp.setIsDeleted(false);
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {

        return employeeRepository.findAllByIsDeleted(false);
    }

    public Optional<Employee> getEmployeesByIdEmp(int idEmp) {
        if (employeeRepository.existsById(idEmp)) {
            return employeeRepository.findById(idEmp);

        }
        return employeeRepository.findEmployeeByIdEmp(idEmp);
    }

    public void updateEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findEmployeeByIdEmp(employee.getIdEmp());
        if (existingEmployee.isPresent()) {
            existingEmployee.get().setNom(employee.getNom());
            existingEmployee.get().setPrenom(employee.getPrenom());
            existingEmployee.get().setPoste(employee.getPoste());
            existingEmployee.get().setMatricule(employee.getMatricule());

            employeeRepository.save(existingEmployee.get());
        } else {
            throw new RuntimeException("Employé non trouvé avec l'identifiant : " + employee.getIdEmp());
        }
    }

    public void deleteEmployee(int id) {
        Optional<Employee> existingEmployee = employeeRepository.findEmployeeByIdEmp(id);
        if (existingEmployee.isPresent()) {
            existingEmployee.get().setIsDeleted(true);

            employeeRepository.save(existingEmployee.get());
        } else {
            throw new RuntimeException("Employé non trouvé avec l'identifiant : " + id);
        }
    }






}
