package io.github.amayaframework.example;

import io.github.amayaframework.core.contexts.HttpRequest;
import io.github.amayaframework.core.contexts.HttpResponse;
import io.github.amayaframework.core.controllers.Endpoint;
import io.github.amayaframework.core.inject.Path;
import io.github.amayaframework.core.inject.Query;
import io.github.amayaframework.core.methods.Get;

import static io.github.amayaframework.core.contexts.Responses.badRequest;
import static io.github.amayaframework.core.contexts.Responses.ok;

@Endpoint
public class ExampleController {
    @Get("/hello/{count:int}")
    public HttpResponse get(HttpRequest request, @Path Integer count) {
        String helloWorld = "Hello, world!";
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            response.append(helloWorld).append('\n');
        }
        return ok(response);
    }

    @Get("/hello")
    public HttpResponse hello(HttpRequest request) {
        return ok("Hello, client! ^_^");
    }

    @Get
    public HttpResponse postmanToken(HttpRequest request) {
        StringBuilder answer = new StringBuilder();
        answer.append("Hello, Postman! Your token is ").
                append(request.getHeader("Postman-Token"));
        return ok(answer);
    }

    @Get("/calc")
    public HttpResponse query(HttpRequest request, @Query String a, @Query String b, @Query String op) {
        if (a == null || b == null || op == null) {
            return badRequest();
        }
        double res;
        try {
            res = new CalcData(a, b, op).calculate();
        } catch (Exception e) {
            return badRequest();
        }
        return ok("Answer is " + res);
    }
}
