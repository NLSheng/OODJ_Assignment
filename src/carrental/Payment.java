package carrental;

import java.util.Date;

public class Payment extends Booking{
    private int paymentID;
    private String paymentDate;

    public Payment() {
    }
    
    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
    
}
