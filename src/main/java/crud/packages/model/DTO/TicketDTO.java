package crud.packages.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import crud.packages.model.Entities.Play;

import javax.persistence.*;


public class TicketDTO {

    private int row;
    private int column;
//    private long userId;
//    private long employeeId;
    private long playId;

    public TicketDTO() {
    }


    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }

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

    public long getPlayId() {
        return playId;
    }
    public void setPlayId(long playId) {
        this.playId = playId;
    }
}
