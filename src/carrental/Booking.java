/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrental;

import carrental.admin.ManageBooking;
import carrental.admin.ManageCar;
import carrental.customer.RentCar;
import carrental.customer.ViewAllCar;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Booking {

    private String bookingID;
    private Customer customer;
    private Car car;
    private String bookingStatus;
    private String rentOutDate;
    private String returnDate;
    private String totalRentPrice;

    public Booking() {

    }

    public Booking(String bookingID) {
        this.bookingID = bookingID;
    }

    public Booking(String bookingID, String totalRentPrice) {
        this.bookingID = bookingID;
        this.totalRentPrice = totalRentPrice;
    }

    public Booking(String bookingStatus, String rentOutDate, String returnDate, String totalRentPrice) {
        this.bookingStatus = bookingStatus;
        this.rentOutDate = rentOutDate;
        this.returnDate = returnDate;
        this.totalRentPrice = totalRentPrice;
    }

    public String getTotalRentPrice() {
        return totalRentPrice;
    }

    public void setTotalRentPrice(String totalRentPrice) {
        this.totalRentPrice = totalRentPrice;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getRentOutDate() {
        return rentOutDate;
    }

    public void setRentOutDate(String rentOutDate) {
        this.rentOutDate = rentOutDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void updateBookingStatus(String bookingStatus) {
        ArrayList<String> recordList = new ArrayList<>();
        try {

            BufferedReader brFile = new BufferedReader(new FileReader("booking.txt"));
            String record;
            while ((record = brFile.readLine()) != null) {
                String[] row;
                row = record.split(",");
                if (row[0].equals(bookingID)) {
                    recordList.add(row[0] + "," + row[1] + "," + row[2] + "," + row[3] + "," + row[4] + "," + row[5] + "," + row[6] + "," + bookingStatus + "," + row[8] + "," + row[9] + "," + row[10]);
                } else {
                    recordList.add(record);
                }
            }
            brFile.close();
            
            PrintWriter pwFile = new PrintWriter(new BufferedWriter(new FileWriter("booking.txt")));
            for (String line : recordList) {
                pwFile.println(line);
            }
            pwFile.close();
        } catch (IOException ex) {
            System.out.println("Something went wrong!");
        }
    }

}
