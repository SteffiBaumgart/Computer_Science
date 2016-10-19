import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Baumgart on 2015/09/26.
 */
public class Question1 {

    public static void main(String[] args) {
        String line = "";


        Scanner scanf = new Scanner(System.in);
        Queue<String> q = new LinkedList<>();


        while (!line.equals("X")) {

            if (scanf.hasNext()) {

                line = scanf.nextLine();

                // If "O" - output next string from queue
                if (line.equals("O")) {

                    //If queue is empty
                    if(q.isEmpty()){
                        System.out.println("Buffer empty");
                    }

                    //Print out item in queue
                    else {
                        String output = q.remove() + "";
                        System.out.println("Data: "+ output);

                    }

                }

                //Store string in queue
                else {
                    q.add(line);
                }
            }

            else {
                System.out.println("Buffer empty");

            }

        }

        //If "X" - exit.
        System.exit(0);
    }
}
