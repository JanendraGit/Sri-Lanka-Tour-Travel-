package org.example.srilanka_tour_and_travel.controller;

import lombok.Data;
import org.example.srilanka_tour_and_travel.controller.dto.UserDTO;
import org.example.srilanka_tour_and_travel.controller.request.UserRequest;
import org.example.srilanka_tour_and_travel.mapper.UserMapper;
import org.example.srilanka_tour_and_travel.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserRequest> addUser(@RequestBody UserRequest userRequest){
        UserRequest user = userService.addUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest){
        userService.updateUser(id, userRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO userDTO = userService.getUserById(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userDTOS = userService.getAllUsers();
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

}
