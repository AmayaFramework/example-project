package io.github.amayaframework.example;

import io.github.amayaframework.core.Amaya;
import io.github.amayaframework.core.handlers.Event;
import io.github.amayaframework.core.sun.SunBuilder;
import org.apache.log4j.BasicConfigurator;

public class SunServer {
    public static void main(String[] args) throws Throwable {
        BasicConfigurator.configure();
        Amaya<?> amaya = new SunBuilder().
                bind(8080).
                build();
        amaya.getEventManager().addEvent(Event.INPUT_ERROR, (Throwable e) -> System.out.println(e.getMessage()));
        amaya.start();
    }
}
