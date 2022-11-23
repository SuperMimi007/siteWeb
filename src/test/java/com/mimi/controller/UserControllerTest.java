package com.mimi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mimi.config.LoginUserDetails;
import com.mimi.config.LoginUserDetailsService;
import com.mimi.config.Role;
import com.mimi.modele.User;
import com.mimi.repository.UserRepository;
import com.mimi.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class)
@WithMockUser(value = "spring")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;




  /*@Test
    public void testGestionUser() throws Exception {
        List<User> userList = new ArrayList<>();
            userList.add(new User(1, "Roulio", "Argi", "roulio@gmail.com", "Roulio", "01.62.53.95.96", "17 rue des prés 93160 Noisy le grand", "google", Role.ADMIN));
            userList.add(new User(2, "Elodie", "Argi", "elodie@gmail.com", "Elodie", "01.45.53.27.96", "17 rue des prés 93160 Noisy le grand", "google", Role.USER));
            Mockito.when(userService.getAllUsers()).thenReturn(userList);
            String url= "/admin/gestionUser";
            mockMvc.perform(get(url))
            .andExpect(status().isOk());
    }*/

   /* @Test
    public void testSaveUser() throws Exception {
        String url = "/admin/gestionUser";
        User savedUser = new User(1, "Roulio", "Argi", "roulio@gmail.com", "Roulio", "01.62.53.95.96", "17 rue des prés 93160 Noisy le grand", "google", Role.USER);
        Mockito.when(userService.fonctionSaveUser(savedUser, "/admin/gestionUser"));

        String url = "/admin/gestionUser";
        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }*/

   @Test
        public void testNewUser() throws Exception {
        this.mockMvc
            .perform(post("/admin/gestionUser/save")
                .param("email","richard@gmail.com")
                .param("userFirstName","Richard")
                .param("userLastName","gere")
                .param("password","Test123")
                .param("address","3allée des souches 93160 Noisy")
                .param("phone","01.62.36.65.63")
                .param("contact","vétérinaire")
                .param("Role", String.valueOf(Role.USER))
                .with(csrf()))
        .andExpect(status().is3xxRedirection())
        .andExpect(header().string("Location","/admin/gestionUser/new"));
    }

}