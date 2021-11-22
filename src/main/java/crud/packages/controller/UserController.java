package crud.packages.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import crud.packages.repository.UserRepository;
import crud.packages.model.User;
import org.apache.coyote.Response;
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
import crud.packages.model.User;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/users/register")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@PostMapping("/users/login")
	public ResponseEntity<User> loginUser(@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepository.getUserByEmail(userDetails.getEmail()); {
			if (user != null) {
				if (userDetails.getPassword().equals(user.getPassword())) {
					return ResponseEntity.ok(user);
				}
				throw new ResourceNotFoundException("Incorrect credentails ");
			}
			throw new ResourceNotFoundException("User not found for this email :: " + userDetails.getEmail());
		}

	}

	@PutMapping("/users/edit/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		user.setEmail(userDetails.getEmail());
		user.setLastName(userDetails.getLastName());
		user.setFirstName(userDetails.getFirstName());
		user.setPassword(userDetails.getPassword());
		user.setStreet(userDetails.getStreet());
		user.setPostcode(userDetails.getPostcode());
		user.setCountry(userDetails.getCountry());
		user.setSettlement(userDetails.getSettlement());
		final User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/users/delete/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
