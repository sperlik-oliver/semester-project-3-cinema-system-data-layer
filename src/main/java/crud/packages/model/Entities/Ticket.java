package crud.packages.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Optional;

//TODO make method to retrieve play, user and employee of ticket

@Entity
@Table(name = "tickets")
public class Ticket {

    private long id;
    private int row;
    private int column;
    private User user;
    private Employee employee;
    private Play play;

    public Ticket() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "_row")
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }

    @Column(name = "_column")
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "employee_id", nullable = true, updatable = true)
    @JsonIgnoreProperties("soldTickets")
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id", nullable = true, updatable = true)
    @JsonIgnoreProperties("purchasedTickets")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(optional = false)
    @JoinColumn (name = "play_id", nullable = false, updatable = true)
    @JsonIgnoreProperties("tickets")
    public Play getPlay() {
        return play;
    }
    public void setPlay(Play play) {
        this.play = play;
    }
}
