
package com.mimi.service;

import com.mimi.config.Role;
import com.mimi.controller.UserController;
import com.mimi.exception.UserNotFoundException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.mimi.modele.User;
import com.mimi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    private User user;

    @BeforeEach
  public void setup() {
  mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

//     userRepository= Mockito.mock(UserRepository.class);
//        userService = new UserService(userRepository);
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

    @DisplayName("Should return UsersList")
    @Test
    void testfonctionUserList() throws Exception {
        //given - pre condition
        User user2 = User.builder()
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

        User user3 = User.builder()
                .userId(3)
                .userFirstName("Dorra")
                .userLastName("Explo")
                .email("dorra@gmail.com")
                .password("test123")
                .phone("01.64.02.96.32")
                .address("46 impasse des Lilas, 93160 Noisy le Grand")
                .role(Role.valueOf("USER"))
                .contact("vétérinaire")
                .build();
        given(userRepository.findAll()).willReturn(List.of(user2,user3));
        ModelMap titleName = new ModelMap();
        //when - behaviour to test
        List<User> listUsers = userRepository.findAll();
        ResultActions response = mockMvc.perform(get("/admin/gestionUser"));
        //then - verify the ouput
        assertThat(listUsers).isNotNull();
        assertThat(listUsers).hasSizeGreaterThan(0);
        assertThat(listUsers.size()).isEqualTo(2);
        assertThat(titleName).isNotNull();
        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

/*    @DisplayName("Should return a user by his ID")
    @Test
    public void testGetUser() throws UserNotFoundException {
        //given - pre condition
        given(userRepository.findById(1)).willReturn(Optional.of(user));

        //when - behaviour to test
        //User savedUser = userService.get(user.getUserId()).getUserId();
        //then - verify the ouput
        assertThat(savedUser).isNotNull();

    }*/

}
/*

    @DisplayName(" Should return UserForm")
    @Test
    void testFonctionUserForm() throws Exception {
        User user = new User();
        String formTitle = "Ajout";

        mockMvc
                .perform(MockMvcRequestBuilders.post("/admin/userForm)"))
                .andExpect(MockMvcResultMatchers.model().attribute("formTitle", formTitle));
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

 }*/



    /*     @DisplayName("Test add a new user")
     @Test
     public void testFonctionSaveUser () {
         //je veux ajouter un utilisateur
         //Given les infos de l'utilisateur
         //When j'enregistre l'utilisateur
         //then mon utilisateur est ajouté
         //given - pre condition
         given(userRepoMock.save(user))
                 .willReturn(user);
         //when - behaviour to test
         User savedUser = userImpl.saveUser(user);
         //then - verify the ouput
         assertThat(savedUser).isNotNull();
     }*/
     /*
@DisplayName(" Should return UserForm")
    @Test
    void testFonctionUserForm() throws Exception {

        String formTitle = "Ajoutd'un nouvel utilisateur";
        mockMvc
                .perform(MockMvcRequestBuilders.get("/admin/userForm)"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("formTitle"));

    }

*/
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

