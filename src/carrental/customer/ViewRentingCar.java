/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package carrental.customer;

import carrental.Booking;
import carrental.Car;
import carrental.Customer;
import carrental.Payment;
import carrental.auth.Login;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author user
 */
public class ViewRentingCar extends javax.swing.JInternalFrame {

    /**
     * Creates new form RentCar
     */
    public ViewRentingCar() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        TableColumnModel bookTable = bookingTable.getColumnModel();
        bookingTable.removeColumn(bookTable.getColumn(1));
        bookingTable.removeColumn(bookTable.getColumn(1));
        bookingTable.removeColumn(bookTable.getColumn(1));
        bookingTable.removeColumn(bookTable.getColumn(1));
        bookingTable.removeColumn(bookTable.getColumn(4));
        Show_Table();
    }

    private void Show_Table() {
        bookingTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        bookingTable.getTableHeader().setBackground(new Color(0, 0, 0, 150));
        bookingTable.getTableHeader().setForeground(new Color(255, 255, 255));
        bookingTablePane.setOpaque(false);
        bookingTablePane.getViewport().setOpaque(false);
        try {
            DefaultTableModel tableCar = (DefaultTableModel) bookingTable.getModel();
            BufferedReader brBooking = new BufferedReader(new FileReader("booking.txt"));
            Object[] carLines = brBooking.lines().toArray();
            tableCar.setRowCount(0);
            int j = 1;
            for (int i = 0; i < carLines.length; i++) {
                String line = carLines[i].toString().trim();
                String[] row = line.split(",");
                Customer customer = new Customer();
                if (row[1].equals(customer.getUserID()) && row[7].equals("paid")) {
                    String record = j + "," + line;
                    String[] rowRecord = record.split(",");
                    tableCar.addRow(rowRecord);
                    j += 1;
                }
            }
            brBooking.close();
        } catch (Exception ecp) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookingTablePane = new javax.swing.JScrollPane();
        bookingTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(830, 650));
        setPreferredSize(new java.awt.Dimension(830, 624));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookingTablePane.setBackground(new java.awt.Color(255, 255, 255));
        bookingTablePane.setBorder(null);

        bookingTable.setBackground(new java.awt.Color(255, 255, 255, 230));
        bookingTable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        bookingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Booking ID", "Customer ID", "Customer Name", "Car ID", "Car Brand", "Car Model", "Rent Price (day)", "Booking Status", "Rent Out Date", "Return Date", "Total Rent Price"
            }
        ));
        bookingTable.setFocusable(false);
        bookingTable.setGridColor(new java.awt.Color(255, 255, 255));
        bookingTable.setIntercellSpacing(new java.awt.Dimension(0, 1));
        bookingTable.setOpaque(false);
        bookingTable.setRowHeight(35);
        bookingTable.setSelectionBackground(new java.awt.Color(102, 153, 255));
        bookingTable.setShowGrid(true);
        bookingTable.setShowVerticalLines(false);
        bookingTable.getTableHeader().setReorderingAllowed(false);
        bookingTablePane.setViewportView(bookingTable);

        getContentPane().add(bookingTablePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 810, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookingTable;
    private javax.swing.JScrollPane bookingTablePane;
    // End of variables declaration//GEN-END:variables
}
