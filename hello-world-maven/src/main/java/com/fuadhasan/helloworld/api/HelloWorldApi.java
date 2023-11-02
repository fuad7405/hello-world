package com.fuadhasan.helloworld.api;

import com.fuadhasan.helloworld.domain.request.HelloWorldRequest;
import com.fuadhasan.helloworld.domain.response.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Fuad Hasan
 * @since 18-Oct-2023
 */
@RequestMapping(path = "helloworld")
public interface HelloWorldApi {

    @Operation(summary = "Get hello world")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get hello world",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServerResponse.class))
                    })
    })
    @GetMapping
    ResponseEntity<ServerResponse<Object>> get();


    @PostMapping()
    ResponseEntity<ServerResponse<Object>> post(@RequestBody HelloWorldRequest request);
}
