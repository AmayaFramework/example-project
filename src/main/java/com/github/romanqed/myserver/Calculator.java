package com.github.romanqed.myserver;

import io.github.amayaframework.core.AmayaBuilder;
import io.github.amayaframework.core.AmayaServer;
import io.github.amayaframework.gson.GsonPipelineConfigurator;

import java.io.IOException;

public class Calculator {
    public static void main(String[] args) throws IOException {
        AmayaServer server = new AmayaBuilder().
                addConfigurator(new GsonPipelineConfigurator()).
                build();
        server.start();
    }
}
