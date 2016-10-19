/**
 * Created by Baumgart on 2015/08/03.
 */

import java.lang.Math;
public class Collator {
    private int minimum, maximum, noOfReadings;
    private double average;


    public Collator () {
    //If it were 0 , the min & max would never change
    minimum = Integer.MAX_VALUE;
    maximum = Integer.MIN_VALUE;
    average = 0;
    noOfReadings = 0;
    }

    // Use the given reading to update the record.
    public void recordReading(int reading) {
        if (reading<minimum){
        minimum = reading;
        }

        if (reading>maximum){
        maximum = reading;
        }

        average = (average*noOfReadings +reading)/(double)(noOfReadings+1);

        noOfReadings++;
        }



    // Obtain the largest reading taken. Requires numberOfReadings()>0.
    int maximum(){
        return maximum;
    }


    // Obtain the lowest reading taken. Requires numberOfReadings()>0.
    int minimum(){
        return minimum;}


    // Obtain the average of readings taken, rounded to the nearest integer. Requires numberOfReadings()>0.
    int average(){
        return (int)Math.round(average);}


    // Obtain the number of readings which have been taken. Requires numberOfReadings()>0.
    int numberOfReadings(){

        return noOfReadings;}












}
