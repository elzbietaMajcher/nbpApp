package nbp;

import java.io.IOException;

public class CurrencyReaderTest {


    @org.junit.Test
    public void readInfoTest(){
        String startDate = "2019-09-05";
        Currency actual = CurrencyReader.readInfo(startDate);

        System.out.println(actual.toString());
        //there is no info from saturday, sunday, holiday/festival days
    }

}