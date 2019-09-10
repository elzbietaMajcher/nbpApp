package nbp;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;


public class Currency {

    private String code; // USD
    private List<Rates> rates;

    public Currency(String code, List<Rates> rates) {
        this.code = code;
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }

    public boolean isEmpty() {
        if (code == null && rates == null) return true;
        return false;
    }

    public String printInfo(String pastDate) {

        StringBuilder sb = new StringBuilder();

        if (isEmpty()) {
            return "There is no data for a given period of time.";
        } else {
            if (checkMissingDays(pastDate)) sb.append("Note that for several days there is no data available.\n");
            DecimalFormat df = new DecimalFormat("#.####");
            double sellDifference = calculateSellDifferences();
            double buyDifference = calculateBuyDifferences();

            sb.append(code + " exchange rate:\n");
            sb.append(printRates(df));
            sb.append("The difference in sell exchange rate: " + df.format(sellDifference) + " PLN.\n");
            sb.append("The difference in buy exchange rate: " + df.format(buyDifference) + " PLN.\n");
        }
        return String.valueOf(sb);
    }

    String printRates(DecimalFormat df) {

        StringBuilder sb = new StringBuilder();
        rates.stream().forEach(c -> sb.append(
                c.getEffectiveDate() + ", buy exchange rate " + df.format(c.getBid()) + " PLN, sell exchange rate " + df.format(c.getAsk()) + " PLN\n"));
        return String.valueOf(sb);
    }

    double calculateSellDifferences() {
        return calculateDifferenceValue(rates.get(rates.size() - 1).getAsk(), rates.get(0).getAsk());
    }

    double calculateBuyDifferences() {
        return calculateDifferenceValue(rates.get(rates.size() - 1).getBid(), rates.get(0).getBid());
    }

    double calculateDifferenceValue(double todayValue, double pastValue) {
        return todayValue - pastValue;
    }

    boolean checkMissingDays(String pastDate) {
        LocalDate today = LocalDate.now();
        LocalDate past = LocalDate.parse(pastDate);
        long days = today.toEpochDay() - past.toEpochDay();

        if (days != (rates.size() - 1)) return true;
        return false;
    }
}
