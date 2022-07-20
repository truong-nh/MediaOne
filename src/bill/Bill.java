/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bill;

import java.util.Date;
import person.Employee;

/**
 *
 * @author Admin
 */
public  class Bill {
    private Date date;
    private String type;
    private int id;
    private long value;
    private Employee employee;
    private String note; 

    public Bill(Date date, String type, int id, long value, Employee employee, String note) {
        this.date = date;
        this.type = type;
        this.id = id;
        this.value = value;
        this.employee = employee;
        this.note = note;
    }

    public Bill() {
    }

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}
