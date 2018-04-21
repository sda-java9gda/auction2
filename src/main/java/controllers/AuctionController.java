package controllers;


import exceptions.DuplicateFoundException;
import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import models.Auction;
import models.AuctionRegistry;
import models.User;
import view.AuctionView;


public class AuctionController {
    public static void addAuction(Double price, String decription, String name, User user) {
        try {
            AuctionRegistry.getInstance().addAuction(price, decription, name, user);
            System.out.println(AuctionView.printAddSuccess(name));
        } catch (DuplicateFoundException e) {
            System.out.println(AuctionView.printDuplicateFound(name));
        }
    }

    public static void makeOffer(Double price, Auction auction) {
        auction.setPrice = price;
        auction.setCounter++;
        if (auction.getCounter = 3) {
            auction.setFinished = true;
            System.out.println(AuctionView.printSaledSuccess(auction.getName));
        }
    }
}
