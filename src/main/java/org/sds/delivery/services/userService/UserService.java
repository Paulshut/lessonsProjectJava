package org.sds.delivery.services.userService;

import org.sds.delivery.dto.requests.userRequest.CreateUserRequest;
import org.sds.delivery.dto.requests.userRequest.UpdateUserRequest;
import org.sds.delivery.dto.responses.userResponse.UserDeleteResponse;
import org.sds.delivery.dto.responses.userResponse.UserResponse;
import org.sds.delivery.dto.responses.userResponse.UserUpdateResponse;

import java.util.List;

public interface UserService {
    UserResponse getUserById(Long id);

    UserResponse getUserByLogin(String userLogin);

    UserResponse createUser(CreateUserRequest request);

    UserUpdateResponse updateUser(Long id, UpdateUserRequest request);

    UserDeleteResponse deleteUser(Long id);

    List<UserResponse> getAllUsers();
}