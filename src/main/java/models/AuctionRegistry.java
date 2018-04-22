package models;

import exceptions.AuctionNotFoundException;
import exceptions.DuplicateFoundException;
import exceptions.WrongLoginException;
import exceptions.WrongPriceException;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.IOException;
import java.util.logging.FileHandler;

public class AuctionRegistry {
    private static AuctionRegistry instance = null;

    public static AuctionRegistry getInstance() {
        if (instance == null) {
            instance = new AuctionRegistry();
        }
        return instance;
    }

    private ArrayList<Auction> auctions;

    private AuctionRegistry() {
        this.auctions = models.FileHandler.loadAuction("auctions");
    }

    public Auction findAuction(String name) throws AuctionNotFoundException {
        for (Auction auction : this.auctions) {
            if (auction.getName().equals(name)) {
                return auction;
            }
        }
        throw new AuctionNotFoundException();
    }

    public Auction findAuctionByLogin(String login) throws AuctionNotFoundException {
        for (Auction auction : this.auctions) {
            if (auction.getUser().getLogin().equals(login)) {
                return auction;
            }
        }
        throw new AuctionNotFoundException();
    }

    public void addAuction(double price, String name, String destription, User user) throws DuplicateFoundException{
        for (Auction auction: auctions) {
            if (auction.getName().equals(name)) {
                throw new DuplicateFoundException();
            }
        }
        auctions.add(new Auction(price, name, destription, user));
    }

    public void RemoveAuction(String name) throws AuctionNotFoundException{
        for (int i = 0; i < auctions.size() ; i++) {
            if (auctions.get(i).getName().equals(name)) {
                auctions.remove(i);
                return;
            }
        }
        throw new AuctionNotFoundException();
    }
    public void RemoveAuctionByUser(Auction auction, User user) throws AuctionNotFoundException{
        for (int i = 0; i < auctions.size() ; i++) {
            if (auctions.get(i).getName().equals(auction.getName())&& auction.getUser().getLogin().equals(user.getLogin())) {
                auctions.remove(i);
                return;
            }
        }
        throw new AuctionNotFoundException();
    }

    public void saveData() {
        models.FileHandler.save(this.auctions, "auctions");
    }

    public ArrayList<Auction> getAuctions(){
        return auctions;
    }

    public void makeOffer(Double price, Auction auction) throws WrongPriceException{
        if (price > auction.getPrice()){
            auction.setPrice(price);
            auction.setCounter(auction.getCounter()+1);
        } else {
            throw new WrongPriceException();
        }
        if (auction.getCounter() == 3) {
            auction.setFinished(true);

        }
    }
}
