package carrental;

import carrental.customer.RentCar;
import carrental.customer.ViewPayment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Customer extends User {

    Booking booking;
    Payment payment;
    Car car;

    public Customer() {
    }

    public Customer(Booking booking) {
        this.booking = booking;
    }

    public Customer(Booking booking, Payment payment, Car car, String userID, String userName) {
        super(userID, userName);
        this.booking = booking;
        this.payment = payment;
        this.car = car;
    }

    public Customer(Car car, Booking booking) {  
        this.car = car;
        this.booking = booking;
    }
    
    
    public Customer(String userID, String userName, String userEmail, String userPassword, Booking booking) {
        super(userID, userName, userEmail, userPassword);
        this.booking = booking;
    }

    public void register(String customerName, String customerEmail, String customerPassword, String customerPasswordConfirm) {
        try {
            if (!customerPassword.equals(customerPasswordConfirm)) {
                JOptionPane.showMessageDialog(null, "Password does not match");
            } else if (customerName.isEmpty() || customerEmail.isEmpty() || customerPassword.isEmpty() || customerPasswordConfirm.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill up all details");
            } else {
                String uuid = UUID.randomUUID().toString();
                String[] row2;
                row2 = uuid.split("-");
                String customerID = row2[0];

                PrintWriter pwCustomer = new PrintWriter(new BufferedWriter(new FileWriter("customer.txt", true)));
                BufferedReader brCustomer = new BufferedReader(new FileReader("customer.txt"));
                String record;
                boolean exist = false;
                while ((record = brCustomer.readLine()) != null) {
                    String[] row;
                    row = record.split(",");
                    System.out.println(row[0]);
                    if (row[1].equals(customerEmail)) {
                        exist = true;
                    }
                }
                if (!exist) {
                    JOptionPane.showMessageDialog(null, "Create Account Successful");
                    pwCustomer.print(customerID + "," + customerName + "," + customerEmail + "," + customerPassword + "\n");
                    pwCustomer.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Username is Exist");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void makePayment(ViewPayment viewPayment) {

        try {
            int response = JOptionPane.showConfirmDialog(viewPayment, "Make Payment?", "confirmed", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                
                booking.updateBookingStatus("paid");

                String uuid = UUID.randomUUID().toString();
                String[] row2;
                row2 = uuid.split("-");
                String paymentID = row2[0];

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
                Date date = new Date();
                String paymentDate = simpleDateFormat.format(date);

                PrintWriter pwPayment = new PrintWriter(new BufferedWriter(new FileWriter("payment.txt", true)));
                pwPayment.print(paymentID + "," + paymentDate + "," + booking.getBookingID() + "," + booking.getTotalRentPrice() + "," + car.getCarID() + "," + car.getCarBrand() + "," + car.getCarModel() + "," + getUserID() + "," + getUserName() + "\n");
                pwPayment.close();

                JOptionPane.showMessageDialog(viewPayment, "Payment Completed!");
            }
        } catch (Exception ecp) {
            System.out.println("Something went Wrong");
        }
    }

    public void rentCar(RentCar rentCar) {

        ArrayList<String> carList = new ArrayList<>();
        try {
            int response = JOptionPane.showConfirmDialog(rentCar, "Confirm Renting?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                String uuid = UUID.randomUUID().toString();
                String[] row2;
                row2 = uuid.split("-");
                booking.setBookingID(row2[0]);
                BufferedReader brCar = new BufferedReader(new FileReader("car.txt"));
                String record;
                while ((record = brCar.readLine()) != null) {
                    String[] row;
                    row = record.split(",");
                    if (row[0].equals(car.getCarID())) {
                        carList.add(row[0] + "," + row[1] + "," + row[2] + "," + row[3] + "," + row[4] + "," + row[5] + "," + "Unavailable");
                    } else {
                        carList.add(record);
                    }
                }
                brCar.close();

                PrintWriter pwCar = new PrintWriter(new BufferedWriter(new FileWriter("car.txt")));
                for (String line : carList) {
                    pwCar.println(line);
                }
                pwCar.close();

                PrintWriter pwBooking = new PrintWriter(new BufferedWriter(new FileWriter("booking.txt", true)));
                pwBooking.print(booking.getBookingID() + "," + getUserID() + "," + getUserName() + "," + car.getCarID() + "," + car.getCarBrand() + "," + car.getCarModel() + "," + car.getCarRentPrice() + "," + booking.getBookingStatus() + "," + booking.getRentOutDate() + "," + booking.getReturnDate() + "," + booking.getTotalRentPrice() + "\n");
                pwBooking.close();

                JOptionPane.showMessageDialog(rentCar, "Your renting request is pending! Check Notification whether your renting request is success or fail within 1 to 4 working hours");
            }

        } catch (Exception ecp) {
            System.out.println("Something went Wrong");
        }
    }

}
