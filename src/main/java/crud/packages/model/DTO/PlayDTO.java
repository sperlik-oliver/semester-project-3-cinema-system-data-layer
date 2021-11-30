package crud.packages.model.DTO;


import javax.persistence.*;
import java.util.Date;


public class PlayDTO {

    private Date date;
    private int timeInMinutes;
    private long movieId;
    private long hallId;

    public PlayDTO() {
    }

    public PlayDTO(Date date, int timeInMinutes, long movieId, long hallId) {
        this.date = date;
        this.timeInMinutes = timeInMinutes;
        this.movieId = movieId;
        this.hallId = hallId;
    }


    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }
    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public long getMovieId() {
        return movieId;
    }
    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getHallId() {
        return hallId;
    }
    public void setHallId(long hallId) {
        this.hallId = hallId;
    }
}
