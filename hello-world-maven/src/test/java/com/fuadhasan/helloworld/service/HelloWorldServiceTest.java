package com.fuadhasan.helloworld.service;

import com.fuadhasan.helloworld.domain.request.HelloWorldRequest;
import com.fuadhasan.helloworld.domain.response.ServerResponse;
import com.fuadhasan.helloworld.domain.response.ServerResponseCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

/**
 * @author Fuad Hasan
 * @since 02-Nov-2022
 */
@ExtendWith(MockitoExtension.class)
class HelloWorldServiceTest {

    @InjectMocks
    private HelloWorldService service;

    @BeforeEach
    public void setUp() {
        service = new HelloWorldService();
        ReflectionTestUtils.setField(service, "appName", "Hello World");
    }

    @Test
    void testGet() {

        // When
        ServerResponse<Object> actualGetResult = this.service.get();

        // Assert
        assertEquals(ServerResponseCode.SUCCESS, actualGetResult.getCode());
        assertNull(actualGetResult.getData());
        assertEquals("Success", actualGetResult.getMessage());
    }

    @Test
    void testPost() {

        // Given
        HelloWorldRequest helloWorldRequest = mock(HelloWorldRequest.class);

        // When
        when(helloWorldRequest.getName()).thenReturn("Name");

        ServerResponse<Object> actualPostResult = this.service.post(helloWorldRequest);

        // Assert
        assertEquals(ServerResponseCode.SUCCESS, actualPostResult.getCode());
        assertEquals("Hello World - Name", actualPostResult.getData());
        assertEquals("Success", actualPostResult.getMessage());

        verify(helloWorldRequest).getName();
    }
}
