package crud.packages.controller;

import crud.packages.exception.ResourceNotFoundException;
import crud.packages.model.Done.Actor;
import crud.packages.repository.ActorRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/actors")
    public ResponseEntity<List<Actor>> getAllActors () {
        return ResponseEntity.ok().body(actorRepository.findAll());
    }

    @GetMapping("/actor/{id}")
    public ResponseEntity<Actor> getActor (@PathVariable(value = "id") Long actorId) throws ResourceNotFoundException {
        Actor actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new ResourceNotFoundException("Actor not found for this id :: " + actorId));
        return ResponseEntity.ok().body(actor);
    }

    @PostMapping("/actor/create")
    public ResponseEntity<Actor> createActor (@Valid @RequestBody Actor actor)  {
        actorRepository.save(actor);
        return ResponseEntity.ok().body(actor);
    }

    @PutMapping("/actor/edit/{id}")
    public ResponseEntity<Actor> editActor (@PathVariable (value = "id") Long actorId, @Valid @RequestBody Actor actorDetails) throws ResourceNotFoundException {
        Actor actor = actorRepository.findById(actorId)
                .orElseThrow( () -> new ResourceNotFoundException("Actor not found for this id :: " + actorId));
        actor.setMovie(actorDetails.getMovie());
        actor.setName(actorDetails.getName());
        final Actor updatedActor = actorRepository.save(actor);
        return ResponseEntity.ok().body(updatedActor);
    }

    @DeleteMapping("/actor/delete/{id}")
    public ResponseEntity<Boolean> deleteActor (@PathVariable (value = "id") Long actorId) throws ResourceNotFoundException{
        Actor actor = actorRepository.findById(actorId)
                .orElseThrow( () -> new ResourceNotFoundException("Actor not found for this id ::" + actorId));
        actorRepository.delete(actor);
        return ResponseEntity.ok().body(true);
    }
}
