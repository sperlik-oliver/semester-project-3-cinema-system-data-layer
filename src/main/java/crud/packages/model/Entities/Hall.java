package crud.packages.model.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "halls")
public class Hall {

    private long id;
    private int hallSize;
    private Branch branch;
    private Set<Play> programme;

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

    @Column (name = "hall_size", nullable = false)
    public int getHallSize() {
        return hallSize;
    }
    public void setHallSize(int hallSize) {
        this.hallSize = hallSize;
    }

    @ManyToOne(optional = false)
    @JoinColumn (name = "branch_id", nullable = false, updatable = true)
    @JsonIgnoreProperties("halls")
    public Branch getBranch() {
        return branch;
    }
    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @OneToMany(mappedBy = "hall")
    @JsonIgnoreProperties({"hall", "tickets"})
    public Set<Play> getProgramme() {
        return programme;
    }
    public void setProgramme(Set<Play> programme) {
        this.programme = programme;
    }
}
