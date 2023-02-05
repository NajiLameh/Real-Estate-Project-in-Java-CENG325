/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
public class Property {

    private String name;
    private String location;
    private String size;
    private int nbOfRooms;
    private int price;

    public Property(String name, String location, String size, int nbOfRooms, int price) {
        this.name = name;
        this.location = location;
        this.size = size;
        this.nbOfRooms = nbOfRooms;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getSize() {
        return size;
    }

    public int getNbOfRooms() {
        return nbOfRooms;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setNbOfRooms(int nbOfRooms) {
        this.nbOfRooms = nbOfRooms;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "\t" + location + "\t" + size + "\t" + nbOfRooms + "\t" + price;
    }

}
