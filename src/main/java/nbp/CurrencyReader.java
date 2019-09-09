package nbp;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CurrencyReader {


    //TODO: method which is reading information about a given currency between current date and given date
    //http://api.nbp.pl/api/exchangerates/rates/{table}/{code}/{startDate}/{endDate}/

    public static Currency readInfo(String startDate) {
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

        } catch (Exception e) {
            System.out.println(e);
        }
        return currencyToSave;
    }

    public static void printRates(Currency currency) {

        DecimalFormat df = new DecimalFormat("#.####");

        System.out.println("Exchange rate of currency " + currency.getCode()+ ":");
        currency.getRates().stream().forEach(c -> System.out.println(String.format(
                c.getEffectiveDate() + ", buy exchange rate " + df.format(c.getBid()) +" PLN, sell exchange rate " +  df.format(c.getAsk()) +" PLN")));
        double sellDifference = calculateDifferenceValue(currency.getRates().get(0).getAsk(), currency.getRates().get(currency.getRates().size()-1).getAsk());
        double buyDifference = calculateDifferenceValue(currency.getRates().get(0).getBid(), currency.getRates().get(currency.getRates().size()-1).getBid());

        System.out.println("The difference in sell exchange rate: " +  df.format(sellDifference) + " PLN.");
        System.out.println("The difference in buy exchange rate: " +  df.format(buyDifference) + " PLN.");
    }

    public static double calculateDifferenceValue (double todayValue, double pastValue) {
        return todayValue - pastValue;
    }


}
