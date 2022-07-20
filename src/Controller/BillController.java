/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Product.Product;
import bill.Bill;
import database.DB;
import java.util.Date;
import java.util.List;
import java.util.Map;
import mediaone.MediaOne;
import person.Customer;
import person.Employee;

/**
 *
 * @author Admin
 */
public class BillController {
    private Employee employee;
    
    public BillController(Employee employee) {
        this.employee = employee;
    }
    
    public int getIdBill() {
        int max=0;
        for(Bill bill :MediaOne.getListBill()){
           if(bill.getId()>max){
           max=bill.getId();
           }
        }
        return max;
    }
    public List<Bill> getListBills(){
          return MediaOne.getListBill();
    }
   
    public void addBill(String type, long value,  String note){
        Bill bill= new Bill();
        bill.setDate(new Date());
        bill.setType(type);
        bill.setId(this.getIdBill()+1);
        bill.setValue(value);
        bill.setEmployee(employee);
        bill.setNote(note);
        
        MediaOne.getListBill().add(bill);
        DB.addBill(bill);
    }
}
