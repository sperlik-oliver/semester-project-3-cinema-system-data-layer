package crud.packages.model.DTO;


import javax.persistence.*;
import java.util.Date;


public class PlayDTO {

    private String date;
    private int timeInMinutes;
    private long movieId;
    private int price;
    private long hallId;

    public PlayDTO() {
    }


    public String getDate() {
        return date;
    }
    public void setDate(String date) {
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

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
