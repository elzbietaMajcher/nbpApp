package nbp;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class CurrencyReader {


    //TODO: method which is reading information about a given currency between current date and given date
    //http://api.nbp.pl/api/exchangerates/rates/{table}/{code}/{startDate}/{endDate}/

    public static Currency readInfo(LocalDate startDate) {
        LocalDate endDate = LocalDate.now();
        Currency currencyToSave = new Currency(null, null);


        String address = new String("http://api.nbp.pl/api/exchangerates/rates/C/USD/" + startDate + "/" + endDate + "/");
        try {
            URL urlUSD = new URL(address);
            URLConnection connection = null;

            connection = urlUSD.openConnection();

            Scanner scanner = new Scanner(connection.getInputStream());
            String info = scanner.nextLine();

            Gson gson = new Gson();

            Currency currency = gson.fromJson(info, Currency.class);

            currencyToSave = currency;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return currencyToSave;
    }

    public static void printRates(Currency currency) {

        DecimalFormat df = new DecimalFormat("#.####");

        System.out.println("Exchange rate of currency " + currency.code + ":");
        currency.rates.stream().forEach(c -> System.out.println(String.format(
                c.effectiveDate + ", buy exchange rate " + df.format(c.bid) +" PLN, buy exchange rate " +  df.format(c.ask) +" PLN")));
        double sellDifference = calculateDifferenceValue(currency.rates.get(0).ask, currency.rates.get(currency.rates.size()-1).ask);
        double buyDifference = calculateDifferenceValue(currency.rates.get(0).bid, currency.rates.get(currency.rates.size()-1).bid);

        System.out.println("The difference in sell exchange rate: " +  df.format(sellDifference) + "PLN.");
        System.out.println("The difference in buy exchange rate: " +  df.format(buyDifference) + "PLN.");
    }

    public static double calculateDifferenceValue (double todayValue, double pastValue) {
        return todayValue - pastValue;
    }

    public static boolean isDecrease(double difference){
        if(difference < 0) return true;
        return false;
    }


}
