package models;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandlerTest {

    @Test
    public void saveTest(){

        String expected = "10.0;Rower;;0;false;qaz;qaz";

        Auction auction1 = new Auction(10,"Rower","",new User("qaz","qaz"));
        ArrayList<Auction> auctions = new ArrayList<>(Arrays.asList(auction1));
        System.out.println(auctions);
        FileHandler.save(auctions,"Auctions");

        File file = new File("src/main/resources/Auctions.txt");
        Scanner sc = null;
        String line= "";
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                line = sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected,line);
    }
    @Test
    public void saveTestIfEmptyList(){

        String expected = "";

        ArrayList<Auction> auctions = new ArrayList<>();
        System.out.println(auctions);
        FileHandler.save(auctions,"Auctions");

        File file = new File("src/main/resources/Auctions.txt");
        Scanner sc = null;
        String line= "";
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                line = sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected,line);
    }
    @Test
    public void loadAuction(){
        Auction expected = new Auction(10,"Rower","",new User("qaz","qaz"));

        ArrayList<Auction> result = FileHandler.loadAuction("auctions");

        Assert.assertEquals(expected,result.get(0));
    }
}
