//Conversion Table for feet & inches to metres 
//Steffi Baumgart
//27 July 2015

import java.util.Scanner;

public class ImperialMetric {
    public static void main(String[] args) {


        Scanner scanf = new Scanner(System.in);

        System.out.println("Enter the minimum number of feet (not less than 0):");
        int min = Integer.parseInt(scanf.nextLine());

        System.out.println("Enter the maximum number of feet (not more than 30):");
        int max = Integer.parseInt(scanf.nextLine());        
   
       
        //Nested for loop for converstion table
        for (int i = min-1; i <= max; i++) {
            for (int j = 0; j < 12; j++) {
                if (i == min-1){
                    if (j == 0){
                        System.out.printf("%4s%5d%s","|",j,"\"");}
                   
                    if (j != 0) {
                    System.out.printf("%5d%s", j, "\""); }}

                if (i != min-1) {
                   double metres = (i * 12 + j) * 0.0254;
                    if (j == 0){
                        System.out.printf("%-3s%s%6.3f", i + "'", "|", metres);}
                    else {
                        System.out.printf("%6.3f", metres);}
                }
            }
            System.out.println();
            
           }
           }
           }
    