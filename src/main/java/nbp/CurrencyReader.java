package nbp;

import com.google.gson.Gson;

import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.*;

public class CurrencyReader {


    //method which is reading information about a given currency between current date and given date
    //http://api.nbp.pl/api/exchangerates/rates/{table}/{code}/{startDate}/{endDate}/

    protected static Currency readInfo(String startDate) throws Exception {
        LocalDate endDate = LocalDate.now();
        Currency currency;
        String address = "http://api.nbp.pl/api/exchangerates/rates/C/USD/" + startDate + "/" + endDate + "/";
            URL urlUSD = new URL(address);
            URLConnection connection;
            connection = urlUSD.openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            String info = scanner.nextLine();
            Gson gson = new Gson();
            currency = gson.fromJson(info, Currency.class);
        return currency;
    }
}
