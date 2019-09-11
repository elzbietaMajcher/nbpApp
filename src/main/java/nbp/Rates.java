package nbp;

public class Rates {
    private String effectiveDate;
    private double bid; // buy exchange rate
    private double ask; // sell exchange rate

    public Rates(String date, double bid, double ask) {
        this.effectiveDate = date;
        this.bid = bid;
        this.ask = ask;
    }

    @Override
    public String toString() {
        return "Rates{" +
                "date=" + effectiveDate +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }
}
