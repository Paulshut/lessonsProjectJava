package org.sds.delivery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sds.delivery.dto.responses.userResponse.UserResponse;
import org.sds.delivery.entities.User;
import org.sds.delivery.mappers.userMapper.UserMapper;
import org.sds.delivery.repositories.userRepository.UserRepository;
import org.sds.delivery.services.userService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserMapper userMapper;
    @Autowired
    private UserServiceImpl userService;


    @Test
    public void testGetUserByIdEquals() {
        Long userId = 1L;
        User userTest = new User().builder()
                .id(userId)
                .login("122")
                .password("test")
                .name("Ivan")
                .surname("Ivanov")
                .email("test@test.by")
                .contactPhone("123")
                .build();

        UserResponse userResponseTest = new UserResponse().builder()
                .login("123")
                .surname("Ivanov")
                .name("Ivan")
                .email("test@test.ru")
                .contactPhone("123")
                .build();

        when(userRepository.findById(userId)).thenReturn(Optional.of(userTest));
        when(userMapper.userToUserDTO(userTest)).thenReturn(userResponseTest);
        UserResponse gettingResponse = userService.getUserById(1L);
        assertEquals(gettingResponse, userResponseTest);
    }
}