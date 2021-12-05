package crud.packages.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import crud.packages.model.DTO.UserDTO;

import crud.packages.model.Login;
import crud.packages.repository.UserRepository;
import crud.packages.model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.packages.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = new ArrayList<>();
		for (User user : userRepository.findAll()) {
			user.setPassword("");
			users.add(user);
		}
		return ResponseEntity.ok().body(users);

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		user.setPassword("");
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/user/register")
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		userRepository.save(user);
		user.setPassword("");
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/user/login")
	public ResponseEntity<User> loginUser(@Valid @RequestBody Login loginDetails) throws ResourceNotFoundException {
		User user = userRepository.getUserByEmail(loginDetails.getEmail()); {
			if (user != null) {
				if (loginDetails.getPassword().equals(user.getPassword())) {
					user.setPassword("");
					return ResponseEntity.ok().body(user);
				}
				throw new ResourceNotFoundException("Incorrect credentails ");
			}
			throw new ResourceNotFoundException("User not found for this email :: " + loginDetails.getEmail());
		}

	}

	@PutMapping("/user/edit/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		user.setEmail(userDetails.getEmail());
		user.setLastName(userDetails.getLastName());
		user.setFirstName(userDetails.getFirstName());
		user.setPassword(userDetails.getPassword());
		final User updatedUser = userRepository.save(user);
		updatedUser.setPassword("");
		return ResponseEntity.ok().body(updatedUser);
	}

	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		userRepository.delete(user);
		return ResponseEntity.ok().body(true);
	}
}
