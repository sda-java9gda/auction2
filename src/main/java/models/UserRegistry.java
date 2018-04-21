package models;
import exceptions.UserNotFoundException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.io.IOException;
import exceptions.*;

public class UserRegistry implements Serializable {
     private static UserRegistry instance = null;
     //final private String filename ="data/user.dat";

     public static UserRegistry getInstance() {
         if (instance == null) {
             instance = new UserRegistry();
         }
         return instance;
     }

     private ArrayList<User> users;

     private UserRegistry() {
         users = (ArrayList<User>) models.FileHandler.load("filename");
     }
    public void findUser(String login, String password) throws UserNotFoundException {
        for (User user : this.users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return;
            }
        }
        throw new UserNotFoundException();
    }
    public void addUserAccount(String login, String password) throws DuplicateFoundException {
        for (User user : users) {
            if (user.getLogin().equals(login))
                throw new DuplicateFoundException();
        }
        this.users.add(new User(login, password));
    }
    public void saveData() {
            models.FileHandler.save(this.users, "users");
    }

    public ArrayList<User> getAdmins() {
        return users;
    }
}
