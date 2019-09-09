package nbp;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rates> getRates() {
        return rates;
    }

    public void setRates(List<Rates> rates) {
        this.rates = rates;
    }
}
