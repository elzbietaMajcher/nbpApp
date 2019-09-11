package nbp;

import com.google.gson.Gson;

import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.*;

public class CurrencyReader {


    //method which is reading information about a given currency between current date and given date
    //http://api.nbp.pl/api/exchangerates/rates/{table}/{code}/{startDate}/{endDate}/

    protected static Currency readInfo(String startDate) {
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
            if (e.getMessage().contains("400")) {
                System.out.println("400 Bad Request or 93 days limit exceeded");
                System.out.println("Or input date is a future date.\n");
            } else
                System.out.println("Input date format not correct.\n");
        }
        return currencyToSave;
    }
}
