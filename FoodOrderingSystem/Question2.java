import javax.lang.model.type.NullType;
import java.util.*;

/**
 * Created by Baumgart on 2015/09/02.
 */
public class Question2 {
    public static void main( String args [] )
    {
        List <Food> list = new ArrayList <Food>();
        String choice = "";
        String choice1 = "";
        String choice2 = "";
        String choice3 = "";
        String choice4 = "";
        String choice5 = "";
        boolean check = false;


        Scanner scanf = new Scanner(System.in);
        System.out.println("Welcome to Great International Food Court");


        //[SCANF.NEXTLINE() AFTER INT BEFORE STRING]

        while (choice!= "q") {

            System.out.println("MENU: add (P)izza, add (C)urry, add (S)oft drink, (D)elete, (L)ist, (Q)uit");
            choice = scanf.next();

            if (choice.equals("p")) {
                System.out.println("Enter the menu item number");
                choice1 = scanf.next();
                scanf.nextLine();
                System.out.println("Enter the size");
                choice2 = scanf.next();
                System.out.println("Enter the base");
                choice3 = scanf.next();
                System.out.println("Enter extra cheese");
                choice4 = scanf.next(); //Yes or No
                System.out.println("Enter extra garlic");
                choice5 = scanf.next(); //Yes or No

                Pizza p = new Pizza(choice1, choice2, choice3, choice4, choice5);
                list.add(p);
                System.out.println("Done");
            }


            else if (choice.equals("c")) {
                System.out.println("Enter the menu item number");
                choice1 = scanf.next();
                System.out.println("Enter the size");
                choice2 = scanf.next();
                scanf.nextLine();
                System.out.println("Enter the curry type");
                choice3 = scanf.next();

                Curry c = new Curry(choice1, choice2, choice3);
                list.add(c);
                System.out.println("Done");
            }


            else if (choice.equals("s")) {
                System.out.println("Enter the menu item number");
                choice1 = scanf.next();
                System.out.println("Enter the size");
                choice2 = scanf.next();
                scanf.nextLine();
                System.out.println("Enter the flavour");
                choice3 = scanf.next();
                System.out.println("Enter whether it is a bottle or can");
                choice4 = scanf.next(); //Bottle or Can

                SoftDrink s = new SoftDrink(choice1, choice2, choice3, choice4);
                list.add(s);
                System.out.println("Done");
            }


            else if (choice.equals("d")) {
                System.out.println("Enter the menu item number");
                String temp = scanf.next();

                //DOWNCASTING - POLYMORPHISM
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof Pizza || list.get(i) instanceof Curry || list.get(i) instanceof SoftDrink) {
                        Food f = (Food) list.get(i);

                        if (f.getMenuItem().equals(temp)) {
                            check = true;
                            list.remove(i);
                            System.out.println("Done");
                            break;
                        }

                    }
                }
                if (check == false){
                    System.out.println("Not found");
                    }
            }


            //e.g. Pizza: 123, 12", Hand-tossed, Yes, Yes
            else if (choice.equals("l")) {

                //Skip "done" if array list is empty
                //if (list.isEmpty()) {
                    //break; }

                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
                System.out.println("Done");
        }


            else if (choice.equals("q")) {
                scanf.close();
                System.exit(0);
            }

            //if Menu Item is not found
            else {
                System.out.println("Not found");
            }




    }
  }
}
