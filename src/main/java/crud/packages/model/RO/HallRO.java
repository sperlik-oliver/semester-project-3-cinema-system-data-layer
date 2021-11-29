package crud.packages.model.RO;

import crud.packages.model.Info.BranchInfo;

public class HallRO {
    private long id;
    private int hallSize;
    private BranchInfo branch;

    public HallRO() {
    }



    public int getHallSize() {
        return hallSize;
    }

    public void setHallSize(int hallSize) {
        this.hallSize = hallSize;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BranchInfo getBranch() {
        return branch;
    }

    public void setBranch(BranchInfo branch) {
        this.branch = branch;
    }
}
