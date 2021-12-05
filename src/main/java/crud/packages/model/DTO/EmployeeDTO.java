package crud.packages.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import crud.packages.model.Entities.Ticket;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

public class EmployeeDTO {



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




    public EmployeeDTO() {
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }


    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }


    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }


    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }


    public String getCpr() {
        return cpr;
    }
    public void setCpr(String cpr) {
        this.cpr = cpr;
    }


    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getBranchId() {
        return branchId;
    }
    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }
}
