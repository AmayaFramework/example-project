package io.github.amayaframework.example;

import io.github.amayaframework.core.AmayaBuilder;
import io.github.amayaframework.core.config.AmayaConfig;
import io.github.amayaframework.core.config.ConfigProvider;
import io.github.amayaframework.gson.GsonConfigurator;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.log4j.BasicConfigurator;

public class TomcatServer {
    public static void main(String[] args) throws LifecycleException {
        BasicConfigurator.configure();
        AmayaConfig config = new AmayaConfig();
        config.setDebug(false);
        ConfigProvider.setConfig(config);
        Tomcat tomcat = new AmayaBuilder().
                bind(8080).
                addConfigurator(new GsonConfigurator()).
                build();
        tomcat.start();
        tomcat.getServer().await();
    }
}
