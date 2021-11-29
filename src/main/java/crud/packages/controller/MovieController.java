package crud.packages.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import crud.packages.exception.ResourceNotFoundException;
import crud.packages.model.Done.Movie;
import crud.packages.repository.MovieRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies () {
        return ResponseEntity.ok().body(movieRepository.findAll());
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovie (@PathVariable(value = "id") Long movieId) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow( () -> new ResourceNotFoundException("Movie not found for this id :: " + movieId));
        return ResponseEntity.ok().body(movie);
    }

    @PostMapping("/movie/create")
    public ResponseEntity<Movie> createMovie (@Valid @RequestBody Movie movie) throws ResourceNotFoundException {
        movieRepository.save(movie);
        return ResponseEntity.ok().body(movie);
    }

    @PutMapping("/movie/edit/{id}")
    public ResponseEntity<Movie> editMovie (@PathVariable(value = "id") Long movieId, @Valid @RequestBody Movie movieDetails) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow ( () -> new ResourceNotFoundException("Movie not found for this id :: " + movieId));
        movie.setDescription(movieDetails.getDescription());
        movie.setDirector(movieDetails.getDirector());
        movie.setGenre(movieDetails.getGenre());
        movie.setLanguage(movieDetails.getLanguage());
        movie.setSubtitleLanguage(movieDetails.getSubtitleLanguage());
        movie.setLengthInMinutes(movieDetails.getLengthInMinutes());
        movie.setTitle(movieDetails.getTitle());
        movie.setYear(movieDetails.getYear());
        movie.setPosterSrc(movieDetails.getPosterSrc());
        final Movie updatedMovie = movieRepository.save(movie);
        return ResponseEntity.ok().body(updatedMovie);
    }

    @DeleteMapping("/movie/delete/{id}")
    public ResponseEntity<Boolean> deleteMovie (@PathVariable(value = "id") Long movieId) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow( () -> new ResourceNotFoundException("Movie not found for this id :: " + movieId));
        movieRepository.delete(movie);
        return ResponseEntity.ok().body(true);
    }
}
