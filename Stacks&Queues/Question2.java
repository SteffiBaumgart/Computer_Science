/**
 * Created by Baumgart on 2015/09/26.
 */
import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    public static void main(String[] args) {
        boolean error = false;
        String top = "";

        System.out.println("Enter a string to test:");

        Scanner scanf = new Scanner(System.in);
        String temp = scanf.nextLine();

        char start = temp.charAt(0);

      
	  
        String[] input = temp.split(" ");
        Stack<String> s = new Stack<>();


        for (String b : input) {

            //Push opening brackets onto stack
            switch (b) {
                case "(":
                case "{":
                case "<":
                case "[":
                    s.push(b);
                    break;

            }

            if (s.size() != 0) {
                top = s.peek();
            }

            //Remove if matching (opening and closing) brackets
            if (b.equals("}") && top.equals("{") || b.equals(")") && top.equals("(") || b.equals("]") && top.equals("[") || b.equals(">") && top.equals("<")) {
                s.pop();
            }

            //Detect mismatching brackets
            else if ((b.equals("}")) && (top.equals("(") || top.equals("[") || top.equals("<"))
                    || (b.equals(")")) && (top.equals("{") || top.equals("[") || top.equals("<"))
                    || (b.equals("]")) && (top.equals("(") || top.equals("{") || top.equals("<"))
                    || (b.equals(">")) && (top.equals("(") || top.equals("[") || top.equals("{"))) {

                System.out.println("error: '"+b+"' does not match with '"+top+"'.");
                error = true;
                break;
            }


        }

        //if Correct String
        if (s.isEmpty() && error = false)
		) {
            System.out.println("The string is correct! There are no mismatched brackets.");
        }


        //Unclosed brackets
        else if (s.size() == 1) {

            System.out.print("error at end: ");
            String unclosed = s.pop();

            switch (unclosed) {
                case "(":
                case "{":
                case "<":
                case "[":
                    System.out.println("opening bracket '"+unclosed+"' remains unclosed.");
                    break;

                default:
                    System.out.println("the close bracket '"+unclosed+"' does not have a corresponding opening bracket.");

            }
        }

    }
}