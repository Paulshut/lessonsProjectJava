package org.sds.delivery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sds.delivery.dto.requests.userRequest.CreateUserRequest;
import org.sds.delivery.dto.responses.userResponse.UserDto;
import org.sds.delivery.entities.User;
import org.sds.delivery.exceptions.UserNotFoundException;
import org.sds.delivery.mappers.userMapper.UserMapper;
import org.sds.delivery.mappers.userMapper.UserMapperImpl;
import org.sds.delivery.repositories.userRepository.UserRepository;
import org.sds.delivery.services.userService.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.sds.delivery.enums.RoleUser.USER;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Spy
    private UserMapper userMapper = new UserMapperImpl();

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testGetUserByIdWhenUserExist() {
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.of(getUserMock()));
        UserDto gettingResponse = userService.getUserById(userId);
        assertEquals(getExpectedUser(), gettingResponse);
    }

    @Test
    public void testGetUserByIdWhenUserNoExist() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> userService.getUserById(1L));
    }

    @Test
    public void repoCall() {
        Long userId = 1L;
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(getUserMock()));
        userService.getUserById(1L);
        Mockito.verify(userRepository).findById(1L);
    }

    @Test
    public void testGetAllUsers() {
        User userMock1 = getUserMock();
        List<User> users = List.of(userMock1);
        when(userRepository.findAll()).thenReturn(users);
        List<UserDto> allUsers = userService.getAllUsers();
        assertEquals(List.of(getExpectedUser()), allUsers);
    }

    @Test
    public void testCreateUser() {
        User mockUser = User.builder()
                .login("test")
                .password("test")
                .name("Ivan")
                .surname("Ivanov")
                .contactPhone("123")
                .email("test@test.by")
                .roleUser(USER)
                .build();

        UserDto expectedUser = getExpectedUser();

        CreateUserRequest request = CreateUserRequest.builder()
                .name("Ivan")
                .surname("Ivanov")
                .login("test")
                .password("test")
                .contactPhone("123")
                .email("test@test.by")
                .build();
        when(userRepository.save(mockUser)).thenReturn(mockUser);
        UserDto resultUser = userService.createUser(request);
        resultUser.setId(1L);
        verify(userRepository).save(mockUser);
        assertEquals(expectedUser, resultUser);
    }

    private User getUserMock() {
        return User.builder()
                .id(1L)
                .login("test")
                .password("test")
                .name("Ivan")
                .surname("Ivanov")
                .email("test@test.by")
                .contactPhone("123")
                .build();
    }

    private UserDto getExpectedUser() {
        return UserDto.builder()
                .id(1L)
                .login("test")
                .surname("Ivanov")
                .name("Ivan")
                .email("test@test.by")
                .contactPhone("123")
                .build();
    }

}