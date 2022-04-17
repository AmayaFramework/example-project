package io.github.amayaframework.example;

import io.github.amayaframework.core.Amaya;
import io.github.amayaframework.core.config.AmayaConfig;
import io.github.amayaframework.core.config.ConfigProvider;
import io.github.amayaframework.core.tomcat.TomcatBuilder;
import org.apache.log4j.BasicConfigurator;

public class TomcatServer {
    public static void main(String[] args) throws Throwable {
        BasicConfigurator.configure();
        AmayaConfig config = ConfigProvider.getConfig();
        config.setDebug(false);
        Amaya<?> amaya = new TomcatBuilder().
                bind(8080).
                build();
        amaya.start();
    }
}
