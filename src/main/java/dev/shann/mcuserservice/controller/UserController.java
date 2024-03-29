package dev.shann.mcuserservice.controller;

import dev.shann.mcuserservice.dto.AuthenticateUserDTO;
import dev.shann.mcuserservice.dto.CreateUserDTO;
import dev.shann.mcuserservice.model.User;
import dev.shann.mcuserservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Boolean> authenticate(@RequestBody AuthenticateUserDTO authenticateUserDTO){
        var userFound = userService.authenticate(authenticateUserDTO) != null;
        return new ResponseEntity<>(userFound,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO createUserDTO){
        var user = userService.createUser(createUserDTO);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
}
