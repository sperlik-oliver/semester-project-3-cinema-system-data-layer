package crud.packages.controller;

import crud.packages.exception.ResourceNotFoundException;
import crud.packages.model.DTO.HallDTO;
import crud.packages.model.Entities.Branch;
import crud.packages.model.Entities.Hall;
import crud.packages.model.Info.BranchInfo;
import crud.packages.repository.BranchRepository;
import crud.packages.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HallController {

    @Autowired
    HallRepository hallRepository;
    @Autowired
    BranchRepository branchRepository;




    @GetMapping("/halls")
    public ResponseEntity<List<Hall>> getAllHalls () {
        return ResponseEntity.ok().body(hallRepository.findAll());
    }

    @GetMapping("/hall/{id}")
    public ResponseEntity<Hall> getHall (@PathVariable(value = "id") Long hallId) throws ResourceNotFoundException {
        Hall hall = hallRepository.findById(hallId)
                .orElseThrow( () -> new ResourceNotFoundException("Hall not found for this id :: " + hallId));
        return ResponseEntity.ok().body(hall);
    }

//    @GetMapping("/hall/{id}/branch")
//    public ResponseEntity<Branch> getHallBranch (@PathVariable(value = "id") Long hallId) throws ResourceNotFoundException {
//        Branch branch = hallRepository.getHallBranch(hallId);
//        return ResponseEntity.ok().body(branch);
//    }

    @PostMapping("/hall/create")
    public ResponseEntity<Hall> createHall (@Valid @RequestBody HallDTO hallDTO) throws ResourceNotFoundException {
        Branch branch = branchRepository.findById((long)hallDTO.getBranchId())
                        .orElseThrow( () -> new ResourceNotFoundException("Branch not found"));
        Hall hall = new Hall();
        hall.setHallSize(hallDTO.getHallSize());
        BranchInfo branchInfo = new BranchInfo();
        branchInfo.setId(branch.getId());
        branchInfo.setCity(branch.getCity());
        branchInfo.setCountry(branch.getCountry());
        branchInfo.setPostcode(branch.getPostcode());
        branchInfo.setStreet(branch.getStreet());
        hall.setBranch(branch);
        hallRepository.save(hall);
        hall.getBranch().setHalls(null);
        return ResponseEntity.ok().body(hall);
    }

    @PutMapping("/hall/edit/{id}")
    public ResponseEntity<Hall> editHall (@PathVariable(value = "id") Long hallId, @Valid @RequestBody Hall hallDetails) throws ResourceNotFoundException {
        Hall hall = hallRepository.findById(hallId)
                .orElseThrow ( () -> new ResourceNotFoundException("Hall not found for this id :: " + hallId));
        hall.setHallSize(hallDetails.getHallSize());
        hall.setBranch(hallDetails.getBranch());
        final Hall updatedHall = hallRepository.save(hall);
        return ResponseEntity.ok().body(updatedHall);
    }

    @DeleteMapping("/hall/delete/{id}")
    public ResponseEntity<Boolean> deleteHall (@PathVariable(value = "id") Long hallId) throws ResourceNotFoundException {
        Hall hall = hallRepository.findById(hallId)
                .orElseThrow( () -> new ResourceNotFoundException("Hall not found for this id :: " + hallId));
        hallRepository.delete(hall);
        return ResponseEntity.ok().body(true);
    }
    
}
