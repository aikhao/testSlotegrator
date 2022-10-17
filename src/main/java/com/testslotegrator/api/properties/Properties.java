package com.testslotegrator.api.properties;

public class Properties extends PropertiesProvider {

    // parameters
    public static int timeoutWaitStep = Integer.parseInt(getProperty("timeout.wait.step"));
    public static int timeoutLongWaitStep = Integer.parseInt(getProperty("timeout.wait.step.long"));
    public static final boolean usedMac = Boolean.parseBoolean(getProperty("used.mac"));

    public static String urlFront = getProperty("instance.url");
    public static String urlApi = getProperty("instance.url.api");
    public static String keyApi = getProperty("api.key");
}
