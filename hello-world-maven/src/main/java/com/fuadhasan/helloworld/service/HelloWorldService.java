package com.fuadhasan.helloworld.service;

import com.fuadhasan.helloworld.domain.request.HelloWorldRequest;
import com.fuadhasan.helloworld.domain.response.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Fuad Hasan
 * @since 18-Oct-2023
 */
@Slf4j
@Service
public class HelloWorldService extends BaseService {

    @Value("${spring.application.name}")
    private String appName;

    public ServerResponse<Object> get() {
        return getServerResponse();
    }

    public ServerResponse<Object> post(HelloWorldRequest request) {
        return getServerResponse(appName + " - " + request.getName());
    }
}
