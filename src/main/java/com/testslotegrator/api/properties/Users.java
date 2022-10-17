package com.testslotegrator.api.properties;

public class Users extends PropertiesProvider {

    public static User admin = new User();
    public static User userApi = new User();

    static {
        admin.setLogin(getUserLogin("admin"));
        admin.setPassword(getUserPassword("admin"));
    }

    static {
        userApi.setLogin(getUserLogin("userApi"));
    }

    public static class User {
        public String login;
        public String password;

        private void setLogin(String login) {
            this.login = login;
        }

        private void setPassword(String password) {
            this.password = password;
        }

        private String getLogin() {
            return this.login;
        }

        private String getPassword() {
            return this.password;
        }
    }
}
