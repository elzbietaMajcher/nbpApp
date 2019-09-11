package nbp;

public class CurrencyReaderTest {


    @org.junit.Test
    public void readInfoTest() throws Exception {
        String startDate = "2019-09-05";
        Currency actual = CurrencyReader.readInfo(startDate);

        System.out.println(actual.toString());
        //there is no info from saturday, sunday, holiday/festival days
    }

}