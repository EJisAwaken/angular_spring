package com.example.first_api.repository;

import com.example.first_api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> getAllByIdEmp(int idEmp);

    Optional<Employee> findEmployeeByIdEmp(int idEmp);

    Employee findEmployeeByMatricule(String matricule);

    List<Employee> findAllByIsDeleted(Boolean isDeleted);
}
