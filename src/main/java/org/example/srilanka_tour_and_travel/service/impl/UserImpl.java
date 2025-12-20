package org.example.srilanka_tour_and_travel.service.impl;

import org.example.srilanka_tour_and_travel.controller.dto.UserDTO;
import org.example.srilanka_tour_and_travel.controller.request.UserRequest;

import java.util.List;

public interface UserImpl {
    UserRequest addUser(UserRequest userRequest);
    void updateUser(Long id, UserRequest userRequest);
    void deleteUser(Long id);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
}
