package nbp;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CurrencyReaderTest {

    CurrencyReader currencyReader = new CurrencyReader();


    @org.junit.Test
    public void readInfoTest() {
        LocalDate startDate = LocalDate.now().minusDays(3);
        Currency actual = currencyReader.readInfo(startDate);

        System.out.println(actual);
        //there is no info from saturday, sunday, holiday/festival days
    }

    @Test
    public void printRatesTest() {
        Currency currency = currencyReader.readInfo(LocalDate.now().minusDays(3));
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