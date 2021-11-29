package crud.packages.model.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "employees")
public class Employee {

//TODO make method to retrieve branch and sold tickets

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int role;
    private String cpr;
    private String street;
    private String city;
    private String postcode;
    private String country;
    private Date birthday;
    private long branchId;
    

    public Employee() {
    }

    public Employee(long id, String firstName, String lastName, String email, String password, String street, String postcode, String city, String country, int role, String cpr, Date birthday, long branchId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.role = role;
        this.cpr = cpr;
        this.birthday = birthday;
        this.branchId = branchId;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "firstName", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "street", nullable = false)
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "postcode", nullable = false)
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "country", nullable = false)
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "role", nullable = false)
    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }

    @Column(name = "cpr", nullable = false)
    public String getCpr() {
        return cpr;
    }
    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    @Column(name = "birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column (name = "branch_id", nullable = false)
    public long getBranchId() {return branchId;}
    public void setBranchId (long branchId) {this.branchId = branchId;}
}