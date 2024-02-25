package org.sds.delivery.controllers.userController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sds.delivery.dto.requests.userRequest.CreateUserRequest;
import org.sds.delivery.dto.requests.userRequest.UpdateUserRequest;
import org.sds.delivery.dto.responses.userResponse.UserDeleteResponse;
import org.sds.delivery.dto.responses.userResponse.UserDto;
import org.sds.delivery.dto.responses.userResponse.UserUpdateResponse;
import org.sds.delivery.services.userService.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("login/{userLogin}")
    public UserDto getUserByLogin(@PathVariable String userLogin) {
        return userService.getUserByLogin(userLogin);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public UserDto createUser(@Valid @RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PatchMapping("{userId}")
    public UserUpdateResponse updateUser(@PathVariable Long userId, @Valid @RequestBody UpdateUserRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("{userId}")
    public UserDeleteResponse deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping("users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}