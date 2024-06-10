package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Entity.User;
import Service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        if (!"France".equalsIgnoreCase(user.getCountry())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User must reside in France.");
        }
        User createdUser = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id, @RequestParam(defaultValue = "true") boolean detailed) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.ok(user);
    }
}
