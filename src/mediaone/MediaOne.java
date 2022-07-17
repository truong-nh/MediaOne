/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mediaone;

import Product.Book;
import database.DB;
import java.util.List;
import person.Employee;

/**
 *
 * @author Admin
 */
public class MediaOne {
    private List<Book> listBook;
    private List<Employee> listEmployee;
    private int idBook; //idnhanvienmoinhat
    private int idEmployee; //id nhan vien moi nhat

    public List<Book> getListBook() {
        return listBook;
    }

    public void setListBook(List<Book> listBook) {
        this.listBook = listBook;
    }

    public  List<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    
    public MediaOne() {
        DB db =new DB();
        listBook = db.getListBook();
        listEmployee= db.getListEmployees();
        idBook= listBook.size();
    }
    
    
}
