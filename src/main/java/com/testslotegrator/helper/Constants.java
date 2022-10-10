package com.testslotegrator.helper;

public class Constants {

    public static String keyA = "A";

    public static class Attributes {
        public static String attributeButton = "button";
    }

    public static class Colors {
        public static String rgbActiveMenuBorder = "rgb(61, 199, 149)";
    }
    public static class CssSelector {
        public static final String tableColumnsWithoutFirst = "td:not(:nth-child(1))";
        public static final String elementWithLoadTable = "div(.grid-view-loading)";
        public static final String elementWithoutLoadTable = "div:not(.grid-view-loading)";

    }

    public static class ApiStatusMessages {
        public static String shoppingListNotFound = "Shopping list not found";

    }

    public static class Urls {
        public static String login = "/admin/login";
        public static String player = "/user/player/admin";

    }

}
