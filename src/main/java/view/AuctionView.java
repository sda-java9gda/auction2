package view;

import models.Auction;
import models.User;

import java.util.List;

public class AuctionView {
    public static String printAuctions(List<Auction> auctions){

        StringBuilder sb = new StringBuilder();
        for (Auction auction : auctions) {
            StringBuilder append = sb.append(auction.getName()).append("\n");
        }
        return sb.toString();
    }
    public static String printNotFound(String name) {
        return "Brak aukcji " + name;
    }

    public static String printAddSuccess(String name) { return "Dodano aukcje " + name; }

    public static String printSaledSuccess(String name) { return "Aukcja zakończona " + name; }

    public static String printDuplicateFound(String name) { return "Istnieje już taka aukcja " + name; }

    public static String printRemoveSuccess(String name) {return  "Aukcja" + name + "usunięta przez użytkownika";}
}

