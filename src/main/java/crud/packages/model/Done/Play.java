package crud.packages.model.Done;


import javax.persistence.*;
import java.util.Date;

//TODO create method to retrieve tickets, hall and movie

@Entity
@Table(name = "plays")
public class Play {

    private long id;
    private Date date;
    private int timeInMinutes;
    private long movieId;
    private long hallId;

    public Play() {
    }

    public Play(long id, Date date, int timeInMinutes, long movieId, long hallId) {
        this.id = id;
        this.date = date;
        this.timeInMinutes = timeInMinutes;
        this.movieId = movieId;
        this.hallId = hallId;
    }

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

    @Column(name = "movie_id")
    public long getMovieId() {
        return movieId;
    }
    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    @Column(name = "hall_id")
    public long getHallId() {
        return hallId;
    }
    public void setHallId(long hallId) {
        this.hallId = hallId;
    }
}
