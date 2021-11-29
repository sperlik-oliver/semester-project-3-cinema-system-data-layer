package crud.packages.model;

import javax.persistence.*;

//TODO make method to retrieve play, user and employee of ticket

@Entity
@Table(name = "tickets")
public class Ticket {

    private long id;
    private int row;
    private int column;
    private int userId;
    private int employeeId;
    private int playId;

    public Ticket() {
    }

    public Ticket(long id, int row, int column, int userId, int employeeId, int playId) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.userId = userId;
        this.employeeId = employeeId;
        this.playId = playId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "row")
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }

    @Column(name = "column")
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }

    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "employee_id")
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "play_id")
    public int getPlayId() {
        return playId;
    }
    public void setPlayId(int playId) {
        this.playId = playId;
    }
}
