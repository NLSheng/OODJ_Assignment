package carrental;

import carrental.admin.EditCar;
import carrental.admin.ManageBooking;
import carrental.admin.ManageCar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin extends User {

    Booking booking;
    Car car;

    public Admin() {
    }

    public Admin(String userEmail, String userPassword) {
        super(userEmail, userPassword);
    }

    public Admin(Booking booking) {
        this.booking = booking;
    }

    public Admin(Car car) {
        this.car = car;
    }

    public Admin(String userID, String userName, String userEmail, String userPassword) {
        super(userID, userName, userEmail, userPassword);
    }

    public void createCar() {
        String uuid = UUID.randomUUID().toString();
        String[] row;
        row = uuid.split("-");
        car.setCarID(row[0]);
        car.setCarStatus("Available");
        try {
            if (car.getCarBrand().isEmpty() || car.getCarModel().isEmpty() || car.getCarColor().isEmpty() || car.getCarYear().isEmpty() || car.getCarRentPrice().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill up all details");
            } else {
                PrintWriter pwCar = new PrintWriter(new BufferedWriter(new FileWriter("car.txt", true)));
                JOptionPane.showMessageDialog(null, "New Car Added");
                pwCar.print(car.getCarID() + "," + car.getCarBrand() + "," + car.getCarModel() + "," + car.getCarColor() + "," + car.getCarYear() + "," + car.getCarRentPrice() + "," + car.getCarStatus() + "\n");
                pwCar.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editCar(EditCar editCar) {

        ArrayList<String> carList = new ArrayList<>();
        try {
            if (car.getCarBrand().isEmpty() || car.getCarModel().isEmpty() || car.getCarColor().isEmpty() || car.getCarYear().isEmpty() || car.getCarRentPrice().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill up all car detail");
            } else {
                BufferedReader brCar = new BufferedReader(new FileReader("car.txt"));
                String record;
                while ((record = brCar.readLine()) != null) {
                    String[] row;
                    row = record.split(",");
                    if (row[0].equals(car.getCarID())) {
                        carList.add(row[0] + "," + car.getCarBrand() + "," + car.getCarModel() + "," + car.getCarColor() + "," + car.getCarYear() + "," + car.getCarRentPrice() + "," + row[6]);
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

                JOptionPane.showMessageDialog(editCar, "Update Successfully!");

                ManageCar manageCar = new ManageCar();
                manageCar.setVisible(true);
                editCar.dispose();
            }
        } catch (Exception e) {
            System.out.println("2");
        }

    }

    public void deleteCar(javax.swing.JTable carTable, ManageCar manageCar) {
        ArrayList<String> carList = new ArrayList<>();
        try {
            if (carTable.getSelectedRowCount() == 1) {
                DefaultTableModel tableCar = (DefaultTableModel) carTable.getModel();
                int i = carTable.getSelectedRow();
                String carID = tableCar.getValueAt(i, 1).toString();
                String carBrand = tableCar.getValueAt(i, 2).toString();
                String carModel = tableCar.getValueAt(i, 3).toString();
                String carColor = tableCar.getValueAt(i, 4).toString();
                String carYear = tableCar.getValueAt(i, 5).toString();
                String carPrice = tableCar.getValueAt(i, 6).toString();
                String carStatus = tableCar.getValueAt(i, 7).toString();

                if (carStatus.equals("unavailable")) {
                    JOptionPane.showMessageDialog(manageCar, "Check In Customer should not be deleted");
                } else {
                    int response = JOptionPane.showConfirmDialog(manageCar, "Confirm Delete?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        BufferedReader brCar = new BufferedReader(new FileReader("car.txt"));
                        String record;
                        while ((record = brCar.readLine()) != null) {
                            String[] row;
                            row = record.split(",");
                            if (!row[0].equals(carID)) {
                                carList.add(record);
                            }
                        }
                        brCar.close();

                        PrintWriter pwCar = new PrintWriter(new BufferedWriter(new FileWriter("car.txt")));
                        for (String line : carList) {
                            pwCar.println(line);
                        }
                        pwCar.close();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(manageCar, "Please select a record to delete");
            }
        } catch (Exception ecp) {
            System.out.println("Something went Wrong");
        }
    }

    public void confirmBooking(ManageBooking manageBooking) {
        int response = JOptionPane.showConfirmDialog(manageBooking, "Confirm Booking?", "confirmed", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            booking.updateBookingStatus("confirmed");
            JOptionPane.showMessageDialog(manageBooking, "Booking Confirm!");
        }
    }

    public void rejectBooking(ManageBooking manageBooking) {
        int response = JOptionPane.showConfirmDialog(manageBooking, "Reject Booking?", "reject", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            booking.updateBookingStatus("rejected");
            JOptionPane.showMessageDialog(manageBooking, "Booking Canceled!");
        }

    }

}
