package crud.packages.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    private long id;
    private String FirstName;
    private String LastName;
    private String Email;
//    private String Password;
//    private String Street;
//    private String Postcode;
//    private String City;
//    private String Country;

    public User() {

    }

    public User(String FirstName, String LastName, String Email) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
//        this.Password = Password;
//        this.Street = Street;
//        this.Postcode = Postcode;
//        this.City = City;
//        this.Country = Country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
//
//    @Column(name = "email_address", nullable = false)
//    public String getEmail() {
//        return Email;
//    }
//    public void setEmail(String Email) {
//        this.Email = Email;
//    }
//
//    @Column(name = "password", nullable = false)
//    public String getPassword() { return Password; }
//    public void setPassword(String Password) {this.Password = Password;}
//
//    @Column(name = "street", nullable = false)
//    public String getStreet() { return Street; }
//    public void setStreet(String Street) {this.Street = Street;}
//
//    @Column(name = "postcode", nullable = false)
//    public String getPostcode() {
//        return Postcode;
//    }
//    public void setPostcode(String Postcode) {
//        this.Postcode = Postcode;
//    }
//
//    @Column(name = "city", nullable = false)
//    public String getCity() {
//        return City;
//    }
//    public void setCity(String city) {
//        this.City = city;
//    }
//
//    @Column(name = "country", nullable = false)
//    public String getCountry() {
//        return Country;
//    }
//    public void setCountry(String Country) {
//        this.Country = Country;
//    }
//


    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + FirstName + ", lastName=" + LastName + ", emailId=" + Email
                + "]";
    }
}
