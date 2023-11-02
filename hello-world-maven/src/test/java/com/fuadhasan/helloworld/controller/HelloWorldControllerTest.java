package com.fuadhasan.helloworld.controller;

import com.fuadhasan.helloworld.domain.request.HelloWorldRequest;
import com.fuadhasan.helloworld.domain.response.ServerResponse;
import com.fuadhasan.helloworld.service.HelloWorldService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Fuad Hasan
 * @since 02-Nov-2022
 */
@ContextConfiguration(classes = {HelloWorldController.class})
@ExtendWith(MockitoExtension.class)
class HelloWorldControllerTest {

    @Mock
    private HelloWorldService service;

    @InjectMocks
    private HelloWorldController controller;

    @BeforeEach
    public void setUp() {
        controller = new HelloWorldController(service);
    }

    @Test
    void testGet() {
        // Arrange
        when(this.service.get()).thenReturn(mock(ServerResponse.class));

        // ACT
        ResponseEntity<ServerResponse<Object>> actualResult = this.controller.get();

        // Assert
        assertNotNull(actualResult);
        assertTrue(actualResult.hasBody());
        assertEquals(HttpStatus.OK, actualResult.getStatusCode());
        assertTrue(actualResult.getHeaders().isEmpty());

        verify(this.service).get();
    }

    @Test
    void testPost() {
        // Arrange
        when(this.service.post(any(HelloWorldRequest.class))).thenReturn(mock(ServerResponse.class));

        HelloWorldRequest helloWorldRequest = HelloWorldRequest.builder().name("Name").build();

        // ACT
        ResponseEntity<ServerResponse<Object>> actualResult = this.controller.post(helloWorldRequest);

        // Assert
        assertNotNull(actualResult);
        assertTrue(actualResult.hasBody());
        assertEquals(HttpStatus.OK, actualResult.getStatusCode());
        assertTrue(actualResult.getHeaders().isEmpty());

        verify(this.service).post(any(HelloWorldRequest.class));
    }
}
