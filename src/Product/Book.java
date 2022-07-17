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
public class Book extends Product{
    private String category;
    private String publisher ;
    private String author;

    public Book() {
    } 

    public Book(String category, String publisher, String author, String id, String code, String name, long purchasePrice, long salePrice, int remaining, Date addDate, Date updateDate, Employee updater, String productPlacement) {
        super(id, code, name, purchasePrice, salePrice, remaining, addDate, updateDate, updater, productPlacement);
        this.category = category;
        this.publisher = publisher;
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void display() {
        super.display(); 
        System.out.println("Thể loại: "+category );
        System.out.println("Nhà xuất bản:  "+publisher );
        System.out.println("Tác giả: "+author );
        
    }
  
    
       
}
