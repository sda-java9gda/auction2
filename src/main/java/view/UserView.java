package view;

import models.User;

import java.util.List;

public class UserView {

    public static String printUsers(List<User> users) {

        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            StringBuilder append = sb.append(user.getLogin()).append("\n");
        }
        return sb.toString();

    }

    public static String printLoginSuccess(String login) {
        return "Dzien dobry " + login;
    }

    public static String printNotFound(String login) {
        return "Brak uzytkownika " + login;
    }

    public static String printAddSuccess(String login) { return "Dodano uzytkownika " + login; }

    public static String printDuplicateFound(String login) { return "Uzytkownik " + login + " juz istnieje."; }

    public static String printRemovedSuccess(String login) { return "Usunieto uzytkownika " + login; }



}
