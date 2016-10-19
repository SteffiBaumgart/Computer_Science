//Converts to different time formats
//Steffi Baumgart
//27 July 2015

import java.util.Scanner;

public class TimeConverter {
public static void main(String[] args) {

       
        Scanner scanf = new Scanner(System.in);

        System.out.println("Enter a time ([h]h:mm [am|pm])");
        String input = scanf.nextLine();

        int hour = Integer.parseInt(input.substring(0,2));
        int minutes = Integer.parseInt(input.substring(3,5));
        int size = input.length();
        String output = ""; 


        if(input.charAt(input.length()-1) == 'm')
        {
            if(input.charAt(input.length()-2) == 'p') {
                hour += 12;
                output = hour + ":" + minutes ;}
                
            else{
                if (hour < 10){
                    output = "0" + hour;}
                    
                else {
                    output +=  "" +hour;}
            }}

        else{
            if(hour > 12){
                hour -= 12;
                output = hour + ":" + minutes + " pm";
            }else{
                output = hour + ":" + minutes + " am";
            }
        }

        System.out.println(output);

    }
}

     