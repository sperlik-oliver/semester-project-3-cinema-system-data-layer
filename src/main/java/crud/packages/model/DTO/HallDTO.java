package crud.packages.model.DTO;

import crud.packages.model.Entities.Branch;

public class HallDTO {
    private long id;
    private int hallSize;
    private long branchId;

    public HallDTO() {
    }

    public HallDTO(long id, int hallSize, long branchId) {
        this.id = id;
        this.hallSize = hallSize;
        this.branchId = branchId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHallSize() {
        return hallSize;
    }

    public void setHallSize(int hallSize) {
        this.hallSize = hallSize;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }
}
