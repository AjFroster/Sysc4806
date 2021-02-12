package com.example.lab3;

import com.example.lab3.AddressBookController;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AddressBookController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
