package nbp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CurrencyReader currencyReader = new CurrencyReader();
        boolean repeat = false;
        Scanner sc = new Scanner(System.in);

        do {
            try {

                System.out.println("Input a past date in this format yyyy-mm-dd");
                String pastDate = (sc.nextLine());

                Currency currency = null;
                currency = currencyReader.readInfo(pastDate);
                CurrencyReader.printRates(currency);

                System.out.println("To repeat press y");
                if (sc.nextLine().equals("y")) repeat = true;
                else repeat = false;

            } catch (Exception e) {
                System.out.println("Input date format not correct");
                repeat = true;
            }

        } while (repeat);

        System.out.println("THE END");
    }
}
