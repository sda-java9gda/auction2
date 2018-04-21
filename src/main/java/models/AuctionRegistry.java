package models;

import exceptions.AuctionNotFoundException;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.IOException;
import java.util.logging.FileHandler;

public class AuctionRegistry {
    private static AuctionRegistry instance = null;
    //final private String filename = "data/auctions.dat";

    public static AuctionRegistry getInstance(){
        if (instance == null){
            instance = new AuctionRegistry();
        }
        return instance;
    }

    private ArrayList<Auction> auctions;

    private AuctionRegistry() {
            this.auctions = FileHandler.load("auctions");
    }

    public Auction findAction(String name) throws AuctionNotFoundException {
        for (Auction auction : this.auctions) {
            if (auction.getName().equals(name)) {
                return auction;
            }
        }
        throw new  AuctionNotFoundException();
    }

    public Auction findAuctionByLogin(String login) throws AuctionNotFoundException{
        for (Auction auction : this.auctions) {
            if (auction.getUser().getLogin().equals(login)){
                return auction;
            }
        }
        throw new AuctionNotFoundException();
    }

    public void addAuction(double price, String name, String destription, int counter, User user){
        auctions.add(new Auction(price,name,destription,counter,user));
    }

    public void saveData() {
        try {
            FileHandler.save(this.auctions, "auctions");
        } catch (IOException e) {
            System.err.println("Write error or file not found.");
        }
    }
}
