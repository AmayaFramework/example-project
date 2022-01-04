package com.github.romanqed.myserver;

import io.github.amayaframework.core.AmayaBuilder;
import io.github.amayaframework.core.AmayaServer;
import io.github.amayaframework.gson.GsonPipelineConfigurator;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        AmayaServer server = new AmayaBuilder().
                bind(new InetSocketAddress(8080)).
                addConfigurator(new GsonPipelineConfigurator()).
                build();
        server.start();
    }
}
