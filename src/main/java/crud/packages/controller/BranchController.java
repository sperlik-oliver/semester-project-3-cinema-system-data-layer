package crud.packages.controller;

import crud.packages.exception.ResourceNotFoundException;
import crud.packages.model.DTO.BranchDTO;
import crud.packages.model.Entities.Branch;
import crud.packages.model.Entities.Hall;
import crud.packages.model.Info.HallInfo;
import crud.packages.model.RO.BranchRO;
import crud.packages.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        public ResponseEntity<BranchRO> createBranch (@Valid @RequestBody BranchDTO branchDTO) throws ResourceNotFoundException {
            Branch branch = new Branch();
            branch.setCity(branchDTO.getCity());
            branch.setStreet(branchDTO.getStreet());
            branch.setCountry(branchDTO.getCountry());
            branch.setPostcode(branchDTO.getPostcode());
            branchRepository.save(branch);

            BranchRO branchRO = new BranchRO();
            branchRO.setCity(branch.getCity());
            branchRO.setCountry(branch.getCountry());
            branchRO.setPostcode(branch.getPostcode());
            branchRO.setStreet(branch.getStreet());
            branchRO.setId(branch.getId());
            ArrayList<HallInfo> hallsReturned = new ArrayList<HallInfo>();
            HallInfo hallInfo = null;
            for (Hall hall : branch.getHalls()) {
                hallInfo.setHallSize(hall.getHallSize());
                hallInfo.setId(hall.getId());
                hallsReturned.add(hallInfo);
            }
            branchRO.setHalls((Set<HallInfo>) hallsReturned);
            return ResponseEntity.ok().body(branchRO);
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


