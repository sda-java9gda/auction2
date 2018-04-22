package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    public static void save(ArrayList list, String filename) {
        String filepath = "src/main/resources/" + filename + ".txt";
        try {
            FileWriter fileWriter = new FileWriter(filepath, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                printWriter.println(list.get(i).toString());
            }
            fileWriter.close();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Auction> loadAuction(String filename) {
        String filepath = "src/main/resources/" + filename + ".txt";
        ArrayList<Auction> list = new ArrayList<Auction>();
        File file = new File(filepath);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Auction auction = parseToAuction(line);
                list.add(auction);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<User> loadUser(String filename) {
        String filepath = "src/main/resources/" + filename + ".txt";
        ArrayList<User> list = new ArrayList<User>();
        File file = new File(filepath);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                User user = parseToUser(line);
                list.add(user);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static Auction parseToAuction(String line) {
        String[] splits = line.split(";");
        Auction auction = new Auction();
        auction.setName(splits[1]);
        auction.setPrice(Double.parseDouble(splits[0]));
        auction.setDestription(splits[2]);
        auction.setCounter(Integer.parseInt(splits[3]));
        auction.setFinished(Boolean.parseBoolean(splits[4]));
        auction.setUser(new User(splits[5], splits[6]));

        return auction;
    }

    private static User parseToUser(String line) {
        String[] splits = line.split(";");
        User user = new User(splits[0], splits[1]);
        return user;
    }
}
