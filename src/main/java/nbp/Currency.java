package nbp;


import java.util.List;

public class Currency {

    String code; // USD
    List<Rates> rates;

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
}
