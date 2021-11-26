package crud.packages.model.Done;

import crud.packages.model.Done.Actor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "movie")
public class Movie {

    private long id;
    private String title;
    private String description;
    private String genre;
    private String director;
    private String language;
    private int year;
    private int length;
    private String posterSrc;
    private List<Actor> actors = new ArrayList<>();



    public Movie() {
    }

    public Movie(long id, String title, String description, String genre, String director, String language, int year, int length, String posterSrc, List<Actor> actors) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.director = director;
        this.language = language;
        this.year = year;
        this.length = length;
        this.posterSrc = posterSrc;
        this.actors = actors;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column (name = "title", nullable = false)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column (name = "description", nullable = false)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column (name = "genre", nullable = false)
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column (name = "director", nullable = false)
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    @Column (name = "language", nullable = false)
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    @Column (name = "year", nullable = false)
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Column (name = "length", nullable = false)
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    @Column (name = "posterSrc", nullable = true)
    public String getPosterSrc() {
        return posterSrc;
    }
    public void setPosterSrc(String posterSrc) {
        this.posterSrc = posterSrc;
    }

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Actor> getActors() {return actors;}
    public void setActors (List<Actor> actors){this.actors = actors;}
}
