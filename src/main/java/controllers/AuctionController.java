package controllers;


import exceptions.AuctionNotFoundException;
import exceptions.DuplicateFoundException;
import exceptions.WrongPriceException;
import models.Auction;
import models.AuctionRegistry;
import models.User;
import view.AuctionView;

import java.util.ArrayList;


public class AuctionController {
    public static boolean addAuction(Double price, String decription, String name, User user) {
        try {
            AuctionRegistry.getInstance().addAuction(price, name, decription, user);
            System.out.println(AuctionView.printAddSuccess(name));
            return true;
        } catch (DuplicateFoundException e) {
            System.err.println(AuctionView.printDuplicateFound(name));
        }
        return false;
    }

    public static void makeOffer(Double price, Auction auction) {
        try {
            AuctionRegistry.getInstance().makeOffer(price,auction);
        } catch(WrongPriceException wpe){
            System.err.println(AuctionView.printWrongPrice());
        }
        if (auction.getCounter() == 3) {
            System.out.println(AuctionView.printSaledSuccess(auction.getName()));
            try {
                AuctionRegistry.getInstance().RemoveAuction(auction.getName());
            } catch (AuctionNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printAuctions(){
        System.out.println(AuctionView.printAuctions(AuctionRegistry.getInstance().getAuctions()));
    }

    public static void printAuction(Auction auction){
        System.out.println("Nazwa " + auction.getName()+"\n"+
                "Cena " + auction.getPrice()+"\n"+
                "Opis " + auction.getDestription()+"\n");
    }

    public static Auction chooseAuction(String name){
        try {
            return AuctionRegistry.getInstance().findAuction(name);
        } catch (AuctionNotFoundException e) {
            System.err.println(AuctionView.printNotFound(name));
        }
        return null;
    }
}
