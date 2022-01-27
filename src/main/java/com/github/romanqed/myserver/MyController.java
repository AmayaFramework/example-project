package com.github.romanqed.myserver;

import io.github.amayaframework.core.contexts.HttpRequest;
import io.github.amayaframework.core.contexts.HttpResponse;
import io.github.amayaframework.core.controllers.AbstractController;
import io.github.amayaframework.core.controllers.Endpoint;
import io.github.amayaframework.core.methods.Get;
import io.github.amayaframework.core.methods.Post;
import io.github.amayaframework.core.wrapping.Body;
import io.github.amayaframework.core.wrapping.Path;
import io.github.amayaframework.gson.Entity;

import static io.github.amayaframework.core.contexts.Responses.ok;

@Endpoint("/my-end-point")
@Entity(Data.class)
public class MyController extends AbstractController {
    @Get("/{count:int}")
    public HttpResponse get(HttpRequest request, @Path("count") Integer count) {
        String helloWorld = "Hello, world!";
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            response.append(helloWorld).append('\n');
        }
        return ok(response);
    }

    @Post
    public HttpResponse post(HttpRequest request, @Body Data body) {
        body.setLeft(body.getLeft() - 5);
        body.setRight(body.getRight() - 10);
        return ok(body);
    }
}
