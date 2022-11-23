package com.mimi.service;

import com.mimi.config.Role;
import com.mimi.exception.UserNotFoundException;
import com.mimi.modele.User;
import com.mimi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;


    private User user;

    @BeforeEach
    public void setup() {
        user =User.builder()
                .userFirstName("Dorra")
                .userLastName("Explo")
                .email("dorra@gmail.com")
                .password("test123")
                .phone("01.64.02.96.32")
                .address("46 impasse des Lilas, 93160 Noisy le Grand")
                .role(Role.valueOf("USER"))
                .contact("vétérinaire")
                .build();
    }


    @DisplayName("Junit test SaveUser")
    @Test
    public void testSaveUser(){
        //given - pre condition
        given(userRepository.save(user))
                .willReturn(user);
        //when - behaviour to test
        User savedUser = userService.saveUser(user);
        //then - verify the ouput
        assertThat(savedUser).isNotNull();
    }

    @DisplayName("Junit UsersList")
    @Test
    public void testGetAllUsers(){
        //given - pre condition
        User user1 =User.builder()
                .userFirstName("Eric")
                .userLastName("Ploit")
                .email("eric@gmail.com")
                .password("test123")
                .phone("01.96.63.25.33")
                .address("6 allée des lions, 93160 Noisy le Grand")
                .role(Role.valueOf("USER"))
                .contact("google")
                .build();

        given(userRepository.findAll()).willReturn(List.of(user,user1));
        //when - behaviour to test
        List<User> usersList = userService.getAllUsers();
        //then - verify the ouput
        assertThat(usersList).isNotNull();
        assertThat(usersList.size()).isEqualTo(2);
    }





    @DisplayName("Junit test Delete User")
    @Test
    public void deleteUser() throws Exception {
        //given - pre condition
        Integer userId = 1;
        //when - behaviour to test
        Mockito.doNothing()
         .when(userRepository).deleteById(user.getUserId());
        try {
            userService.delete(userId);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        //then - verify the ouput
        Mockito.verify(userRepository, times(1)).deleteById(userId);
    }
}
