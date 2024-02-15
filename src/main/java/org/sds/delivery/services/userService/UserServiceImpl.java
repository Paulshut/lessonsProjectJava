package org.sds.delivery.services.userService;

import lombok.RequiredArgsConstructor;
import org.sds.delivery.dto.requests.userRequest.CreateUserRequest;
import org.sds.delivery.dto.requests.userRequest.UpdateUserRequest;
import org.sds.delivery.dto.responses.userResponse.UserDeleteResponse;
import org.sds.delivery.dto.responses.userResponse.UserResponse;
import org.sds.delivery.dto.responses.userResponse.UserUpdateResponse;
import org.sds.delivery.entities.User;
import org.sds.delivery.exceptions.UserNotFoundException;
import org.sds.delivery.mappers.userMapper.UserMapper;
import org.sds.delivery.repositories.userRepository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {
        User getUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id.toString()));
        return userMapper.userToUserDTO(getUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserByLogin(String userLogin) {
        User user = userRepository.getUserByLogin(userLogin)
                .orElseThrow(() -> new UserNotFoundException(userLogin));
        return userMapper.userToUserDTO(user);
    }

    @Override
    @Transactional
    public UserResponse createUser(CreateUserRequest request) {
        User user = userMapper.userDtoToUser(request);
        User saveUser = userRepository.save(user);
        return userMapper.userToUserDTO(saveUser);
    }

    @Override
    @Transactional
    public UserUpdateResponse updateUser(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id.toString()));
        userMapper.updateUserFromRequest(request, user);
        userRepository.save(user);
        return userMapper.userUpdateToUpdateResponse(id);
    }

    @Override
    @Transactional
    public UserDeleteResponse deleteUser(Long id) {
        User foundUser = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(id.toString()));
        userRepository.delete(foundUser);
        return userMapper.userToUserDeleteResponse(id);

    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.usersToUserDTOs(users);
    }
}