import models.User;
import enums.*;

import java.util.Scanner;

public class Main {
    private static User user;

    public static void main(String[] args) {
        State state = State.INIT;
        Scanner scanner = new Scanner(System.in);

        while (state != State.EXIT) {
            switch (state) {
                case INIT:
                    System.out.println("Dzień dobry, co chcesz zrobić?");
                    System.out.println(" 1 - zalogować się");
                    System.out.println(" 2 - utworzyć użytkownika");
                    System.out.println(" 2 - obejrzeć aukcje");
                    System.out.println(" 2 - wystawić aukcję");
                    System.out.println(" 0 - wyjść z programu");
            }
        }
    }
}
