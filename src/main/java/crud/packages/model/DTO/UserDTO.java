package crud.packages.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import crud.packages.model.Entities.Ticket;

import javax.persistence.*;
import java.util.Set;

public class UserDTO {

	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public UserDTO() {
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

}
