package crud.packages.model.Info;

public class HallInfo {
    private long id;
    private int hallSize;


    public HallInfo() {
    }

    public HallInfo(long id, int hallSize) {
        this.id = id;
        this.hallSize = hallSize;

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
}
