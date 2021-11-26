package crud.packages.controller;

import crud.packages.exception.ResourceNotFoundException;
import crud.packages.model.Done.Employee;
import crud.packages.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeRepository.findAll());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable (value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employee/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) throws ResourceNotFoundException {
        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/employee/edit/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable (value = "id") Long employeeId, @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not found for this :: " + employeeId));
        employee.setEmail(employeeDetails.getEmail());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setPassword(employeeDetails.getPassword());
        employee.setStreet(employeeDetails.getStreet());
        employee.setPostcode(employeeDetails.getPostcode());
        employee.setCountry(employeeDetails.getCountry());
        employee.setSettlement(employeeDetails.getSettlement());
        employee.setBirthday(employeeDetails.getBirthday());
        employee.setCpr(employeeDetails.getCpr());
        employee.setRole(employeeDetails.getRole());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok().body(updatedEmployee);
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee (@PathVariable (value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        employeeRepository.delete(employee);
        return ResponseEntity.ok().body(true);
    }
}
