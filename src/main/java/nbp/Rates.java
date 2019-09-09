package nbp;

import java.time.LocalDate;

public class Rates {
    String effectiveDate;
    double bid; // buy exchange rate
    double ask; // sell exchange rate

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
}
