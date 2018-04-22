package models;

public class Auction {
    private double price;
    private String name;
    private String destription;
    private int counter=0;
    private boolean isFinished;
    private User user;

    public Auction(double price, String name, String destription, User user) {
        this.price = price;
        this.name = name;
        this.destription = destription;
        this.isFinished = false;
        this.user = user;
    }

    public Auction() {
    }

    @Override
    public String toString() {
        return price + ";" +
                name + ";" +
                destription + ";" +
                counter + ";"+
                isFinished + ";"+
                user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestription() {
        return destription;
    }

    public void setDestription(String destription) {
        this.destription = destription;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Auction)){
            return false;
        }
        if(o == this){
            return true;
        }
        if(o instanceof Auction){
            if(((Auction) o).name.equals(this.name) &&
                    ((Auction) o).destription.equals(this.destription)){
                return true;
            }
        }
        return false;
    }
}
