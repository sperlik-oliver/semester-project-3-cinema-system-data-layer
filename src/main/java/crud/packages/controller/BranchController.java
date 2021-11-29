package crud.packages.controller;

import crud.packages.exception.ResourceNotFoundException;
import crud.packages.model.Entities.Branch;
import crud.packages.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BranchController {
    
    @Autowired
    BranchRepository branchRepository;
    



        @GetMapping("/branches")
        public ResponseEntity<List<Branch>> getAllBranches () {
            return ResponseEntity.ok().body(branchRepository.findAll());
        }

        @GetMapping("/branch/{id}")
        public ResponseEntity<Branch> getBranch (@PathVariable(value = "id") Long branchId) throws ResourceNotFoundException {
            Branch branch = branchRepository.findById(branchId)
                    .orElseThrow( () -> new ResourceNotFoundException("Branch not found for this id :: " + branchId));
            return ResponseEntity.ok().body(branch);
        }

        @PostMapping("/branch/create")
        public ResponseEntity<Branch> createBranch (@Valid @RequestBody Branch branch) throws ResourceNotFoundException {
            branchRepository.save(branch);
            return ResponseEntity.ok().body(branch);
        }

        @PutMapping("/branch/edit/{id}")
        public ResponseEntity<Branch> editBranch (@PathVariable(value = "id") Long branchId, @Valid @RequestBody Branch branchDetails) throws ResourceNotFoundException {
            Branch branch = branchRepository.findById(branchId)
                    .orElseThrow ( () -> new ResourceNotFoundException("Branch not found for this id :: " + branchId));
            branch.setCity(branchDetails.getCity());
            branch.setPostcode(branchDetails.getPostcode());
            branch.setStreet(branchDetails.getStreet());
            branch.setCountry(branchDetails.getCountry());
            final Branch updatedBranch = branchRepository.save(branch);
            return ResponseEntity.ok().body(updatedBranch);
        }

        @DeleteMapping("/branch/delete/{id}")
        public ResponseEntity<Boolean> deleteBranch (@PathVariable(value = "id") Long branchId) throws ResourceNotFoundException {
            Branch branch = branchRepository.findById(branchId)
                    .orElseThrow( () -> new ResourceNotFoundException("Branch not found for this id :: " + branchId));
            branchRepository.delete(branch);
            return ResponseEntity.ok().body(true);
        }
    }


