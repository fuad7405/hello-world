package com.fuadhasan.helloworld.domain.request;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

/**
 * @author Fuad Hasan
 * @since 19-Oct-2023
 */
@Getter
@Jacksonized
@Builder(toBuilder = true)
public class HelloWorldRequest implements Serializable {

    private final String name;
}
