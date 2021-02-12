package com.example.lab3;

import com.example.lab3.AddressBookController;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class TestingWebApplicationTests {

    @Autowired
    private AddressBookController controller;

    @Test
    public void contextLoads() {
        System.out.println("before");
        assertThat(controller).isNotNull();
        System.out.println("after");
    }

}
