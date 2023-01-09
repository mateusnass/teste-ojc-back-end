package com.example.teste.controller;



import com.example.teste.dtos.UserDto;
import com.example.teste.entity.User;
import com.example.teste.repository.UserRepository;
import com.example.teste.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> listar(){
        return userRepository.findAll();
    }
    @PostMapping
        public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto){
        var user = new User();
         BeanUtils.copyProperties(userDto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }


}
