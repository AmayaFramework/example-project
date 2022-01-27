package com.github.romanqed.myserver;

import io.github.amayaframework.core.AmayaBuilder;
import io.github.amayaframework.core.AmayaServer;
import io.github.amayaframework.gson.GsonConfigurator;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        AmayaServer server = new AmayaBuilder().
                bind(8080).
                addConfigurator(new GsonConfigurator()).
                build();
        server.start();
    }
}
