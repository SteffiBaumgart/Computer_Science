
/**
 * Created by Baumgart on 2015/08/03.
 */

import java.util.Scanner;
public class RegisterUI {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        CashRegister c = new CashRegister();
        int choice = 0;
        double itemPrice = 0.00;
        double amountTendered = 0.00;

        System.out.println("Cash Register\n"
               + "Running total: R0.00");

        while (true) {
            System.out.println("1. Ring up item.\n" +
                    "2. Enter amount tendered.\n" +
                    "3. New transaction.\n" +
                    "4. Quit");

            choice = s.nextInt();

            if (choice == 1) {
                System.out.println("Enter amount:");
                itemPrice = s.nextDouble();
                System.out.printf("Running total: R%.2f%n",c.Item(itemPrice));

            }


            if (choice == 2) {
                System.out.println("Enter amount:");
                amountTendered = s.nextDouble();

                System.out.printf("Running total: R%.2f%n",c.runningTotal());
                System.out.printf("Amount tendered: R%.2f%n", c.Tender(amountTendered));
                System.out.printf("Change due: R%.2f%n", c.Change());
            }


            if (choice == 3) {
                System.out.println("Running total: R0.00");
                c.clearValues();
            }


            if (choice == 4) {
                System.exit(0);
            }


        }

    }

}
