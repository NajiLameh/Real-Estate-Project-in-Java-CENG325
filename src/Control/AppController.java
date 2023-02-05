/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.*;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class AppController {

    FileAccess fa;

    public AppController() {
        fa = new FileAccess();
    }

    public boolean AddCustomer(String userName, String password) {
        ArrayList<Customer> Customers = fa.readCustomers();

        for (int i = 0; i < Customers.size(); i++) {
            if (Customers.get(i).getName().equals(userName)) {
                return false;
            }
        }
        Customer c = new Customer(userName, password);
        fa.writeTofile("customers", c.toString() + "\n");
        return true;
    }

    public void RemoveCustomer(String name) {
        ArrayList<Customer> Customers = new ArrayList();
        Customers = fa.readCustomers();
        for (int i = 0; i < Customers.size(); i++) {
            if (Customers.get(i).getName().equals(name)) {
                Customers.remove(i);
            }
        }
        fa.resetfile("customers");
        for (int i = 0; i < Customers.size(); i++) {
            fa.writeTofile("customers", Customers.get(i).toString() + "\n");
        }

    }

    public boolean checkCustomer(String userName, String password) {
        boolean exist = false;
        ArrayList<Customer> Customers = new ArrayList();
        Customers = fa.readCustomers();

        for (int i = 0; i < Customers.size(); i++) {
            if (Customers.get(i).getName().equals(userName) && Customers.get(i).getPassword().equals(password)) {
                exist = true;
            }
        }
        return exist;
    }

    public String PrintAllCustomers() {
        String customers = "";
        ArrayList<Customer> Customers = new ArrayList();
        Customers = fa.readCustomers();
        for (int i = 0; i < Customers.size(); i++) {
            customers += Customers.get(i).toString() + "\n";
        }
        return customers;
    }

    /*-----------------------------------------------------------------------------*/
    public void AddProperty(String propertyName, String location, String size, int nbOfRooms, int price) {
        Property p = new Property(propertyName, location, size, nbOfRooms, price);
        fa.writeTofile("property", p.toString() + "\n");
    }

    public ArrayList<Property> getAllProperties() {
        ArrayList<Property> Properties = new ArrayList();
        Properties = fa.readProperties();
        return Properties;

    }

    public void RemoveProperty(String name) {
        ArrayList<Property> Properties = new ArrayList();
        Properties = fa.readProperties();
        for (int i = 0; i < Properties.size(); i++) {
            if (Properties.get(i).getName().equals(name)) {
                Properties.remove(i);
            }
        }
        fa.resetfile("property");
        for (int i = 0; i < Properties.size(); i++) {
            fa.writeTofile("property", Properties.get(i).toString() + "\n");
        }

    }

    public String[][] getPropertyData(boolean allCountry, boolean city, boolean village) {
        int row = fa.readProperties().size();
        String[][] data = fa.getPropertyInfo(row, allCountry, city, village);
        return data;
    }

    public String PrintAllProperties() {
        String properties = "";
        ArrayList<Property> Properties = new ArrayList();
        Properties = fa.readProperties();
        for (int i = 0; i < Properties.size(); i++) {
            properties += Properties.get(i).toString() + "\n";
        }
        return properties;
    }

    public void addAppointment(String propertyName, String customerName, String date) {
        Appointment a = new Appointment(propertyName, customerName, date);
        fa.writeTofile("appointment", a.toString() + "\n");
    }

    public void BuyProperty(String PropertyName, String customerName) {

        Purchase p = new Purchase(PropertyName, customerName);
        fa.writeTofile("purchase", p.toString() + "/n");

        ArrayList<Property> Properties = new ArrayList();
        Properties = fa.readProperties();
        for (int i = 0; i < Properties.size(); i++) {
            if (Properties.get(i).getName().equals(PropertyName)) {
                Properties.remove(i);
            }
        }
        fa.resetfile("property");
        for (int i = 0; i < Properties.size(); i++) {
            fa.writeTofile("property", Properties.get(i).toString() + "\n");
        }
    }

}
