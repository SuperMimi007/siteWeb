package com.mimi.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

 @Test
 @WithMockUser(value = "spring")
   public void getHomePage() throws Exception {
            String url= "/AmourChien93";
            mockMvc.perform(get(url))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "spring")
    public void getPrestPage() throws Exception {
        String url= "/page/propos";
        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "spring")
    public void getPrestCons() throws Exception {
        String url= "/page/conseils";
        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }
}
