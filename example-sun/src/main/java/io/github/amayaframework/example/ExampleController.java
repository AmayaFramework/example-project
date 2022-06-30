package io.github.amayaframework.example;

import io.github.amayaframework.core.contexts.HttpRequest;
import io.github.amayaframework.core.contexts.HttpResponse;
import io.github.amayaframework.core.contexts.Responses;
import io.github.amayaframework.core.controllers.Endpoint;
import io.github.amayaframework.core.inject.Header;
import io.github.amayaframework.core.inject.Path;
import io.github.amayaframework.core.methods.Get;
import io.github.amayaframework.core.methods.Post;

import java.math.BigInteger;

import static io.github.amayaframework.core.contexts.Responses.ok;

@Endpoint
public class ExampleController {
    @Get("/hello/{count:int}")
    public HttpResponse get(@Path Integer count) {
        String helloWorld = "Hello, world!";
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            response.append(helloWorld).append('\n');
        }
        return ok(response);
    }

    @Get("/hello")
    public HttpResponse hello() {
        return ok("Hi from Amaya!");
    }

    @Get
    public HttpResponse postmanToken(@Header("Postman-Token") String token) {
        return ok("Hello, Postman! Your token is " + token);
    }

    @Post
    public HttpResponse post(HttpRequest request) {
        System.out.println(request.getContentType());
        System.out.println(request.getBody());
        return ok();
    }
}
