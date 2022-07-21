/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import Controller.BillController;
import Controller.CustomerController;
import Controller.EmployeeController;
import Controller.ProductController;
import Product.Book;
import Product.DiscMovie;
import Product.DiscMusic;
import Product.Product;
import bill.Bill;
import bill.BillType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import mediaone.MediaOne;
import person.Account;
import person.Customer;
import person.Employee;

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) {
       // DB db= new DB();
        Date date = new Date();
        SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = formatter.format(date);
        
//        for(Book book : db.getListBookByCode()){
//            System.out.println(book.getUpdater().getName());
//        }
       Employee employee= DB.getEmployee("1");
       MediaOne mediaOne= new MediaOne();
      // book c= new Book(category, publisher, author, id, code, name, 0, 0, 0, addDate, updateDate, employee, productPlacement)
       Book  book = new Book("category", "publisher", "author", "1", "code1", "name1", 2003, 0, 0, date, date, employee, "productPlacement");
      //db.addBook(book);
     // db.updateBook("125125",book);
      // db.addEmployee(employee);
    //  db.sellBook("test", 2);
//    Bill bill= new Bill();
//       Bill bill = new Bill(new Date(), "12", 3, 4, employee, strDate);
//        db.addBill(bill);
        //  DB.getListBills().size();
         DiscMusic discMusic1 = new DiscMusic("2", "2", "2", "2", "2", 0, 0, 0, date, date, employee, "2");
      //   db.updateDiscMusic("1", discMusic1);
        DiscMovie discMovie1 = new DiscMovie("2", 0, 0, "3", "4", "4", "4", "4", 0, 0, 0, date, date, employee, "2");
//        DB.updateDiscMovie("2",discMovie1);
//         for(DiscMovie discMusic: DB.getliDiscMovie()){
//             System.out.println(discMusic.getUpdater().getName());
//         }
         Customer customer1= new Customer(0, 3, "ngocj",2001 ,"0123456789");
       //  DB.addCustomer(customer1);
       //  DB.updateCustomer("3", customer1);
      //  System.out.println(DB.getListCustomers().size()); 
      //  Bill bill = new Bill();
        ProductController productController= new ProductController(employee);
        EmployeeController employeeController= new EmployeeController(employee);
        BillController billController= new BillController(employee);
      Book book11= productController.getBookByCode("b6");
      CustomerController customerController= new CustomerController(employee);
              Customer customer = customerController.getCustomerByPhone("0");
              Employee employee1= employeeController.getEmployeeByUserName("truong");
              Bill bill = new Bill();
              Map<Product, Integer> productMaps = new LinkedHashMap<Product, Integer>() ;
              productMaps.put(book11, 1);
              bill= billController.addBill(customer, employee, BillType.BUYING);
     //   DB.saveFinance(11112, bill, 0);
        
    } 
}
