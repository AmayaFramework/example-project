package io.github.amayaframework.example;

import io.github.amayaframework.core.Amaya;
import io.github.amayaframework.core.tomcat.TomcatBuilder;
import io.github.amayaframework.serializer.SerializeConfigurator;
import org.apache.log4j.BasicConfigurator;

public class TomcatServer {
    public static void main(String[] args) throws Throwable {
        BasicConfigurator.configure();
        Amaya<?> amaya = new TomcatBuilder()
                .bind(8080)
                .addConfigurator(new SerializeConfigurator())
                .build();
        amaya.start();
    }
}
