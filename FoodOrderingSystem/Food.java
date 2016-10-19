/**
 * Created by Baumgart on 2015/09/02.
 */
public class Food {
    public String  menuItemNo;
    public String size;

    Food(){}

    Food(String  menuItemNo, String size){
        this.menuItemNo = menuItemNo;
        this.size = size;
    }

    /*public String toString() {
        return menuItemNo + ", " + size + ", ";
    }*/

    public String getMenuItem() {
        return menuItemNo;
    }
    public String getSize() {
        return size;
    }

}
