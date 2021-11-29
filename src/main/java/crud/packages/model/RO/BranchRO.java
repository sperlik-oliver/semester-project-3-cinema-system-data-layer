package crud.packages.model.RO;


import crud.packages.model.Info.BranchInfo;
import crud.packages.model.Info.HallInfo;

import java.util.Set;

public class BranchRO {

    private long id;
    private String street;
    private String city;
    private String postcode;
    private String country;
    private Set<HallInfo> halls;

    public BranchRO() {
    }

    public BranchRO(long id, String street, String city, String postcode, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<HallInfo> getHalls() {
        return halls;
    }

    public void setHalls(Set<HallInfo> halls) {
        this.halls = halls;
    }
}
