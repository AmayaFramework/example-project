package io.github.amayaframework.example;

import com.github.romanqed.util.IOUtil;
import io.github.amayaframework.core.contexts.HttpResponse;
import io.github.amayaframework.core.controllers.Endpoint;
import io.github.amayaframework.core.inject.Body;
import io.github.amayaframework.core.inject.Header;
import io.github.amayaframework.core.inject.Path;
import io.github.amayaframework.core.inject.Query;
import io.github.amayaframework.core.methods.Get;
import io.github.amayaframework.core.methods.Post;
import io.github.amayaframework.http.ContentType;
import io.github.amayaframework.serializer.Entity;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static io.github.amayaframework.core.contexts.Responses.*;

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
        return ok("Hello, client! ^_^");
    }

    @Get
    public HttpResponse postmanToken(@Header("Postman-Token") String token) {
        return ok("Hello, Postman! Your token is " + token);
    }

    @Get("/calc")
    public HttpResponse query(@Query String a, @Query String b, @Query String op) {
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

    @Post("/calc")
    @Entity(CalcData.class)
    public HttpResponse calc(@Body CalcData data) {
        double answer;
        try {
            answer = data.calculate();
        } catch (Exception e) {
            return badRequest();
        }
        return ok(answer);
    }

    @Get("/hello_file")
    public HttpResponse helloFile() {
        HttpResponse ret = ok();
        ret.setHeader("Content-Disposition", "filename=\"hello.txt\"");
        ret.setOutputStreamHandler(stream -> {
            String file = IOUtil.readResourceFile("hello.txt");
            byte[] bytes = file.getBytes(StandardCharsets.UTF_8);
            stream.specifyLength(bytes.length);
            stream.write(bytes);
        });
        return ret;
    }

    @Get("/test_file")
    public HttpResponse testFile() {
        HttpResponse ret = ok();
        ret.setContentType(ContentType.PNG);
        ret.setHeader("Content-Disposition", "filename=\"test.png\"");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final InputStream input = classLoader.getResourceAsStream("test.png");
        if (input == null) {
            return notFound("File not found");
        }
        ret.setOutputStreamHandler(stream -> {
            byte[] bytes = new byte[input.available()];
            if (input.read(bytes) < 0) {
                throw new IllegalStateException();
            }
            input.close();
            stream.specifyLength(bytes.length);
            stream.write(bytes);
        });
        return ret;
    }
}
