package org.sds.delivery.services.userService;

import lombok.RequiredArgsConstructor;
import org.sds.delivery.dto.requests.userRequest.CreateUserRequest;
import org.sds.delivery.dto.requests.userRequest.UpdateUserRequest;
import org.sds.delivery.dto.responses.userResponse.UserDeleteResponse;
import org.sds.delivery.dto.responses.userResponse.UserDto;
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
    public UserDto getUserById(Long userId) {
        User getUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId.toString()));
        return userMapper.mapUserToUserDTO(getUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserByLogin(String userLogin) {
        User user = userRepository.getUserByLogin(userLogin)
                .orElseThrow(() -> new UserNotFoundException(userLogin));
        return userMapper.mapUserToUserDTO(user);
    }

    @Override
    @Transactional
    public UserDto createUser(CreateUserRequest request) {
        User user = userMapper.mapUserDtoToUser(request);
        User saveUser = userRepository.save(user);
        return userMapper.mapUserToUserDTO(saveUser);
    }

    @Override
    @Transactional
    public UserUpdateResponse updateUser(Long userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId.toString()));
        userMapper.mapUpdateUserFromRequest(request, user);
        return userMapper.mapUserUpdateToUpdateResponse(userId);
    }

    @Override
    @Transactional
    public UserDeleteResponse deleteUser(Long userId) {
        User foundUser = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId.toString()));
        userRepository.delete(foundUser);
        return userMapper.mapUserToUserDeleteResponse(userId);

    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.mapUsersToUserDTOs(users);
    }
}