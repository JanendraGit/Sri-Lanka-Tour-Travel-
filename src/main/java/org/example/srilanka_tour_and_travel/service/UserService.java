package org.example.srilanka_tour_and_travel.service;

import org.example.srilanka_tour_and_travel.dto.UserDTO;
import org.example.srilanka_tour_and_travel.dto.request.UserRequest;

import java.util.List;

public interface UserService {
    UserRequest addUser(UserRequest userRequest);
    void updateUser(Long id, UserRequest userRequest);
    void deleteUser(Long id);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
}
