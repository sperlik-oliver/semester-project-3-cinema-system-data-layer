package crud.packages.model.Done;

import javax.persistence.*;

@Entity
@Table (name = "seats")
public class Seat {

    public Seat() {
    }

    public Seat(long id, int column, int row) {
        this.id = id;
        this.column = column;
        this.row = row;
    }


    public long id;
    public int column;
    public int row;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "_column", nullable = false)
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }

    @Column(name = "_row", nullable = false)
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
}
