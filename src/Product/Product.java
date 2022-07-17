/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Product;

import java.util.Date;
import person.Employee;
import person.Person;

/**
 *
 * @author Admin
 */
public abstract class Product  {
    private String id;// tự tạo
    private String code;
    private String name;
    private long purchasePrice;
    private long salePrice;
    private int remaining;
    private Date addDate; // là thời gian tạo
    private Date updateDate; // khởi tạo để null
    private Employee updater;// Khởi tạo để null
    private String productPlacement;

    public Product(String id, String code, String name, long purchasePrice, long salePrice, int remaining, Date addDate, Date updateDate, Employee updater, String productPlacement) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.remaining = remaining;
        this.addDate = addDate;
        this.updateDate = updateDate;
        this.updater = updater;
        this.productPlacement = productPlacement;
    }


    public Product() {
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(long salePrice) {
        this.salePrice = salePrice;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Employee getUpdater() {
        return updater;
    }
    
    public void setUpdater(Employee updater) {
        this.updater = updater;
    }
    

    public String getProductPlacement() {
        return productPlacement;
    }

    public void setProductPlacemernt(String productPlacement) {
        this.productPlacement = productPlacement;
    }
    public void display() {
        System.out.println("------Thong tin san pham " +code+" --------" );
        System.out.println("ID san pham:" + id);
        System.out.println("Ma san pham:  " + code);
        System.out.println("Ten san pham:  " + name);
        System.out.println("Gia nhap:  " + purchasePrice);
        System.out.println("Gia ban:  " + salePrice);
        System.out.println("So luong:  " + remaining);
        System.out.println("Thoi gian nhap san pham:  " + addDate);
        System.out.println("Thoi gian cap nhat san pham:  " + updateDate);
        System.out.println("Nguoi cap nhat: " + updater);
        System.out.println("Vi tri dat san pham:  " + productPlacement);      
    }
}
