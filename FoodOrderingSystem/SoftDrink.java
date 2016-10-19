/**
 * Created by Baumgart on 2015/09/02.
 */
public class SoftDrink extends Food {
    public String flavour;
    public String container;


    SoftDrink(String menuItemNo, String size, String flavour, String container){
        super(menuItemNo,size);
        this.flavour = flavour;
        this.container = container;
    }

    public String toString() {
        return	"Soft Drink: "+super.getMenuItem()+ ", "+super.getSize() + ", "+ flavour + ", " + container;
    }
}
