package nbp;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CurrencyTest {


    private Currency create (){
        List<Rates> rates = new ArrayList<>();
        rates.add(new Rates("2019-09-04", 3.9285, 4.0079 ));
        rates.add(new Rates("2019-09-05", 3.9038, 3.9826 ));
        rates.add(new Rates("2019-09-06", 3.8745, 3.9527 ));
        rates.add(new Rates("2019-09-09", 3.8899, 3.9685 ));
        return new Currency("USD", rates);
    }

    private Currency createEmpty (){
        return new Currency(null, null);
    }

    @Test
    public void calculateDifferenceValue() {
        double past1 = 3.45;
        double today1 = 3.40;
        Currency currency = create();

        double actual1 = currency.calculateDifferenceValue(today1,past1);
        double actual2 = currency.calculateDifferenceValue(past1,today1);

        assertEquals(-0.05, actual1,.01);
        assertEquals(0.05, actual2,.01);

    }

   @Test
    public void printInfoTest() {
        Currency currency = create();
        String actual = currency.printInfo("2019-09-04");

        String expected = "Note that for several days there is no data available.\n" +
                "USD exchange rate:\n" +
                "2019-09-04, buy exchange rate 3.9285 PLN, sell exchange rate 4.0079 PLN\n" +
                "2019-09-05, buy exchange rate 3.9038 PLN, sell exchange rate 3.9826 PLN\n" +
                "2019-09-06, buy exchange rate 3.8745 PLN, sell exchange rate 3.9527 PLN\n" +
                "2019-09-09, buy exchange rate 3.8899 PLN, sell exchange rate 3.9685 PLN\n" +
                "The difference in sell exchange rate: -0.0394 PLN.\n" +
                "The difference in buy exchange rate: -0.0386 PLN.\n";
            assertEquals(expected,actual);
    }

    @Test
    public void checkMissingDays() {
        String past = "2019-09-04";
        Currency currency = create();
        boolean actual = currency.checkMissingDays(past);
        assertTrue(actual);
    }

    @Test
    public void isEmpty() {
        Currency currency = createEmpty();
        assertTrue(currency.isEmpty());
    }

    @Test
    public void printInfoEmptyTest() {
        Currency currency = createEmpty();
        String expected = "There is no data for a given period of time.";
        String actual =  currency.printInfo("2019-09-04");
        assertEquals(expected, actual);
    }


    @Test
    public void calculateSellDifferencesTest() {
        Currency currency = create();
        double expected = -0.0394;
        double actual = currency.calculateSellDifferences();
        assertEquals(expected, actual, .0001);
    }

    @Test
    public void calculateBuyDifferencesTest() {
        Currency currency = create();
        double expected = -0.0386;
        double actual = currency.calculateBuyDifferences();
        assertEquals(expected, actual, .0001);
    }

    @Test
    public void printRatesTest() {
        String expected = "2019-09-04, buy exchange rate 3.9285 PLN, sell exchange rate 4.0079 PLN\n" +
        "2019-09-05, buy exchange rate 3.9038 PLN, sell exchange rate 3.9826 PLN\n" +
        "2019-09-06, buy exchange rate 3.8745 PLN, sell exchange rate 3.9527 PLN\n" +
        "2019-09-09, buy exchange rate 3.8899 PLN, sell exchange rate 3.9685 PLN\n";

        Currency currency = create();
        String actual = currency.printRates(new DecimalFormat("#.####"));

        assertEquals(expected, actual);
    }
}