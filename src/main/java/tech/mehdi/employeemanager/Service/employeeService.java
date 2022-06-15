package tech.mehdi.employeemanager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.mehdi.employeemanager.Model.Employee;
import tech.mehdi.employeemanager.Repository.repository;
import tech.mehdi.employeemanager.Service.Exception.userNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class employeeService {
    private final repository employeeRepo;
    @Autowired
    public employeeService(repository employeeRepo){
        this.employeeRepo= employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID(),toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);

    }

    public void deleteEmployee(long id){
        employeeRepo.deleteById(id);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new userNotFoundException("User by id "+ id +" is not found!"));
    }


}
