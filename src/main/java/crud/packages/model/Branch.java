package crud.packages.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "branches")
public class Branch {

    public long id;
    public String city;
    public ArrayList<Hall> halls;


    public Branch() {
    }

    public Branch(long id, String city, ArrayList<Hall> halls) {
        this.id = id;
        this.city = city;
        this.halls = halls;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column (name = "city")
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Column (name = "hall")
    public ArrayList<Hall> getHalls() {
        return halls;
    }
    public void setHalls(ArrayList<Hall> halls) {
        this.halls = halls;
    }
}
