package crud.packages.model.Info;

public class HallInfo {
    private long id;
    private int hallSize;
    private int branchId;

    public HallInfo() {
    }

    public HallInfo(long id, int hallSize, int branchId) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
