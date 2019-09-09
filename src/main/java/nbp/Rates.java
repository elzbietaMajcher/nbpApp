package nbp;

import java.time.LocalDate;

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

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }
}
