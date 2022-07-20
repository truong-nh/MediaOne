/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import product.Book;
import product.DiscMusic;
import database.DB;
import java.text.SimpleDateFormat;
import java.util.Date;
import mediaone.MediaOne;
import person.Employee;

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) {
        DB db = new DB();
        Employee employee=  db.getEmployee("1");
        ProductController productController= new ProductController(employee);
        EmployeeController employeeController= new EmployeeController(employee);
                    BillController billController= new BillController(employee);

        Date date = new Date();
        SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = formatter.format(date);
        MediaOne mediaOne = new  MediaOne();
//      // book c= new Book(category, publisher, author, id, code, name, 0, 0, 0, addDate, updateDate, employee, productPlacement)
       Book  book1 = new Book("category", "publisher", "1234567", "11253", "code1", "name1", 2003, 0, 0, date, date, employee, "productPlacement");
 //       productController.sellBook("truonh", 2);
        
//         productController.updateBook("test", "10", "10", "10", "5", "5", "5", "5", "5");
  //       employeeController.addEmployee("3000", "Hùng", "123456789", "2002", "hunggv", "123456", "employee");
   //        employeeController.updateEmployee("truongnh", "200202");
    //        productController.sellBook("test", 5);
   //     billController.addBill("thu", 10000, "");
                 DiscMusic discMusic1 = new DiscMusic("2", "2", "2", "2", "2", 0, 0, 0, date, date, employee, "2");
          
               //  productController.addDiscMusic("11", "22", "33", "1", "1", "1", "1", "1");
//                 for(Book book : productController.getBooksByName("bbbd")){
//                     System.out.println(book.getCode());
//                 }
//              DiscMovie discMovie1 = new DiscMovie("2", 0, 0, "2", "2", "2", "2", "2", 0, 0, 0, date, date, employee, "2");
//              productController.sellDiscMusic("22", 4);
//              System.out.println(productController.getDiscMusicByCode("22").getRemaining());
}
    
}
