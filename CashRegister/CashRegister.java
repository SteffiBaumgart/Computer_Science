/**
 * Created by Baumgart on 2015/08/03.
 */



public class CashRegister {
    public double total = 0.00;
    public double changeDue = 0.00;
    public double paid = 0.00;


    public double Item(double itemPrice) {
    total += itemPrice;

        return total;
    }

    public double Tender(double amountTendered){
     paid += amountTendered;
     return amountTendered;
    }



    public double Change(){
      changeDue = paid - total;

      return changeDue;
    }


    public double runningTotal(){

      return total;
    }


    public void clearValues(){
        total = 0.00;
        changeDue = 0.00;
        paid = 0.00;

    }


}
