package crud.packages.model.Done;

import javax.persistence.*;

//TODO make method to retrieve plays of hall and branch

@Entity
@Table(name = "halls")
public class Hall {

    private long id;
    private int hallSize;
    private long branchId;

    public Hall() {
    }

    public Hall(long id, int hallSize, int branchId) {
        this.id = id;
        this.hallSize = hallSize;
        this.branchId = branchId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column (name = "hall_size")
    public int getHallSize() {
        return hallSize;
    }
    public void setHallSize(int hallSize) {
        this.hallSize = hallSize;
    }

    @Column (name = "branch_id")
    @ManyToOne
    public long getBranchId() {
        return branchId;
    }
    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }
}
