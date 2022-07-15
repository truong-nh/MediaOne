/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

/**
 *
 * @author Admin
 */
public class Customer extends Person {
    private int point;

    public Customer(int point, String name, int born, String phone) {
        super(name, born, phone);
        this.point = point;
    }

    public Customer() {
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
     
    
    
}
