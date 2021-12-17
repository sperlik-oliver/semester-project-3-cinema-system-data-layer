package crud.packages.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;



@Entity
@Table(name = "branches")
public class Branch {

    private long id;
    private String street;
    private String city;
    private String postcode;
    private String country;
    private Set<Hall> halls;
    private Set<Employee> employees;


    public Branch() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column (name = "street", nullable = false)
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    @Column (name = "city", nullable = false)
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Column (name = "postcode", nullable = false)
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Column (name = "country", nullable = false)
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "branch", orphanRemoval = true)
    @JsonIgnoreProperties({"branch", "programme"})
    public Set<Hall> getHalls () {return halls;}
    public void setHalls(Set<Hall> halls) {this.halls = halls;}

    @OneToMany(mappedBy = "branch", orphanRemoval = false)
    @JsonIgnoreProperties({"branch", "soldTickets", "password"})
    public Set<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
