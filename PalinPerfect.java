//Palindromic perfect squares between two integers 
//Steffi Baumgart
//28 July 2015

import java.util.Scanner;
import java.lang.Math;

public class PalinPerfect {
    public static void main(String[] args) {

        Scanner scanf = new Scanner(System.in);

        System.out.println("Enter the starting point N:");
        int start = Integer.parseInt(scanf.nextLine());
        
        if (start <= 0){
            start += 1; }

        System.out.println("Enter the ending point M:");
        int end = Integer.parseInt(scanf.nextLine()); 
        
        System.out.println("The palindromic perfect squares are as follows:");

        String revNum = "";
        String num = "";
        boolean prime = false;
        Double check = 0.0;
        
        if (start <= 0){
            start += 1;
                        }
                        
         //Loop through range                
        for (int i = start; i < end; i++) {
        
            if (palindromic(i)){
            check = (double)Math.sqrt(i); 
            
                if (check%1==0){
                    System.out.println(i);}
                }
            }
        }


    public static boolean palindromic(int i){
        String num = i + ""; 
        String revNum = "";
        
        for (int k =  num.length()-1; k >= 0; k--) {
            revNum += num.charAt(k);}
        
        if (num.equalsIgnoreCase(revNum)){
             return true; }
             
        else { return false;}
            
    }
}