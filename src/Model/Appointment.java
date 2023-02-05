/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
public class Appointment {

    private String propertyName;
    private String customerName;
    private String date;

    public Appointment(String propertyName, String customerName, String date) {
        this.propertyName = propertyName;
        this.customerName = customerName;
        this.date = date;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return date;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return propertyName + "\t" + customerName + "\t" + date;
    }

}
