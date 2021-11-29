package crud.packages.model.DTO;

import crud.packages.model.Entities.Branch;

public class HallDTO {
    private int hallSize;
    private int branchId;

    public HallDTO() {
    }

    public HallDTO(int hallSize, int branchId) {
        this.hallSize = hallSize;
        this.branchId = branchId;
    }


    public int getHallSize() {
        return hallSize;
    }

    public void setHallSize(int hallSize) {
        this.hallSize = hallSize;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}
