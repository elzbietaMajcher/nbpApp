package nbp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean repeat;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.println("To see USD exchange rate of currency from given date to today");
                System.out.println("Input a past date in this format yyyy-mm-dd");
                String pastDate = sc.nextLine();
                Currency currency = CurrencyReader.readInfo(pastDate);
                System.out.println(currency.printInfo(pastDate));
            } catch (Exception e) {
                System.err.println();
                if (e.getMessage().contains("400")) {
                    System.out.println("400 Bad Request limit of 93 days has been exceeded.");
                    System.out.println("Or input date is a future date.\n");
                } else
                    System.out.println("Input date format not correct.\n");
            }
            System.out.println("To repeat press y, to exit any other key");
            repeat = sc.nextLine().equals("y");
        } while (repeat);

        System.out.println("THE END");
    }
}
