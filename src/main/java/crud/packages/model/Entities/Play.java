package crud.packages.model.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

//TODO create method to retrieve tickets, hall and movie

@Entity
@Table(name = "plays")
public class Play {

    private long id;
    private Date date;
    private int timeInMinutes;
    private Movie movie;
    private Hall hall;

    public Play() {}


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "time_in_minutes")
    public int getTimeInMinutes() {
        return timeInMinutes;
    }
    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    @ManyToOne(optional = false)
    @JoinColumn (name = "movie_id", nullable = false, updatable = true)
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne(optional = false)
    @JoinColumn (name = "hall_id", nullable = false, updatable = true)
    @JsonIgnoreProperties("programme")
    public Hall getHall() {
        return hall;
    }
    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
