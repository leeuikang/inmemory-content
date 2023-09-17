package com.inmemory.content.interfaces.rest.controller;

import com.inmemory.content.interfaces.rest.constants.ContentApiUrl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HealthCheckController.class)
class HealthCheckControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("HealthCheck API 요청에 성공한다.")
    void HealthCheck_API_call_success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(ContentApiUrl.CONTENT_HEALTH_CHECK_BASE_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("health checked"))
        ;
    }
}