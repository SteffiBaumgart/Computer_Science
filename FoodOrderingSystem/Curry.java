/**
 * Created by Baumgart on 2015/09/02.
 */
public class Curry extends Food{
    public String curryType;

    Curry(String menuItemNo, String size, String curryType){
        super(menuItemNo,size);
        this.curryType = curryType;
    }


    public String toString(){
        return "Curry: "+super.getMenuItem() + ", " + super.getSize() + ", "+curryType;
    }



}
