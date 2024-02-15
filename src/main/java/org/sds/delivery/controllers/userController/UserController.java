package org.sds.delivery.controllers.userController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sds.delivery.dto.requests.userRequest.CreateUserRequest;
import org.sds.delivery.dto.requests.userRequest.UpdateUserRequest;
import org.sds.delivery.dto.responses.userResponse.UserDeleteResponse;
import org.sds.delivery.dto.responses.userResponse.UserResponse;
import org.sds.delivery.dto.responses.userResponse.UserUpdateResponse;
import org.sds.delivery.services.userService.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/user")
@Validated
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getUserLogin/{userLogin}")
    @ResponseStatus(OK)
    public @ResponseBody UserResponse getUserByLogin(@PathVariable String userLogin){
        return userService.getUserByLogin(userLogin);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public @ResponseBody UserResponse createUser(@RequestBody @Valid CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(OK)
    public @ResponseBody UserUpdateResponse updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public @ResponseBody UserDeleteResponse deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("getUsers")
    @ResponseStatus(OK)
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
}