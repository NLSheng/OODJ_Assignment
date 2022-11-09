package carrental;

import carrental.admin.AdminMain;
import carrental.auth.Login;
import carrental.customer.CustomerMain;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class User {

    private static String userID;
    private static String userName;
    private String userEmail;
    private String userPassword;

    public User() {
    }

    public User(String userID, String userName, String userEmail, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public User(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
    
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void login(String email, String password) {
        try {
            PrintWriter pwCustomer = new PrintWriter(new BufferedWriter(new FileWriter("customer.txt", true)));
            BufferedReader brCustomer = new BufferedReader(new FileReader("customer.txt"));
            String record;
            boolean customerLogin = false;
            String customerID = null;
            String customerName = null;
            while ((record = brCustomer.readLine()) != null) {
                String[] row;
                row = record.split(",");
                if (row[2].equals(email) && row[3].equals(password)) {
                    customerLogin = true;
                    customerID = row[0];
                    customerName = row[1];
                    break;
                }
            }

            boolean adminLogin = false;
            Admin admin = new Admin("admin", "admin");
            if (admin.getUserEmail().equals(email) && admin.getUserPassword().equals(password)) {
                adminLogin = true;
            }
            
            if (customerLogin) {
                CustomerMain main = new CustomerMain();
                setUserID(customerID);
                setUserName(customerName);
                main.setVisible(true);
                main.setLocationRelativeTo(null);
            } else if (adminLogin) {
                AdminMain main = new AdminMain();
                main.setVisible(true);
                main.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Email or Password");
            }

        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
