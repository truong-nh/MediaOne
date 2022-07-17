/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Product.Book;
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
        
        Date date = new Date();
        SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = formatter.format(date);
        
//      // book c= new Book(category, publisher, author, id, code, name, 0, 0, 0, addDate, updateDate, employee, productPlacement)
//       Book  book = new Book("category", "publisher", "1234567", "11253", "code1", "name1", 2003, 0, 0, date, date, employee, "productPlacement");
//       productController.addBook("bay vien ngoc rong", "BVNRR", "15","21", "30", "40", "50", "60", "60");
         
//         productController.updateBook("test", "10", "10", "10", "5", "5", "5", "5", "5");
  //       employeeController.addEmployee("3000", "Hùng", "123456789", "2002", "hunggv", "123456", "employee");
   //        employeeController.updateEmployee("truongnh", "200202");
    }
}
