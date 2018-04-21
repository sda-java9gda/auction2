package controllers;

import models.UserRegistry;
import view.UserView;
import exceptions.UserNotFoundException;
import exceptions.DuplicateFoundException;
import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class UserController {
    public static void addUser(String login, String password) {
        try {
            UserRegistry.getInstance().addUserAccount(login, password);
            System.out.println(UserView.printAddSuccess(login));
        } catch (DuplicateFoundException e) {
            System.out.println(UserView.printDuplicateFound(login));
     //   } catch (WrongLoginException e) {
      //      System.out.println(UserView.printWrongLogin());
     //   } catch (WrongPasswordException e) {
      //      System.out.println(UserView.printWrongPassword());
        }
    }

    public static void loginUser(String login, String password) {
        try {
            UserRegistry.getInstance().findUser(login, password);
            System.out.println(UserView.printLoginSuccess(login));
        } catch (UserNotFoundException e) {
            System.out.println(UserView.printNotFound(login));
        }
    }
}
