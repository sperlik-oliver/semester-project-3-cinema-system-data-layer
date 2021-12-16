package crud.packages.controller;

import crud.packages.exception.ResourceNotFoundException;
import crud.packages.model.DTO.EmployeeDTO;
import crud.packages.model.DTO.Login;
import crud.packages.model.Entities.Branch;
import crud.packages.model.Entities.Employee;
import crud.packages.repository.BranchRepository;
import crud.packages.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    BranchRepository branchRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {

            employees.add(employee);
        }
        return ResponseEntity.ok().body(employees);
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
        Branch branch = branchRepository.findById(employeeDTO.getBranchId())
                        .orElseThrow( () -> new ResourceNotFoundException("Branch not found for this id :: " + employeeDTO.getBranchId()));
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPassword(employeeDTO.getPassword());
        employee.setRole(employeeDTO.getRole());
        employee.setCpr(employeeDTO.getCpr());
        employee.setStreet(employeeDTO.getStreet());
        employee.setCity(employeeDTO.getCity());
        employee.setPostcode(employeeDTO.getPostcode());
        employee.setCountry(employeeDTO.getCountry());
        employee.setBirthday(employeeDTO.getBirthday());
        employee.setBranch(branch);
        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/employee/edit/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable (value = "id") Long employeeId, @Valid @RequestBody EmployeeDTO employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not found for this :: " + employeeId));
        Branch branch = branchRepository.findById(employeeDetails.getBranchId())
                .orElseThrow( () -> new ResourceNotFoundException("Branch not found for this id :: " + employeeDetails.getBranchId()));
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
        employee.setBranch(branch);


        final Employee updatedEmployee = employeeRepository.save(employee);
        updatedEmployee.setPassword("");
        return ResponseEntity.ok().body(updatedEmployee);
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee (@PathVariable (value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        employeeRepository.delete(employee);
        return ResponseEntity.ok().body(true);
    }

    @PostMapping("/employee/login")
    public ResponseEntity<Employee> loginEmployee(@Valid @RequestBody Login loginDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.getEmployeeByEmail(loginDetails.getEmail()); {
            if (employee != null) {
                if (loginDetails.getPassword().equals(employee.getPassword())) {
                    return ResponseEntity.ok().body(employee);
                }
                throw new ResourceNotFoundException("Incorrect credentials");
            }
            throw new ResourceNotFoundException("Employee not found for this email :: " + loginDetails.getEmail());
        }

    }
}
