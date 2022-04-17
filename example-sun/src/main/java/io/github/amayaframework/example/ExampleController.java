package io.github.amayaframework.example;

import io.github.amayaframework.core.contexts.HttpRequest;
import io.github.amayaframework.core.contexts.HttpResponse;
import io.github.amayaframework.core.contexts.Responses;
import io.github.amayaframework.core.controllers.Endpoint;
import io.github.amayaframework.core.controllers.HttpController;
import io.github.amayaframework.core.methods.Get;
import io.github.amayaframework.core.wrapping.Path;

@Endpoint
public class ExampleController extends HttpController {
    @Get("/hello/{count:int}")
    public HttpResponse get(HttpRequest request, @Path Integer count) {
        String helloWorld = "Hello, world!";
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            response.append(helloWorld).append('\n');
        }
        return Responses.ok(response);
    }

    @Get
    public HttpResponse postmanToken(HttpRequest request) {
        StringBuilder answer = new StringBuilder();
        answer.append("Hello, Postman! Your token is ").
                append(request.getHeader("Postman-Token"));
        return Responses.ok(answer);
    }
}
