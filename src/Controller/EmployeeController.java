/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import database.DB;
import java.util.List;
import mediaone.MediaOne;
import person.Employee;

/**
 *
 * @author Admin
 */
public class EmployeeController {
    private Employee employee;
    private MediaOne mediaOne;
    private DB db;
    
    
    
    public EmployeeController(Employee employee) {
        this.employee = employee;
        mediaOne= new MediaOne();
        db= new DB();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public Employee getEmployee(String id){
        for(Employee employee: this.getListEmployee()){
           if( employee.getId()== Integer.parseInt(id) ){
              return employee;
           }
           else{
           return null;
           }
        }
        return null;        
    }
    
    public List<Employee> getListEmployee(){
       return mediaOne.getListEmployee();
    }
    
    public Employee getEmployeeByUserName(String userName){
      for(Employee employee: mediaOne.getListEmployee()){
           if( employee.getAccount().getUserName().equals(userName) ){
              return employee;
           }
        }
        return null;   
    }
    
    
     
//    public List<Book> getListBook(){
//        return mediaOne.getListBook();
//    }
//    
//    public void addBook(String name, String code , String purcharPrice , String salePrice ,
//            String remaining,String productPlacement, String category ,String publisher, String author){
//        Book book = new Book();
//        
//        book.setId( String.valueOf(this.getIdbook()+1));
//        book.setCode(code);
//        book.setName(name);
//        book.setPurchasePrice(Long.parseLong(purcharPrice));
//        book.setSalePrice(Long.parseLong(salePrice));
//        book.setRemaining(Integer.parseInt(remaining));
//        book.setUpdateDate(new Date());
//        book.setAddDate(new Date());
//        book.setUpdater(employee);
//        book.setProductPlacemernt(productPlacement);
//        book.setCategory(category);
//        book.setPublisher(publisher);
//        book.setAuthor(author);
//        
//        
//        mediaOne.getListBook().add(book);
//        db.addBook(book);
//    }
//    
//    public int getIdbook(){
//        return mediaOne.getIdBook();
//    }
//    
//    public Book getBookByCode(String code ){
//       for(Book book : this.getListBook()){
//          if(book.getCode().equals(code) ){
//          return book;
//          }
//          else{
//          return null;
//          }
//       }
//        return null;
//    }
//    
//    public void updateBook( String code , String purcharPrice , String salePrice ,
//            String remaining,String productPlacement, String category ,String publisher, String author){
//        Book book= this.getBookByCode(code);
//        book.setPurchasePrice(Long.parseLong(purcharPrice));
//        book.setSalePrice(Long.parseLong(salePrice));
//        book.setRemaining(Integer.parseInt(remaining));
//        book.setUpdateDate(new Date());
//        book.setUpdater(employee);
//        book.setProductPlacemernt(productPlacement);
//        book.setCategory(category);
//        book.setPublisher(publisher);
//        book.setAuthor(author);
//        db.updateBook(code, book);
//    } 

    public EmployeeController() {
    }
}
