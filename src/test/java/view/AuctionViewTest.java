package view;

import models.Auction;
import models.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AuctionViewTest {

    @Test
    public void printAuctions(){

        Auction auction1 = new Auction(10,"Rower","",new User("qaz","qaz"));
        Auction auction2 = new Auction(10,"Motor","",new User("zaq","zaq"));
        ArrayList<Auction> auctions = new ArrayList<>(Arrays.asList(auction1,auction2));

        String expected = "Rower\nMotor";
        String result = AuctionView.printAuctions(auctions);
    }

    @Test
    public void printNotFound(){
        String expected = "Brak aukcji Baton";
        String result = AuctionView.printNotFound("Baton");
        Assert.assertEquals(result,expected);
    }

    @Test
    public void printAddSuccess(){
        String expected = "Dodano aukcje Baton";
        String result = AuctionView.printAddSuccess("Baton");
        Assert.assertEquals(result,expected);
    }

    @Test
    public void printSaledSuccess(){
        String expected = "Aukcja zakończona Baton";
        String result = AuctionView.printSaledSuccess("Baton");
        Assert.assertEquals(result,expected);
    }

    @Test
    public void printDuplicateFound(){
        String expected = "Istnieje już taka aukcja Baton";
        String result = AuctionView.printDuplicateFound("Baton");
        Assert.assertEquals(result,expected);
    }

    @Test
    public void printRemoveSuccess(){
        String expected = "AukcjaBatonusunięta przez użytkownika";
        String result = AuctionView.printRemoveSuccess("Baton");
        Assert.assertEquals(result,expected);
    }

}
