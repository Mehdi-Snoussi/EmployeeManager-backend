package tech.mehdi.employeemanager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.mehdi.employeemanager.Model.Employee;
import java.util.Optional;

public interface repository extends JpaRepository<Employee, Long> {
    public void deleteById(int id);
    Optional <Employee> findEmployeeById(Long id);
}
