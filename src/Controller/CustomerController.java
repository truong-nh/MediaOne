/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import database.DB;
import java.util.ArrayList;
import java.util.List;
import mediaone.MediaOne;
import person.Customer;
import person.Employee;

/**
 *
 * @author Admin
 */
public class CustomerController {
    private Employee employee;

    public CustomerController(Employee employee) {
        this.employee = employee;
    }
    
    public List<Customer> getListCustomer(){
       return MediaOne.getListCustomers();
    }
    
    public Customer getCustomerByID(String Id){
       for(Customer customer:this.getListCustomer()){
          if(customer.getId()==Integer.parseInt(Id)){
          return customer;
          }
       }
       return null;
    }
    
    public List<Customer> getCustomerByName(String name){
          List<Customer> list = new ArrayList<>();
          for(Customer customer:this.getListCustomer()){
          if( customer.getName().equals(name) ){
          list.add(customer);
          }
       }
       return list;
    }
    
    public Customer getCustomerByPhone(String phone){
          for(Customer customer:this.getListCustomer()){
          if( customer.getPhone().equals(phone) ){
          return customer;
          }
          }
         return null;
    }
    
    public int getIdCustomer(){
        return this.getListCustomer().size();
    }
    
    public void addCustomer(String name,String Born,String phone ){
         Customer customer = new Customer();
         customer.setId(this.getIdCustomer()+1);
         customer.setName(name);
         customer.setBorn(Integer.parseInt(Born));
         customer.setPhone(phone);
         customer.setPoint(0);
         this.getListCustomer().add(customer);
         DB.addCustomer(customer);
    }
    
}
