/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
public class Purchase {

    private String propertyName;
    private String customerName;

    public Purchase(String propertyName, String customerName) {
        this.propertyName = propertyName;
        this.customerName = customerName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return propertyName + "\t" + customerName;
    }

}
