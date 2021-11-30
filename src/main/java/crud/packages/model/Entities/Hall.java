package crud.packages.model.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import crud.packages.model.Info.BranchInfo;
import crud.packages.model.Info.HallInfo;

import javax.persistence.*;

//TODO make method to retrieve plays of hall and branch

@Entity
@Table(name = "halls")
public class Hall {

    private long id;
    private int hallSize;
    private Branch branch;

    public Hall() {
    }

    public Hall(long id, int hallSize, Branch branch) {
        this.id = id;
        this.hallSize = hallSize;
        this.branch = branch;
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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn (name = "branch_id", nullable = false, updatable = true)
    @JsonIgnoreProperties("halls")
    public Branch getBranch() {
        return branch;
    }
    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
