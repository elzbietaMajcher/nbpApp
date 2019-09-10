package nbp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CurrencyReader currencyReader = new CurrencyReader();
        boolean repeat;
        Scanner sc = new Scanner(System.in);

        do {

            try {
                System.out.println("To see USD exchange rate of currency from given date to today");
                System.out.println("Input a past date in this format yyyy-mm-dd");
                String pastDate = sc.nextLine();

                Currency currency = currencyReader.readInfo(pastDate);
                System.out.println(currency.printInfo(pastDate));

                System.out.println("To repeat press y, to exit any other key");
                if (sc.nextLine().equals("y")) repeat = true;
                else repeat = false;

            } catch (Exception e) {

                repeat = true;
            }

        } while (repeat);

        System.out.println("THE END");
    }
}
