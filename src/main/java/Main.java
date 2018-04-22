import controllers.AuctionController;
import controllers.UserController;
import models.Auction;
import models.AuctionRegistry;
import models.User;
import enums.*;
import models.UserRegistry;

import java.util.Scanner;

public class Main {
    public static User user;

    public static void main(String[] args) {
        State state = State.INIT;
        Auction auction = null;
        Scanner scanner = new Scanner(System.in);

        while (state != State.EXIT) {
            switch (state) {
                case INIT:
                    System.out.println("Dzień dobry, co chcesz zrobić?");
                    System.out.println(" 1 - zalogować się");
                    System.out.println(" 2 - utworzyć użytkownika");
                    System.out.println(" 0 - wyjdź z programu");
                    String answer = scanner.nextLine();

                    switch (answer) {
                        case ("1"):
                            state = State.LOGGING;
                            break;

                        case ("2"):
                            state = State.CREATING;
                            break;

                        case ("0"):
                            state = State.EXIT;
                            break;

                        default:
                            System.out.println("Zła odpowiedź");
                            state = State.INIT;
                            break;
                    }
                    break;
                case LOGGING:
                    String login, password;
                    boolean loginSuccess;

                    System.out.println("Podaj login");
                    login = scanner.nextLine();

                    System.out.println("Podaj hasło");
                    password = scanner.nextLine();

                    loginSuccess = UserController.loginUser(login, password);
                    if (loginSuccess) {
                        state = State.LOGGED;
                    } else {
                        state = State.INIT;
                    }
                    break;
                case CREATING:
                    System.out.println("Podaj login");
                    login = scanner.nextLine();

                    System.out.println("Podaj hasło");
                    password = scanner.nextLine();

                    loginSuccess = UserController.addUser(login, password);
                    if (loginSuccess) {
                        state = State.LOGGED;
                    } else {
                        state = State.INIT;
                    }
                    break;
                case LOGGED:
                    System.out.println("Co chcesz zrobić?");
                    System.out.println(" 1 - obejrzyj wszystkie aukcje");
                    System.out.println(" 2 - dodaj aukcję");
                    System.out.println(" 3 - usuń aukcję");
                    System.out.println(" 0 - wyjdź z programu");

                    answer = scanner.nextLine();
                    switch (answer) {
                        case ("1"):
                            state = State.AUCTION_LIST;
                            break;

                        case ("2"):
                            state = State.AUCTION_CREATE;
                            break;

                        case ("3"):
                            state = State.AUCTION_CREATE;
                            break;

                        case ("0"):
                            state = State.EXIT;
                            break;

                        default:
                            System.out.println("Zła odpowiedź");
                            state = State.INIT;
                            break;
                    }
                    break;
                case AUCTION_LIST:
                    System.out.println("Lista trwających aukcji:");
                    AuctionController.printAuctions();
                    System.out.println("Co chcesz zrobić?");
                    System.out.println(" nazwa - wybierz aukcję");
                    System.out.println(" 0 - wyjdź z programu");
                    answer = scanner.nextLine();
                    if(answer.equals("0")){
                        state = State.EXIT;
                    } else {
                        auction = AuctionController.chooseAuction(answer);
                        if (!(answer == null)) {
                            state = State.AUCTION_CHOOSED;
                            AuctionController.printAuction(auction);
                        } else {
                            state = State.INIT;
                        }
                    }
                    break;
                case AUCTION_CHOOSED:
                    System.out.println("Co chcesz zrobić?");
                    System.out.println(" 1 - złóż ofertę");
                    System.out.println(" 0 - wyjdź z programu");

                    answer = scanner.nextLine();
                    switch (answer) {
                        case ("1"):
                            state = State.AUCTION_OFFER;
                            break;

                        case ("0"):
                            state = State.EXIT;
                            break;

                        default:
                            System.out.println("Zła odpowiedź");
                            state = State.INIT;
                            break;
                    }
                    break;
                case AUCTION_OFFER:
                    System.out.println("Podaj ofertę");
                    answer = scanner.nextLine();
                    AuctionController.makeOffer(Double.parseDouble(answer),auction);
                    state = State.AUCTION_LIST;
                    break;
            }
        }
        saveData();
    }

    private static void saveData() {
        AuctionRegistry.getInstance().saveData();
        UserRegistry.getInstance().saveData();
    }
}
