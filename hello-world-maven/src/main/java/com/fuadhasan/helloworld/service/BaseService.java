package com.fuadhasan.helloworld.service;

import com.fuadhasan.helloworld.domain.response.ServerResponse;
import com.fuadhasan.helloworld.domain.response.ServerResponseCode;

/**
 * @author Fuad Hasan
 * @since 18-Oct-2023
 */
public abstract class BaseService {

    protected ServerResponse<Object> getServerResponse() {
        return ServerResponse.builder().code(ServerResponseCode.SUCCESS).message("Success").build();
    }

    protected ServerResponse<Object> getServerResponse(Object data) {
        return getServerResponse().toBuilder().data(data).build();
    }
}
