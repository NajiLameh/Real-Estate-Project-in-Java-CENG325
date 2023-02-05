/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class FileAccess {

    public void writeTofile(String fileName, String str) {
        FileWriter fw;
        try {
            fw = new FileWriter(fileName + ".txt", true);
            fw.write(str);
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error in FileWriter");
        }
    }

    public ArrayList<Customer> readCustomers() {
        ArrayList<Customer> Customers = new ArrayList();
        String line;
        String customerInfo[];
        try {
            FileInputStream fs = new FileInputStream("customers.txt");
            InputStreamReader ir = new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while (in.ready()) {
                line = in.readLine();
                customerInfo = line.split("\t");
                Customer c = new Customer(customerInfo[0], customerInfo[1]);
                Customers.add(c);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error in reading from customers file");
        }

        return Customers;
    }

    public ArrayList<Property> readProperties() {
        ArrayList<Property> Properties = new ArrayList();
        String line;
        String PropertyInfo[];
        try {
            FileInputStream fs = new FileInputStream("property.txt");
            InputStreamReader ir = new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while (in.ready()) {
                line = in.readLine();
                PropertyInfo = line.split("\t");
                Property p = new Property(PropertyInfo[0], PropertyInfo[1], PropertyInfo[2], Integer.parseInt(PropertyInfo[3]), Integer.parseInt(PropertyInfo[4]));
                Properties.add(p);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error in reading from property file");
        }

        return Properties;
    }

    public ArrayList<Purchase> readPurchases() {
        ArrayList<Purchase> allpurchases = new ArrayList();
        return allpurchases;
    }

    public String[][] getPropertyInfo(int rowCount, boolean allCountry, boolean city, boolean village) {
        String[][] data = new String[rowCount][5];
        String pInfo[];
        String line = "";
        int row = 0;

        try {
            FileInputStream fs = new FileInputStream("property.txt");
            InputStreamReader ir = new InputStreamReader(fs);
            BufferedReader in = new BufferedReader(ir);
            while (in.ready()) {
                line = in.readLine();
                pInfo = line.split("\t");
                if (allCountry) {
                    data[row][0] = pInfo[0];
                    data[row][1] = pInfo[1];
                    data[row][2] = pInfo[2];
                    data[row][3] = pInfo[3];
                    data[row][4] = pInfo[4];
                }
                
                if (city && pInfo[1].equals("city")) {
                    data[row][0] = pInfo[0];
                    data[row][1] = pInfo[1];
                    data[row][2] = pInfo[2];
                    data[row][3] = pInfo[3];
                    data[row][4] = pInfo[4];
                }
                if (village && pInfo[1].equals("village")) {
                    data[row][0] = pInfo[0];
                    data[row][1] = pInfo[1];
                    data[row][2] = pInfo[2];
                    data[row][3] = pInfo[3];
                    data[row][4] = pInfo[4];
                }
                row++;
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    public void resetfile(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName + ".txt", false);
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error in reseting the file");

        }
    }

}
