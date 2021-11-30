package crud.packages.controller;

import crud.packages.exception.ResourceNotFoundException;
import crud.packages.model.DTO.EmployeeDTO;
import crud.packages.model.Entities.Employee;
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
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws ResourceNotFoundException {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setBirthday(employeeDTO.getBirthday());
        employee.setCpr(employeeDTO.getCpr());
        employee.setPassword(employeeDTO.getPassword());
        employee.setRole(employeeDTO.getRole());
        employee.setStreet(employeeDTO.getStreet());
        employee.setCity(employeeDTO.getCity());
        employee.setPostcode(employee.getPostcode());
        employee.setCountry(employee.getCountry());
        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/employee/edit/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable (value = "id") Long employeeId, @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not found for this :: " + employeeId));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPassword(employeeDetails.getPassword());
        employee.setRole(employeeDetails.getRole());
        employee.setCpr(employeeDetails.getCpr());
        employee.setStreet(employeeDetails.getStreet());
        employee.setCity(employeeDetails.getCity());
        employee.setPostcode(employeeDetails.getPostcode());
        employee.setCountry(employeeDetails.getCountry());
        employee.setBirthday(employeeDetails.getBirthday());
//        employee.setBranchId(employeeDetails.getBranchId());

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
