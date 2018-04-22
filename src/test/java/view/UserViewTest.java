package view;

import models.User;
import org.junit.Assert;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;

public class UserViewTest {

    @Test

    public void printUsers (){

        User user1 = new User("Blaaaaa","LoooOL");
        User user2 = new User("NANAAAAA","BOooooL");
        ArrayList<User>users=new ArrayList<>(Arrays.asList(user1,user2));

        String expected = "Blaaaaa\nNANAAAAA";
        String result =  UserView.printUsers(users);
    }
    @Test

    public void printLoginSuccess (){
        String expected = "Dzien dobry Blaaaaa";
        String result = UserView.printLoginSuccess("Blaaaaa");
        Assert.assertEquals(result,expected);
    }
    @Test

    public  void printNotFound (){
        String expected = "Brak uzytkownika Blaaaaa";
        String result = UserView.printNotFound("Blaaaaa");
        Assert.assertEquals(result,expected);
    }

    @Test

    public  void printAddSuccess (){
        String expected = "Dodano uzytkownika Blaaaaa";
        String result = UserView.printAddSuccess("Blaaaaa");
        Assert.assertEquals(result,expected);

    }
    @Test

    public void printDuplicateFound (){
        String expected = "Uzytkownik Blaaaaa juz istnieje";
        String result = UserView.printDuplicateFound("Blaaaaa");
        Assert.assertEquals(result,expected);

    }
    @Test

    public  void printRemoveSuccess (){
        String expected = "Usunieto uzytkownika Blaaaaa";
        String result = UserView.printRemovedSuccess("Blaaaaa");
        Assert.assertEquals(result,expected);

    }
    @Test

    public void printWrongLogin (){
        String expected = "Login musi miec co najmniej 4 znaki, dozwolone znaki to a-b 0-9 i .(kropka)";
        String result = UserView.printWrongLogin();
        Assert.assertEquals(result,expected);
    }

    @Test

    public  void printWrongPassword (){
        String expected = "Haslo musi miec co najmniej 4 znakow, nie moze zawierac spacji ' '.";
        String result =UserView.printWrongPassword();
        Assert.assertEquals(result,expected);
    }

}
