package com.mimi.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(value = "spring")
    void shouldAllowAccessToHomePage() throws Exception {
        String url = "/AmourChien93";
        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }


    @Test
    @WithMockUser(value = "spring")
    void shouldAllowAccessToConseilsPage() throws Exception {
        String url= "/page/conseils";
        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "spring")
    void shouldAllowAccessToCoursPage() throws Exception {
        String url= "/page/cours";
        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "spring")
    void shouldAllowAccessToBaladesPage() throws Exception {
        String url= "/page/balades";
        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "spring")
    void shouldAllowAccessToCoachingPage() throws Exception {
        String url= "/page/coaching";
        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }
}

