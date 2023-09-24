package com.fuadhasan.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Fuad Hasan
 * @since 27-Jul-2022
 */
@SpringBootTest(classes = HelloWorldApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldApplicationTests {

    @Autowired
    private TestRestTemplate template;

    @Test
    void helloWorldTest() {
        String actual = "Hello World!";
        ResponseEntity<String> response = template.getForEntity("/", String.class);
        String expected = response.getBody();
        assertEquals(expected, actual);
    }
}
