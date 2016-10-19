/**
 * Created by Baumgart on 2015/09/02.
 */
public class Pizza  extends Food{
    public String Base;
    public String extraCheese;
    public String extraGarlic;


    Pizza(String menuItemNo, String size,String Base, String extraCheese, String extraGarlic){
        super(menuItemNo,size);
        this.Base = Base;
        this.extraCheese = extraCheese;
        this.extraGarlic = extraGarlic;
    }


    public String toString() {
        return "Pizza: " +super.getMenuItem() + ", " + super.getSize() +", " + Base + ", "+ extraCheese + ", " + extraGarlic;
    }



}
