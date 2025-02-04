package ru.costumes.rental.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.costumes.rental.model.User;
import ru.costumes.rental.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private UserService userService;

    @PostMapping("/sign_in")
    public ResponseEntity<User> signIn(@RequestBody SignInRequest request) {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userService.signIn(request.getEmail(), request.getPassword()));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/register_me")
    public ResponseEntity<User> registerMe(@RequestBody User user) {
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(userService.registerMe(user));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/update_me")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(userService.updateMe(user));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Data
    public static class SignInRequest {
        private String email;
        private String password;
    }
}
