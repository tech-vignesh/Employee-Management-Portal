package com.deloitte.portal.model;

import java.util.List;

import com.deloitte.ms.exception.UserAlreadyExistsException;
import com.deloitte.ms.exception.UserNotFoundException;
import com.deloitte.ms.exception.UserServiceException;
import com.deloitte.ms.model.User;
import com.deloitte.ms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            ResponseEntity<String> response = userService.createUser(user);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (UserServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            ResponseEntity<List<User>> response = userService.getAllUsers();
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (UserServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        try {
            ResponseEntity<User> response = userService.getUserById(id);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (UserServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody User user) {
        try {
            ResponseEntity<String> response = userService.updateUser(id, user);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (UserServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        try {
            ResponseEntity<Boolean> response = userService.deleteUser(id);
            Boolean result = response.getBody();
            if (result == null || !result) {
                return ResponseEntity.badRequest().body("User not deleted");
            }
            return ResponseEntity.status(response.getStatusCode()).body("User deleted");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (UserServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/users/policy")
    public ResponseEntity<?> addPolicyToUser(@RequestParam("userId") String userId,
                                             @RequestParam("policyId") String policyId) {
        try {
            ResponseEntity<?> response = userService.addPolicyToUser(userId, policyId);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (UserNotFoundException | UserServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
