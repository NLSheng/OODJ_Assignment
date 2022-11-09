package carrental;

import carrental.admin.EditCar;
import carrental.admin.ManageCar;
import carrental.admin.ManageCar;
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
import javax.swing.table.DefaultTableModel;

public class Car {

    private String carYear;
    private String carID, carBrand, carModel, carColor, carStatus;
    private String carRentPrice;

    public Car() {
    }

    public Car(String carID, String carBrand, String carModel) {
        this.carID = carID;
        this.carBrand = carBrand;
        this.carModel = carModel;
    }

    public Car(String carBrand, String carModel, String carColor, String carYear, String carRentPrice) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carYear = carYear;
        this.carRentPrice = carRentPrice;
    }

    public Car(String carID, String carBrand, String carModel, String carColor, String carYear, String carRentPrice) {
        this.carID = carID;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carRentPrice = carRentPrice;
        this.carYear = carYear;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarRentPrice() {
        return carRentPrice;
    }

    public void setCarRentPrice(String carRentPrice) {
        this.carRentPrice = carRentPrice;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }


}
