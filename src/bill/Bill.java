/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bill;

import Product.Product;
import java.util.Map;
import person.Customer;
import person.Employee;

/**
 *
 * @author Admin
 */
public  class Bill {
    private long time;
    private BillType type;
    private int id;
    private long value;
    private Employee employee;
    Map<Product, Integer> productMaps;
    private Customer customer;
    private boolean valid;

    public long getTime() {
        return time;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public BillType getType() {
        return type;
    }

    public void setType(BillType type) {
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

    public Map<Product, Integer> getProductMaps() {
        return productMaps;
    }

    public void setProductMaps(Map<Product, Integer> productMaps) {
        this.productMaps = productMaps;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
