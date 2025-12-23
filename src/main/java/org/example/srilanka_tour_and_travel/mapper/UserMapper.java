package org.example.srilanka_tour_and_travel.mapper;

import org.example.srilanka_tour_and_travel.dto.UserDTO;
import org.example.srilanka_tour_and_travel.dto.request.UserRequest;
import org.example.srilanka_tour_and_travel.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserRequest request){
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setRole(request.getRole());
        user.setCountry(request.getCountry());
        user.setDateJoined(request.getDateJoined());
        return user;
    }

    public UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setFullName(user.getFullName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setRole(user.getRole());
        userDTO.setCountry(user.getCountry());
        userDTO.setDateJoined(user.getDateJoined());
        return userDTO;
    }
}
