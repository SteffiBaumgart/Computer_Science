/**
 * Created by Baumgart on 2015/09/16.
 */


public class SoftDrink implements Comparable<SoftDrink> {


    private String name;
    private String colour;
    private double volume;


    public SoftDrink(String name, String colour, double volume) {
        this.name = name;
        this.colour = colour;
        this.volume = volume;

    }

    @Override
    public int compareTo(SoftDrink pther) {

        if (this.name.compareTo(other.name) == 0)


            if (this.colour.compareTo(s.colour) == 0) {


                if (this.volume == (s.volume))
                    return 0;

                else if ((this.volume) > (s.volume))
                    return 1;
                else
                    return -1;           }

            else if (this.colour.compareTo(s.colour) > 0)
                    return 1;
            else
                return -1;

        else if(this.name.compareTo(s.name) > 0){
                return 1;
        } else
            return -1;


    }



    @Override
    public String toString() {
        return "" + name + " " + colour + " " + String.format("%.0f",volume);
    }

}


