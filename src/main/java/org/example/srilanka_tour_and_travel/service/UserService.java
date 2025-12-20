package org.example.srilanka_tour_and_travel.service;

import lombok.Data;
import org.example.srilanka_tour_and_travel.controller.dto.UserDTO;
import org.example.srilanka_tour_and_travel.controller.request.UserRequest;
import org.example.srilanka_tour_and_travel.entity.User;
import org.example.srilanka_tour_and_travel.exception.UserNotFoundException;
import org.example.srilanka_tour_and_travel.mapper.UserMapper;
import org.example.srilanka_tour_and_travel.repository.UserRepository;
import org.example.srilanka_tour_and_travel.service.impl.UserImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class UserService implements UserImpl {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserRequest addUser(UserRequest userRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(userRequest.getEmail());
        if(optionalUser.isPresent()){
            throw new UserNotFoundException("User already exists with email: "+userRequest.getEmail());
        }
        User user = userMapper.toEntity(userRequest);
        userRepository.save(user);
        return userRequest;
    }

    @Override
    public void updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).
                orElseThrow(()-> new UserNotFoundException("User not found with id: "+id));
        user.setFullName(userRequest.getFullName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhone(userRequest.getPhone());
        user.setRole(userRequest.getRole());
        user.setCountry(userRequest.getCountry());
        user.setDateJoined(userRequest.getDateJoined());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).
                orElseThrow(()-> new UserNotFoundException("User not found with id: "+id));
        userRepository.delete(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).
                orElseThrow(()-> new UserNotFoundException("User not found with id: "+id));
        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toDTO).toList();

    }
}
