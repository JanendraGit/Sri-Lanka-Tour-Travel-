package org.example.srilanka_tour_and_travel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.srilanka_tour_and_travel.dto.UserDTO;
import org.example.srilanka_tour_and_travel.dto.request.UserRequest;
import org.example.srilanka_tour_and_travel.entity.User;
import org.example.srilanka_tour_and_travel.exception.UserNotFoundException;
import org.example.srilanka_tour_and_travel.mapper.UserMapper;
import org.example.srilanka_tour_and_travel.repository.UserRepository;
import org.example.srilanka_tour_and_travel.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserRequest addUser(UserRequest userRequest) {
        log.info("Creating a new user: {}", userRequest.getEmail());
        Optional<User> optionalUser = userRepository.findByEmail(userRequest.getEmail());
        if(optionalUser.isPresent()){
            throw new RuntimeException("User already exists with email: "+userRequest.getEmail());
        }
        User user = userMapper.toEntity(userRequest);
        userRepository.save(user);
        log.info("User created successfully with id: {}", user.getUserId());
        return userRequest;
    }

    @Override
    public void updateUser(Long id, UserRequest userRequest) {
        log.info("Updating user with id: {}", id);
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
        log.info("User updated successfully with id: {}", user.getUserId());
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Deleting user with id: {}", id);
        User user = userRepository.findById(id).
                orElseThrow(()-> new UserNotFoundException("User not found with id: "+id));
        userRepository.delete(user);
        log.info("User deleted successfully with id: {}", id);
    }

    @Override
    public UserDTO getUserById(Long id) {
        log.info("Fetching user by id: {}", id);
        User user = userRepository.findById(id).
                orElseThrow(()-> new UserNotFoundException("User not found with id: "+id));
        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("Fetching all users");
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toDTO).toList();

    }
}
