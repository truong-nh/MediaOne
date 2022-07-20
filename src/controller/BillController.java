/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bill.Bill;
import database.DB;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mediaone.MediaOne;
import order.BillType;
import order.Order;
import person.Employee;
import product.Product;

/**
 *
 * @author Admin
 */
public class BillController {
    private Employee employee;
    
    public BillController(Employee employee) {
        this.employee = employee;
    }
    
    public int getIdBill(){
          return MediaOne.getIdBill();
    }
    public List<Bill> getListBills(){
          return MediaOne.getListBill();
    }
   
    public void addBill(String type, long value,  String note){
        Bill bill= new Bill();
        bill.setDate(new Date());
        bill.setType(type);
        bill.setId(this.getIdBill() + 1);
        bill.setValue(value);
        bill.setEmployee(employee);
        bill.setNote(note);

        MediaOne.getListBill().add(bill);
        DB.addBill(bill);
    }


    //todo: need control transaction
    public void payOrder(Order order) {
        Map<Product, Integer> productMaps = order.getListProducts();
        List<String> productNotEnough = checkProductExist(order);
        if (productNotEnough.size() == 0) {
            long orderValue = calculateOrder(productMaps);
            long shopFinance = DB.getFinance(new Date().getTime());
            if (BillType.BUYING.equals(order.getType())) {
                if (shopFinance > orderValue) {
                    DB.saveFinance(shopFinance - orderValue);
                }
            } else {
                DB.saveFinance(shopFinance + orderValue);
            }
        }
        //todo: update products
    }


    long calculateOrder(Map<Product, Integer> productMaps) {
        long result = 0;
        Set<Product> products = productMaps.keySet();
        for (Product product : products) {
            result += product.getSalePrice() * productMaps.get(product);
        }
        return result;
    }

    List<String> checkProductExist(Order order) {
        Map<Product, Integer> productMaps = order.getListProducts();
        Set<Product> products = productMaps.keySet();
        List<String> result = new ArrayList<>();
        if (BillType.SELLING.equals(order.getType())) {
            for (Product product : products) {
                if (product.getRemaining() < productMaps.get(product)) {
                    result.add(product.getName());
                }
            }
        }
        return result;
    }

    void updateProductAfterPay(Order order) {
        Map<Product, Integer> productMaps = order.getListProducts();
        Set<Product> products = productMaps.keySet();
        for (Product product : products) {
            if (BillType.BUYING.equals(order.getType())) {
                product.setRemaining(product.getRemaining() + productMaps.get(product));
            } else {
                product.setRemaining(product.getRemaining() - productMaps.get(product));
            }
            //todo: db update
        }
    }
}
