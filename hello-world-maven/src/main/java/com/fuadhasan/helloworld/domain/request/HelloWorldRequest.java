package com.fuadhasan.helloworld.domain.request;

import java.io.Serializable;

/**
 * @author Fuad Hasan
 * @since 19-Oct-2023
 */
public record HelloWorldRequest(String name) implements Serializable {
}
