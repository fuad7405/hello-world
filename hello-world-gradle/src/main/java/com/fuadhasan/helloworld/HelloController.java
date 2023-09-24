package com.fuadhasan.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fuad Hasan
 * @since 27-Jul-2022
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }
}
