package org.sds.delivery.mappers.userMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sds.delivery.dto.requests.userRequest.CreateUserRequest;
import org.sds.delivery.dto.requests.userRequest.UpdateUserRequest;
import org.sds.delivery.dto.responses.userResponse.UserDeleteResponse;
import org.sds.delivery.dto.responses.userResponse.UserResponse;
import org.sds.delivery.dto.responses.userResponse.UserUpdateResponse;
import org.sds.delivery.entities.RoleUser;
import org.sds.delivery.entities.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roleUser", expression = "java(defaultRole())")
    User userDtoToUser(CreateUserRequest request);
    default RoleUser defaultRole() {
        return RoleUser.USER;
    }

    void updateUserFromRequest(UpdateUserRequest request, @MappingTarget User user);

    UserResponse userToUserDTO(User user);

    List<UserResponse> usersToUserDTOs(List<User> users);

    UserDeleteResponse userToUserDeleteResponse(Long userId);

    UserUpdateResponse userUpdateToUpdateResponse(Long userId);
}