/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import Product.Book;
import java.text.SimpleDateFormat;
import java.util.Date;
import person.Account;
import person.Employee;

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) {
        DB db= new DB();
        Date date = new Date();
        SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = formatter.format(date);
        
//        for(Book book : db.getListBookByCode()){
//            System.out.println(book.getUpdater().getName());
//        }
       Employee employee= db.getEmployee("1");
        
      // book c= new Book(category, publisher, author, id, code, name, 0, 0, 0, addDate, updateDate, employee, productPlacement)
       Book  book = new Book("category", "publisher", "author", "1", "code1", "name1", 2003, 0, 0, date, date, employee, "productPlacement");
      //db.addBook(book);
     // db.updateBook("125125",book);
        System.out.println(db.getEmployeeByUserName("vunn").getName());
    } 
}
