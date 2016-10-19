
/**
 * Created by Baumgart on 2015/09/26.
 */
import java.util.Scanner;
import java.util.Stack;


public class Question3 {

    public static void main(String[] args) {
        int one = 0;
        int two = 0;
        boolean error = false;


        Scanner scanf = new Scanner(System.in);
        String[] input = scanf.nextLine().split(" ");

        Stack<Integer> s = new Stack<>();


        for (String val: input) {

            //Push on stack if int (why doesn't isDigit() work?)
            if (val.matches("\\d+")) {
                s.push(Integer.parseInt(val));
            }

            //Error message if string is found
            else if (val.matches("[a-zA-Z]+")) {
                System.out.println("Integer expected but not found");
                error = true;
                break;
            }


            //If stack is empty
            else if (s.isEmpty()) {
                System.out.println("Insufficient symbols in expression");
                error = true;
                break;
            }


            //OPERATIONS

            //Addition
            else if (val.equals("+")) {

                if (s.size()%2==0) {
                    one = s.pop();
                    two = s.pop();
                    s.push(one + two);
                    break;
                }

                else {
                    System.out.println("Insufficient arguments for +");
                    error = true;
                    break;
                }
            }

            //Subtraction
            else if (val.equals("-")) {

                if (s.size()%2==0) {
                    one = s.pop();
                    two = s.pop();
                    s.push(two - one);
                    break;
                }

                else {
                    System.out.println("Insufficient arguments for -");
                    error = true;
                    break;
                }
            }


            //Division
            else if (val.equals("/")) {

                if (s.size()%2==0) {
                    one = s.pop();
                    two = s.pop();
                    s.push(two / one);
                    break;
                }
                else {
                    System.out.println("Insufficient arguments for /");
                    error = true;
                    break;
                }

            }

            //Multiplication
            else if (val.equals("*")) {

                if (s.size()%2==0) {
                    one = s.pop();
                    two = s.pop();
                    s.push(one * two);
                    break;
                }

                else {
                    System.out.println("Insufficient arguments for *");
                    error = true;
                    break;
                }

            }
        }

        //Pop remaining answer if no errors, otherwise print error message
        if (!error) {
            if (s.size() == 1) {
                System.out.println("Answer: " + s.pop());
            } else {
                System.out.println("Extra symbols in expression");
            }
        }

    }
}






