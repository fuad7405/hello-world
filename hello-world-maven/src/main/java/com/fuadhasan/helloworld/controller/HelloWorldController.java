package com.fuadhasan.helloworld.controller;

import com.fuadhasan.helloworld.api.HelloWorldApi;
import com.fuadhasan.helloworld.domain.request.HelloWorldRequest;
import com.fuadhasan.helloworld.domain.response.ServerResponse;
import com.fuadhasan.helloworld.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Fuad Hasan
 * @since 27-Jul-2022
 */
@RestController
@RequiredArgsConstructor
public class HelloWorldController implements HelloWorldApi {

    private final HelloWorldService helloWorldService;

    public ResponseEntity<ServerResponse<Object>> get() {
        return ResponseEntity.ok(helloWorldService.get());
    }

    public ResponseEntity<ServerResponse<Object>> post(HelloWorldRequest request) {
        return ResponseEntity.ok(helloWorldService.post(request));
    }
}
