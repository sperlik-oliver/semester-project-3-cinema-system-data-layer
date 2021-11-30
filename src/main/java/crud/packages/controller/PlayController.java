package crud.packages.controller;

import crud.packages.exception.ResourceNotFoundException;
import crud.packages.model.DTO.PlayDTO;
import crud.packages.model.Entities.Hall;
import crud.packages.model.Entities.Movie;
import crud.packages.model.Entities.Play;
import crud.packages.repository.HallRepository;
import crud.packages.repository.MovieRepository;
import crud.packages.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayController {


    @Autowired
    PlayRepository playRepository;
    @Autowired
    HallRepository hallRepository;
    @Autowired
    MovieRepository movieRepository;
    

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
    public ResponseEntity<Play> createPlay (@Valid @RequestBody PlayDTO playDTO) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(playDTO.getMovieId())
                .orElseThrow( () -> new ResourceNotFoundException("Movie not found"));
        Hall hall = hallRepository.findById(playDTO.getHallId())
                .orElseThrow( () -> new ResourceNotFoundException("Hall not found"));
        Play play = new Play();
        play.setTimeInMinutes(playDTO.getTimeInMinutes());
        play.setDate(playDTO.getDate());
        play.setMovie(movie);
        play.setHall(hall);
        playRepository.save(play);
        return ResponseEntity.ok().body(play);
    }

    @PutMapping("/play/edit/{id}")
    public ResponseEntity<Play> editPlay (@PathVariable(value = "id") Long playId, @Valid @RequestBody PlayDTO playDetails) throws ResourceNotFoundException {
        Play play = playRepository.findById(playId)
                .orElseThrow ( () -> new ResourceNotFoundException("Play not found for this id :: " + playId));
        Movie movie = movieRepository.findById(playDetails.getMovieId())
                .orElseThrow( () -> new ResourceNotFoundException("Movie not found"));
        Hall hall = hallRepository.findById(playDetails.getHallId())
                .orElseThrow( () -> new ResourceNotFoundException("Hall not found"));
        play.setDate(playDetails.getDate());
        play.setHall(hall);
        play.setMovie(movie);
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
