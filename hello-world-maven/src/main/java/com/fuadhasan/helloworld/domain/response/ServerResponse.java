package com.fuadhasan.helloworld.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Fuad Hasan
 * @since 19-Oct-2023
 */
@Getter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ServerResponse<T> {

    private final int code;
    private final String message;
    private final T data;
}
