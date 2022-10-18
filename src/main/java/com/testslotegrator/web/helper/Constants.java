package com.testslotegrator.web.helper;

public class Constants {

    public static class CssSelector {
        public static final String elementWithoutLoadTable = "div:not(.grid-view-loading)";
        public static final String elementTableBodyRows = "tbody tr";
        public static final String selectedOption = "option[@selected]";

    }

    public static class XpathSelector {
        public static final String selectedOptionWithText = "//option[@selected and text()=\"%s\"]";
    }

    public static class Urls {
        public static String login = "/admin/login";
        public static String player = "/user/player/admin";

    }

}
