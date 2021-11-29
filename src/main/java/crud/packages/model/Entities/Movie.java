package crud.packages.model.Entities;



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
    private String subtitleLanguage;
    private int lengthInMinutes;
    private int year;
    private String posterSrc;


    public Movie() {
    }

    public Movie(long id, String title, String description, String genre, String director, String language, String subtitleLanguage, int lengthInMinutes, int year, String posterSrc) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.director = director;
        this.language = language;
        this.subtitleLanguage = subtitleLanguage;
        this.lengthInMinutes = lengthInMinutes;
        this.year = year;
        this.posterSrc = posterSrc;

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

    @Column (name = "subtitle_language", nullable = false)
    public String getSubtitleLanguage() {return subtitleLanguage;}
    public void setSubtitleLanguage (String subtitleLanguage) {this.subtitleLanguage = subtitleLanguage;}

    @Column (name = "length_in_minutes", nullable = false)
    public int getLengthInMinutes() {
        return lengthInMinutes;
    }
    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    @Column (name = "year", nullable = false)
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Column (name = "posterSrc", nullable = false)
    public String getPosterSrc() {
        return posterSrc;
    }
    public void setPosterSrc(String posterSrc) {
        this.posterSrc = posterSrc;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", language='" + language + '\'' +
                ", subtitleLanguage='" + subtitleLanguage + '\'' +
                ", lengthInMinutes=" + lengthInMinutes +
                ", year=" + year +
                ", posterSrc='" + posterSrc + '\'' +
                '}';
    }
}