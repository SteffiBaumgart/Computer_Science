/**
 * Created by Baumgart on 2015/09/16.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Question1 {


    public static void main(String[] args) {
        String name;
        String colour;
        double volume;
        int choice = 0;
        String[] details;

        ArrayList<SoftDrink> SoftDrinks = new ArrayList<>(10);


        Scanner scanf = new Scanner(System.in);

        while (choice != 2) {

            System.out.println("Enter option: (1) add soft drink (2) quit:");
            choice = scanf.nextInt();
            scanf.nextLine();


            if (choice == 1) {

                System.out.println("Enter name, colour and volume in ml separated by space");
                details = scanf.nextLine().split(" ");
                name = details[0];
                colour = details[1];
                volume = Double.parseDouble(details[2]);

                SoftDrink sd = new SoftDrink(name, colour, volume);
                SoftDrinks.add(sd);

            }


        }
         Collections.sort(SoftDrinks);

        for (int i = 0; i<SoftDrinks.size(); i++){
            System.out.println(SoftDrinks.get(i));

        }

    }

}
