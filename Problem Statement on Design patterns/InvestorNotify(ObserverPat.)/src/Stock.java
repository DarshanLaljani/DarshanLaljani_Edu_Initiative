import java.util.List;
import java.util.ArrayList;

public class Stock implements Subject {
    public List<Observer> observers;
    public String symbol;
    public double price;

    public Stock(String symbol, double price) {
        observers = new ArrayList<>();
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(symbol, price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}
