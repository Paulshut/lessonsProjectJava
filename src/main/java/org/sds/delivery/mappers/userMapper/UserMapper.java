package org.sds.delivery.mappers.userMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sds.delivery.dto.requests.userRequest.CreateUserRequest;
import org.sds.delivery.dto.requests.userRequest.UpdateUserRequest;
import org.sds.delivery.dto.responses.userResponse.UserDeleteResponse;
import org.sds.delivery.dto.responses.userResponse.UserDto;
import org.sds.delivery.dto.responses.userResponse.UserUpdateResponse;
import org.sds.delivery.entities.User;
import org.sds.delivery.enums.RoleUser;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roleUser", expression = "java(defaultRole())")
    User mapUserDtoToUser(CreateUserRequest request);

    void mapUpdateUserFromRequest(UpdateUserRequest request, @MappingTarget User user);

    UserDto mapUserToUserDTO(User user);

    List<UserDto> mapUsersToUserDTOs(List<User> users);

    UserDeleteResponse mapUserToUserDeleteResponse(Long userId);

    UserUpdateResponse mapUserUpdateToUpdateResponse(Long userId);

    default RoleUser defaultRole() {
        return RoleUser.USER;
    }
}