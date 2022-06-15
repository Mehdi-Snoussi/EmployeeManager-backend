package tech.mehdi.employeemanager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.mehdi.employeemanager.Model.Employee;
import tech.mehdi.employeemanager.Service.employeeService;


import java.util.List;

@RestController
@RequestMapping("/employee")
public class Employeeressource {
    private final employeeService  employeeservice;


    public Employeeressource(employeeService employeeservice) {
        this.employeeservice = employeeservice;
    }
    
    @GetMapping("/all")
    public ResponseEntity <List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeservice.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity <Employee> getEmployeeById (@PathVariable("id") Long id){
        Employee employee = (Employee) employeeservice.findAllEmployees();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity <Employee> addEmployee (@RequestBody Employee employee){
        Employee newEmployee = employeeservice.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity <Employee> updateEmployee (@RequestBody Employee employee){
        Employee updateEmployee = employeeservice.updateEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <?> deleteEmployee (@PathVariable("id") Long id) {
        employeeservice.deleteEmployee(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
