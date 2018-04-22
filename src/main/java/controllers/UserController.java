package controllers;

import models.UserRegistry;
import view.UserView;
import exceptions.UserNotFoundException;
import exceptions.DuplicateFoundException;
import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class UserController {
    public static boolean addUser(String login, String password) {
        try {
            UserRegistry.getInstance().addUserAccount(login, password);
            System.out.println(UserView.printAddSuccess(login));
            return true;
        } catch (DuplicateFoundException e) {
            System.err.println(UserView.printDuplicateFound(login));
     //   } catch (WrongLoginException e) {
      //      System.out.println(UserView.printWrongLogin());
     //   } catch (WrongPasswordException e) {
      //      System.out.println(UserView.printWrongPassword());
        }
        return false;
    }

    public static boolean loginUser(String login, String password) {
        try {
            UserRegistry.getInstance().findUser(login, password);
            System.out.println(UserView.printLoginSuccess(login));
            return true;
        } catch (UserNotFoundException e) {
            System.err.println(UserView.printNotFound(login));
        }
        return false;
    }
}
