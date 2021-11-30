package crud.packages.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

//TODO make method to retrieve play, user and employee of ticket

@Entity
@Table(name = "tickets")
public class Ticket {

    private long id;
    private int row;
    private int column;
//    private long userId;
//    private long employeeId;
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

//    @Column(name = "user_id")
//    public long getUserId() {
//        return userId;
//    }
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }
//
//    @Column(name = "employee_id")
//    public long getEmployee() {
//        return employeeId;
//    }
//    public void setEmployeeId(long employeeId) {
//        this.employeeId = employeeId;
//    }

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
