package crud.packages.model.Done;

import javax.persistence.*;


//TODO create method to retrieve halls and employees and to cascade delete hall

//TODO for all classes :: decide which fields are nullable

@Entity
@Table(name = "branches")
public class Branch {

    private long id;
    private String street;
    private String city;
    private String postcode;
    private String country;


    public Branch() {
    }

    public Branch(long id, String street, String city, String postcode, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column (name = "street")
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    @Column (name = "city")
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Column (name = "postcode")
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Column (name = "country")
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

}