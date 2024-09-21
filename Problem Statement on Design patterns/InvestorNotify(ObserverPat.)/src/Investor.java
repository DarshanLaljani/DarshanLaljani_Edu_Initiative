public class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("Notifying " + name + " of " + stockSymbol + "'s price change to " + stockPrice);
    }

    public String getName() {
        return name;
    }
}
