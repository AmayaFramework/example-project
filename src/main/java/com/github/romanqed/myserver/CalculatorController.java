package com.github.romanqed.myserver;

import io.github.amayaframework.core.contexts.HttpRequest;
import io.github.amayaframework.core.contexts.HttpResponse;
import io.github.amayaframework.core.controllers.AbstractController;
import io.github.amayaframework.core.controllers.Endpoint;
import io.github.amayaframework.core.methods.Post;
import io.github.amayaframework.core.wrapping.Body;
import io.github.amayaframework.gson.Entity;

import static io.github.amayaframework.core.contexts.Responses.*;

@Endpoint("/calc")
@Entity(CalcData.class)
public class CalculatorController extends AbstractController {
    @Post
    public HttpResponse calculate(HttpRequest request, @Body CalcData data) {
        double res = 0;
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
