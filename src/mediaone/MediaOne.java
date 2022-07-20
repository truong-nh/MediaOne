/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mediaone;

import product.Book;
import product.DiscMovie;
import product.DiscMusic;
import bill.Bill;
import database.DB;
import java.util.List;
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
    
    public MediaOne() {
        listBook = DB.getListBook();
        listEmployee= DB.getListEmployees();
        listBill= DB.getListBills();
        listDiscMusics= DB.getListDiscMusics();
    }

    
    public static List<Bill> getListBill() {
        return DB.getListBills();
    }

    public static int getIdBill() {
        int max=0;
        for(Bill bill :MediaOne.getListBill()){
           if(bill.getId()>max){
           max=bill.getId();
           }
        }
        return max;
    }

    //    public static void setListBill(List<Bill> listBill) {
//        this.listBill = listBill;
//    }
    //book
    public static List<Book> getListBook() {
        return MediaOne.listBook;
    }
    
    public static int getIdBook() {
        return MediaOne.getListBook().size();
    }
    
   
    
//    public static void setListBook(List<Book> listBook) {
//        this.listBook = listBook;
//    }
//    
    
  //employee
    public static List<Employee> getListEmployee() {
        return DB.getListEmployees();
    }

    public static int getIdEmployee() {
        int max=0;
        for(Employee employee :MediaOne.getListEmployee()){
           if(employee.getId()>max){
           max=employee.getId();
           }
        }
        return max;
    }
    
    
    //music
    public static List<DiscMusic> getListDiscMusics(){
        return DB.getListDiscMusics();
    }

    public static void setListDiscMusics(List<DiscMusic> listDiscMusics) {
        MediaOne.listDiscMusics = listDiscMusics;
    }
    
    public static int getIdDiscMusic(){
      return MediaOne.getListDiscMusics().size();
    }
    
    // movie
    public static List<DiscMovie> getListDiscMovies(){
      return DB.getliDiscMovie();
    }
    
    public static int getIdDiscMovie(){
      return MediaOne.getListDiscMovies().size();
    }
    
}
