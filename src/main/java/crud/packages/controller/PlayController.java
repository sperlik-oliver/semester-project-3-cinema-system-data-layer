package crud.packages.controller;

import crud.packages.exception.ResourceNotFoundException;
import crud.packages.model.Entities.Play;
import crud.packages.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayController {


    @Autowired
    PlayRepository playRepository;
    

    @GetMapping("/plays")
    public ResponseEntity<List<Play>> getAllPlayes () {
        return ResponseEntity.ok().body(playRepository.findAll());
    }

    @GetMapping("/play/{id}")
    public ResponseEntity<Play> getPlay (@PathVariable(value = "id") Long playId) throws ResourceNotFoundException {
        Play play = playRepository.findById(playId)
                .orElseThrow( () -> new ResourceNotFoundException("Play not found for this id :: " + playId));
        return ResponseEntity.ok().body(play);
    }

    @PostMapping("/play/create")
    public ResponseEntity<Play> createPlay (@Valid @RequestBody Play play) throws ResourceNotFoundException {
        playRepository.save(play);
        return ResponseEntity.ok().body(play);
    }

    @PutMapping("/play/edit/{id}")
    public ResponseEntity<Play> editPlay (@PathVariable(value = "id") Long playId, @Valid @RequestBody Play playDetails) throws ResourceNotFoundException {
        Play play = playRepository.findById(playId)
                .orElseThrow ( () -> new ResourceNotFoundException("Play not found for this id :: " + playId));
        play.setDate(playDetails.getDate());
        play.setHallId(playDetails.getHallId());
        play.setMovieId(playDetails.getMovieId());
        play.setTimeInMinutes(playDetails.getTimeInMinutes());
        final Play updatedPlay = playRepository.save(play);
        return ResponseEntity.ok().body(updatedPlay);
    }

    @DeleteMapping("/play/delete/{id}")
    public ResponseEntity<Boolean> deletePlay (@PathVariable(value = "id") Long playId) throws ResourceNotFoundException {
        Play play = playRepository.findById(playId)
                .orElseThrow( () -> new ResourceNotFoundException("Play not found for this id :: " + playId));
        playRepository.delete(play);
        return ResponseEntity.ok().body(true);
    }
    
}
