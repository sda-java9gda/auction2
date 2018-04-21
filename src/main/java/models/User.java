package models;

public class User {

    private String login;
    private String password;

    @Override
    public String toString() {
        return  login + ";" + password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
