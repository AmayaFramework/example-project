package io.github.amayaframework.example;

import io.github.amayaframework.core.AmayaBuilder;
import io.github.amayaframework.core.util.AmayaConfig;
import io.github.amayaframework.gson.GsonConfigurator;
import io.github.amayaframework.server.interfaces.HttpServer;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

public class SunServer {
    public static void main(String[] args) throws IOException {
        BasicConfigurator.configure();
        AmayaConfig.INSTANCE.setDebug(false);
        HttpServer server = new AmayaBuilder().
                bind(8080).
                addConfigurator(new GsonConfigurator()).
                build();
        server.start();
    }
}