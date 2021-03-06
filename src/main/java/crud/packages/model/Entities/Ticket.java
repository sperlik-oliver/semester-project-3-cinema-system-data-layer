package crud.packages.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Optional;


@Entity
@Table(name = "tickets")
public class Ticket {

    private long id;
    private int row;
    private int column;
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

    @Column(name = "c_row", nullable = false)
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }

    @Column(name = "c_column", nullable = false)
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "employee_id", nullable = true, updatable = true)
    @JsonIgnoreProperties({"soldTickets", "branch", "password"})
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @ManyToOne(optional = false)
    @JoinColumn (name = "play_id", nullable = false, updatable = true)
    @JsonIgnoreProperties({"tickets", "hall"})
    public Play getPlay() {
        return play;
    }
    public void setPlay(Play play) {
        this.play = play;
    }
}



