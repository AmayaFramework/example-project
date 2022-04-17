package io.github.amayaframework.example;

import io.github.amayaframework.core.Amaya;
import io.github.amayaframework.core.config.AmayaConfig;
import io.github.amayaframework.core.config.ConfigProvider;
import io.github.amayaframework.core.sun.SunBuilder;
import org.apache.log4j.BasicConfigurator;

public class SunServer {
    public static void main(String[] args) throws Throwable {
        BasicConfigurator.configure();
        AmayaConfig config = ConfigProvider.getConfig();
        config.setDebug(false);
        Amaya<?> amaya = new SunBuilder().
                bind(8080).
                build();
        amaya.start();
    }
}
