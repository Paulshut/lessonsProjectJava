package org.sds.delivery.services.userService;

import org.sds.delivery.dto.requests.userRequest.CreateUserRequest;
import org.sds.delivery.dto.requests.userRequest.UpdateUserRequest;
import org.sds.delivery.dto.responses.userResponse.UserDeleteResponse;
import org.sds.delivery.dto.responses.userResponse.UserDto;
import org.sds.delivery.dto.responses.userResponse.UserUpdateResponse;

import java.util.List;

/**
 * Service for working with users.
 */
public interface UserService {
    /**
     * Retrieves a user by their identifier.
     *
     * @param userId the identifier of the user to retrieve
     * @return the UserDto representing the retrieved user
     */
    UserDto getUserById(Long userId);

    /**
     * Retrieves a user by their login username.
     *
     * @param userLogin the login of the user to retrieve
     * @return the UserDto representing the retrieved user
     */
    UserDto getUserByLogin(String userLogin);

    /**
     * Creates a new user based on the provided request.
     *
     * @param request the CreateUserRequest containing the user information for creation
     * @return the UserDto representing the created user
     */
    UserDto createUser(CreateUserRequest request);

    /**
     * Updates an existing user with the provided request data.
     *
     * @param userId  the identifier of the user to update
     * @param request the UpdateUserRequest containing the updated user information
     * @return the UserUpdateResponse indicating the success of the update operation
     */
    UserUpdateResponse updateUser(Long userId, UpdateUserRequest request);

    /**
     * Deletes a user with the specified unique identifier.
     *
     * @param userId the identifier of the user to delete
     * @return the UserDeleteResponse indicating the success of the delete operation
     */
    UserDeleteResponse deleteUser(Long userId);

    /**
     * Retrieves a list of all users.
     *
     * @return a List of UserDto objects representing all users in the system
     */
    List<UserDto> getAllUsers();
}