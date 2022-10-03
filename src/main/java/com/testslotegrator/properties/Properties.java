package com.testslotegrator.properties;

import org.openqa.selenium.Keys;

public class Properties extends PropertiesProvider {

    // parameters
    public static int timeoutWaitStep = Integer.parseInt(getProperty("timeout.wait.step"));
    public static int timeoutLongWaitStep = Integer.parseInt(getProperty("timeout.wait.step.long"));
    public static final boolean usedMac = Boolean.parseBoolean(getProperty("used.mac"));
    public static Keys keysForClear = usedMac ? Keys.COMMAND : Keys.CONTROL;

    // urls
    public static String url_shopping_list_page = getUrl("shopping.list.page");
    public static String path_api_shopping_list = getUrl("api.shopping.list.path");

    public static String urlFront = getProperty("instance.url");
    public static String urlApi = getProperty("instance.url.api");
}
