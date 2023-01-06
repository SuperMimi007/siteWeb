
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.query.Param;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepoMock;
    @InjectMocks
    private UserService userImpl;


    private User user;
    private Model model;

    @BeforeEach
    public void setup() {
        user = User.builder()
                .userId(1)
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
    public void testSaveUser() {
        //given - pre condition
        given(userRepoMock.save(user))
                .willReturn(user);
        //when - behaviour to test
        User savedUser = userImpl.saveUser(user);
        //then - verify the ouput
        assertThat(savedUser).isNotNull();
    }

    @DisplayName("Junit UsersList")
    @Test
    public void testGetAllUsers() {
        //given - pre condition
        User user1 = User.builder()
                .userId(2)
                .userFirstName("Eric")
                .userLastName("Ploit")
                .email("eric@gmail.com")
                .password("test123")
                .phone("01.96.63.25.33")
                .address("6 allée des lions, 93160 Noisy le Grand")
                .role(Role.valueOf("USER"))
                .contact("google")
                .build();

        given(userRepoMock.findAll()).willReturn(List.of(user, user1));
        //when - behaviour to test
        List<User> usersList = userImpl.getAllUsers();
        System.out.println(usersList);
        //then - verify the ouput
        assertThat(usersList).isNotNull();
        assertThat(usersList.size()).isEqualTo(2);
    }

}

/*
        Mockito.doNothing()
                .when(userRepoMock).deleteById(user.getUserId());
        try {
        userImpl.delete(userId);
    } catch (UserNotFoundException e) {
        e.printStackTrace();
    }
    //then - verify the ouput
        Mockito.verify(userRepoMock, times(1)).deleteById(userId);
}
}@DisplayName("Junit test Delete User")
    @Test
    public void deleteUser() throws Exception {
        //given - pre condition
        Integer userId = 2;
        //when - behaviour to test

*/

