package com.fuadhasan.helloworld.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Fuad Hasan
 * @since 19-Oct-2023
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ServerResponse<T>(int code, String message, T data) {
}
