/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Product.Book;
import Product.DiscMovie;
import Product.DiscMusic;
import database.DB;
import java.text.SimpleDateFormat;
import java.util.Date;
import mediaone.MediaOne;
import person.Customer;
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
        CustomerController customerController= new CustomerController(employee);
        Date date = new Date();
        SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = formatter.format(date);
        MediaOne mediaOne = new  MediaOne();
        MediaOne.setListBook(DB.getListBook());
//      // book c= new Book(category, publisher, author, id, code, name, 0, 0, 0, addDate, updateDate, employee, productPlacement)
       Book  book1 = new Book("category", "publisher", "1234567", "11253", "code1", "name1", 2003, 0, 0, date, date, employee, "productPlacement");
       // productController.sellBook(" protruonh", 2);
      //  System.out.println( formatter.format(date));
            //   System.out.println(ductController.getBookByCode("truonh").getRemaining());
              //      productController.addBook("2", "2", "2", "2", "2", "2", "2", "2", "2");

//               for(Book book : productController.getListBook()){
//                     System.out.println(book.getId());
//                 }
//         productController.updateBook("test", "10", "10", "10", "5", "5", "5", "5", "5");
  //       employeeController.addEmployee("3000", "Hùng", "123456789", "2002", "hunggv", "123456", "employee");
   //        employeeController.updateEmployee("truongnh", "200202");
    //        productController.sellBook("test", 5);
   //     billController.addBill("thu", 10000, "");
                 DiscMusic discMusic1 = new DiscMusic("3", "3", "3", "3", "3", 3, 3, 3, date, date, employee, "3");
          
               //  productController.addDiscMusic("11", "22", "33", "1", "1", "1", "1", "1");
//                 for(Book book : productController.getBooksByName("bbbd")){
//                     System.out.println(book.getCode());
//                 }
//              DiscMovie discMovie1 = new DiscMovie("2", 3, 3, "2", "2", "2", "2", "2", 3, 3, 3, date, date, employee, "2");
   //          productController.sellDiscMovie("2", 4);
              //System.out.println(productController.getDiscMovieByCode("2").getRemaining());
     //         System.out.println(customerController.getCustomerByPhone("0949144961").size());
              CustomerController customerController1= new CustomerController(employee);
              customerController.addCustomer("nguyen", "20002", "10123123");
}
    
}
