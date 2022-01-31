package io.github.amayaframework.example;

import io.github.amayaframework.core.contexts.HttpRequest;
import io.github.amayaframework.core.contexts.HttpResponse;
import io.github.amayaframework.core.controllers.AbstractController;
import io.github.amayaframework.core.controllers.Endpoint;
import io.github.amayaframework.core.methods.Get;
import io.github.amayaframework.core.methods.Post;
import io.github.amayaframework.core.wrapping.Body;
import io.github.amayaframework.core.wrapping.Path;
import io.github.amayaframework.gson.Entity;

import static io.github.amayaframework.core.contexts.Responses.badRequest;
import static io.github.amayaframework.core.contexts.Responses.ok;

@Endpoint
public class ExampleController extends AbstractController {
    @Get("/hello/{count:int}")
    public HttpResponse get(HttpRequest request, @Path("count") Integer count) {
        String helloWorld = "Hello, world!";
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            response.append(helloWorld).append('\n');
        }
        return ok(response);
    }

    @Get
    public HttpResponse postmanToken(HttpRequest request) {
        StringBuilder answer = new StringBuilder();
        answer.append("Hello, Postman! Your token is ").
                append(request.getHeader("Postman-Token"));
        return ok(answer);
    }

    @Post("/calc")
    @Entity(CalcData.class)
    public HttpResponse calculate(HttpRequest request, @Body CalcData data) {
        double res;
        try {
            res = data.calculate();
        } catch (IllegalArgumentException e) {
            return badRequest("Divide by zero!");
        } catch (UnsupportedOperationException e) {
            return badRequest("Unknown operation!");
        }
        return ok("Answer is: " + res);
    }
}
