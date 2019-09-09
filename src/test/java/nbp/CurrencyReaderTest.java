package nbp;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CurrencyReaderTest {

    CurrencyReader currencyReader = new CurrencyReader();


    private Currency create (){

        List<Rates> rates = new ArrayList<>();
        rates.add(new Rates("2019-09-04", 3.9285, 4.0079 ));
        rates.add(new Rates("2019-09-05", 3.9038, 3.9826 ));
        rates.add(new Rates("2019-09-06", 3.8745, 3.9527 ));
        rates.add(new Rates("2019-09-09", 3.8899, 3.9685 ));
        return new Currency("USD", rates);
    }

    @org.junit.Test
    public void readInfoTest() throws IOException {
        String startDate = "2019-09-05";
        System.out.println(startDate);
        Currency actual = currencyReader.readInfo(startDate);

        System.out.println(actual);
        //there is no info from saturday, sunday, holiday/festival days
    }

    @Test
    public void printRatesTest() {
        Currency currency = create();
        CurrencyReader.printRates(currency);
    }

    @Test
    public void calculateDifferenceValueTest() {

        double past1 = 3.45;
        double today1 = 3.40;

        double actual1 = currencyReader.calculateDifferenceValue(today1,past1);
        double actual2 = currencyReader.calculateDifferenceValue(past1,today1);

        assertEquals(-0.05, actual1,.01);
        assertEquals(0.05, actual2,.01);

    }
}