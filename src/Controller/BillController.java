/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Product.*;
import bill.Bill;
import bill.BillType;
import database.DB;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    /**
     * Tao don hang
     * @param customer
     * @param employee
     * @param type
     * @return
     */
    public Bill addBill(Customer customer, Employee employee, BillType type){
        Bill bill= new Bill();
        bill.setType(type);
        bill.setId(this.getIdBill()+1);
        bill.setEmployee(employee);
        bill.setCustomer(customer);
        return bill;
    }

    /**
     * Them hang vao don hang
     * @param bill
     * @param productMaps
     * @return
     */
    public Bill addItemToBill(Bill bill, Map<Product, Integer> productMaps){
        bill.setProductMaps(productMaps);
        return bill;
    }

    public Bill calculateBill(Bill bill){
        if (checkBillValid(bill)) {
            bill.setValid(true);
            bill.setValue(calculateBillValue(bill.getProductMaps()));
        } else {
            bill.setValid(false);
        }
        return bill;
    }

    /**
     * Tinh toan gia tri don hang
     * @param maps
     * @return
     */
    public long calculateBillValue(Map<Product, Integer> maps){
        Set<Product> products = maps.keySet();
        long result = 0;
        for (Product product : products){
            result += product.getSalePrice()*maps.get(product);
        }
        return result;
    }

    public boolean checkBillValid(Bill bill){
        Map<Product, Integer> productMaps = bill.getProductMaps();
        Set<Product> products = productMaps.keySet();
        if (BillType.SELLING.equals(bill.getType())) {
            for (Product product: products) {
                if (product.getRemaining() < productMaps.get(product))
                    return false;
            }
        }
        return true;
    }

    /**
     * Thanh toan
     * @param bill
     * @return
     */
    public boolean pay(Bill bill){
        long moneyEnable = DB.getFinance(new Date().getTime());
        if (BillType.BUYING.equals(bill.getType())){
            if (moneyEnable > bill.getValue()) {
                DB.saveFinance(moneyEnable - bill.getValue(), bill, 0);
            } else {
                System.out.println("Your balance no enough!");
                return false;
            }
        } else {
            DB.saveFinance(moneyEnable + bill.getValue(), bill, 0);
        }
        updateProducts(bill);
        return true;
    }

    private void updateProducts(Bill bill){
        Map<Product, Integer> maps = bill.getProductMaps();
        Set<Product>products = maps.keySet();
        if (BillType.BUYING.equals(bill.getType())) {
            for (Product product : products) {
                product.setRemaining(product.getRemaining() + maps.get(product));
                if(product instanceof Book){
                    DB.updateBook(product.getCode(), (Book) product);
                } else if (product instanceof DiscMovie) {
                    DB.updateDiscMovie(product.getCode(), (DiscMovie) product);
                } else {
                    DB.updateDiscMusic(product.getCode(), (DiscMusic) product);
                }
            }
        } else {
            for (Product product : products) {
                product.setRemaining(product.getRemaining() - maps.get(product));
                if(product instanceof Book){
                    DB.updateBook(product.getCode(), (Book) product);
                } else if (product instanceof DiscMovie) {
                    DB.updateDiscMovie(product.getCode(), (DiscMovie) product);
                } else {
                    DB.updateDiscMusic(product.getCode(), (DiscMusic) product);
                }
            }
        }
    }
}
