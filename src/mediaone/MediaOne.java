/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mediaone;

import Product.Book;
import Product.DiscMovie;
import Product.DiscMusic;
import bill.Bill;
import database.DB;
import java.util.List;
import person.Customer;
import person.Employee;

/**
 *
 * @author Admin
 */
public class MediaOne {
    private  static List<Book> listBook;
    private static List<Employee> listEmployee;
    private static List<Bill> listBill;
    private static List<DiscMusic> listDiscMusics;
    private static List<DiscMovie> listDiscMovies;
    private static List<Customer>  listCustomers;

    
    
    public MediaOne() {
        listBook = DB.getListBook();
        listEmployee= DB.getListEmployees();
        listBill= DB.getListBills();
        listDiscMusics= DB.getListDiscMusics();
        listDiscMovies=DB.getliDiscMovie();
        listCustomers=DB.getListCustomers();
    }

    public static List<Bill> getListBill() {
        return listBill;
    }

    public static void setListBill(List<Bill> listBill) {
        MediaOne.listBill = listBill;
    }

    //book
    public static List<Book> getListBook() {
        return MediaOne.listBook;
    }

    public static void setListBook(List<Book> listBook1) {
        MediaOne.listBook = listBook1;
    }
    
    
  //employee
    public static List<Employee> getListEmployee(){
        return listEmployee;
    }

    public static void setListEmployee(List<Employee> listEmployee) {
        MediaOne.listEmployee = listEmployee;
    }
    
    //music
    public static List<DiscMusic> getListDiscMusics() {
        return MediaOne.listDiscMusics;
    }

    public static void setListDiscMusics(List<DiscMusic> listDiscMusics) {
        MediaOne.listDiscMusics = listDiscMusics;
    }
    

    // movie
    public static List<DiscMovie> getListDiscMovies(){
      return MediaOne.listDiscMovies;
    }

    public static void setListDiscMovies(List<DiscMovie> listDiscMovies) {
        MediaOne.listDiscMovies = listDiscMovies;
    }
    //customer

    public static List<Customer> getListCustomers() {
        return listCustomers;
    }

    public static void setListCustomers(List<Customer> listCustomers) {
        MediaOne.listCustomers = listCustomers;
    }
    
    
}
