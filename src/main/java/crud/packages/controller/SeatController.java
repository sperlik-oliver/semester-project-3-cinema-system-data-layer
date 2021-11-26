package crud.packages.controller;

import crud.packages.exception.ResourceNotFoundException;
import crud.packages.model.Done.Actor;
import crud.packages.model.Done.Seat;
import crud.packages.repository.SeatRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/seats")
    public ResponseEntity<List<Seat>> getAllSeats () {
        return ResponseEntity.ok().body(seatRepository.findAll());
    }

    @GetMapping("/seat/{id}")
    public ResponseEntity<Seat> getSeat (@PathVariable(value = "id") Long seatId) throws ResourceNotFoundException {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new ResourceNotFoundException("Seat not found for this id :: " + seatId));
        return ResponseEntity.ok().body(seat);
    }

    @PostMapping("/seat/create")
    public ResponseEntity<Seat> createSeat (@Valid @RequestBody Seat seat) {
        seatRepository.save(seat);
        return ResponseEntity.ok().body(seat);
    }

    @PutMapping("/seat/edit/{id}")
    public ResponseEntity<Seat> editSeat (@PathVariable(value = "id") Long seatId, @Valid @RequestBody Seat seatDetails) throws ResourceNotFoundException{
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new ResourceNotFoundException("Seat not found for this id :: " + seatId));
        seat.setColumn(seatDetails.getColumn());
        seat.setRow(seat.getRow());
        final Seat updatedSeat = seatRepository.save(seatDetails);
        return ResponseEntity.ok().body(updatedSeat);
    }

    @DeleteMapping("/seat/delete/{id}")
    public ResponseEntity<Boolean> deleteSeat(@PathVariable(value = "id") Long seatId) throws ResourceNotFoundException {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new ResourceNotFoundException("Seat not found for this id :: " + seatId));
        seatRepository.delete(seat);
        return ResponseEntity.ok().body(true);
    }

}
