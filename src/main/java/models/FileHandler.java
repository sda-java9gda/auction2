package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    public static void save(ArrayList list, String filename) {
        String filepath = "src/main/java/" + filename + ".txt";
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

    public static ArrayList load(String filename) {
        String filepath = "src/main/" + filename + ".txt";
        ArrayList<Object> list = new ArrayList<Object>();
        File file = new File(filepath);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (filename.equals("auctions")) {
                    Auction auction = parseToAuction(line);
                    list.add(auction);
                } else if (filename.equals("users")) {
                    User user = parseToUser(line);
                    list.add(user);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static Auction parseToAuction(String line) {
        String[] splits = line.split(";");
        Auction auction = new Auction();
        String name = splits[0];
        double price = Double.parseDouble(splits[1]);
        String description = splits[2];
        int counter = Integer.parseInt(splits[3]);
        boolean isFinished = Boolean.parseBoolean(splits[4]);
        User user = new User(splits[5], splits[6]);

        return auction;
    }

    private static User parseToUser(String line) {
        String[] splits = line.split(";");
        User user = new User(splits[0], splits[1]);
        return user;
    }
}
