/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import Product.Book;
import config.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import person.Account;
import person.Employee;

/**
 *
 * @author Admin
 */
public class DB {
    
    public List<Book> getListBook(){
        List<Book> bookList = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst= null;
        
        String sql =" SELECT * FROM book";
        
        try {
            pst= connection.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
            Employee updater= this.getEmployee(rs.getString("Updater"));
            Book book = new Book();
            
            book.setUpdater(updater);
            book.setId(rs.getString("ID"));
            book.setCode(rs.getString("CODE"));
            book.setName(rs.getString("Name"));
            book.setPurchasePrice(rs.getInt("purcharPrice"));
            book.setSalePrice(rs.getInt("SalePrice"));
            book.setRemaining(rs.getInt("Remaining"));
            book.setAddDate(rs.getTimestamp("AddDate"));
            book.setUpdateDate(rs.getTimestamp("UpdateDate"));
            
            book.setProductPlacemernt(rs.getString("ProductPlacement"));
            book.setCategory(rs.getString("Category"));
            book.setPublisher(rs.getString("Publisher"));
            book.setAuthor(rs.getString("Author"));
            
            bookList.add(book);
        }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }        
        return bookList;
    }
           
    public void addProduct(Book book) {
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "INSERT INTO book (Code, Name, PurcharPrice, SalePrice, Remaining, AddDate, UpdateDate, Updater,ProductPlacement, Category, Publisher, Author) "
                + "VALUE(?,?,?,?,?,?,?,?,?,?,?,?)";
 
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,book.getCode() );
            pst.setString(2,book.getName() );
            pst.setInt(3, (int) book.getPurchasePrice());
            pst.setInt(4, (int) book.getSalePrice());
            pst.setInt(5,book.getRemaining() );
            
            Date date = new Date();             
            SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = formatter.format(date); 
            pst.setString(6, strDate);
            
            pst.setTimestamp(7, (Timestamp) book.getUpdateDate());
            pst.setInt(8,book.getUpdater().getId() );
            pst.setString(9,book.getProductPlacement() );
            pst.setString(10,book.getCategory() );
            pst.setString(11,book.getPublisher() );
            pst.setString(12,book.getAuthor() );

            int rs = pst.executeUpdate();
            System.out.println(rs);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
        
    
    public Book getBookByCode(String code){
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
      
        String sql = "SELECT * FROM book WHERE code = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, code);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
            
            Employee updater= this.getEmployee(rs.getString("Updater"));
            Book book = new Book();
            
            book.setUpdater(updater);
            book.setId(rs.getString("ID"));
            book.setCode(rs.getString("CODE"));
            book.setName(rs.getString("Name"));
            book.setPurchasePrice(rs.getInt("purcharPrice"));
            book.setSalePrice(rs.getInt("SalePrice"));
            book.setRemaining(rs.getInt("Remaining"));
            book.setAddDate(rs.getTimestamp("AddDate"));
            book.setUpdateDate(rs.getTimestamp("UpdateDate"));
            
            book.setProductPlacemernt(rs.getString("ProductPlacement"));
            book.setCategory(rs.getString("Category"));
            book.setPublisher(rs.getString("Publisher"));
            book.setAuthor(rs.getString("Author"));
            
            return book;
        }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }
    
    public void addBook(Book book) {
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "INSERT INTO book (ID, Code, Name, PurcharPrice, SalePrice, Remaining, AddDate, UpdateDate, Updater,ProductPlacement, Category, Publisher, Author) "
                + "VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?)";
 
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,book.getId());
            pst.setString(2,book.getCode() );
            pst.setString(3,book.getName() );
            pst.setInt(4, (int) book.getPurchasePrice());
            pst.setInt(5, (int) book.getSalePrice());
            pst.setInt(6,book.getRemaining() );
            
            Date date = new Date();             
            SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = formatter.format(date); 
            pst.setString(7, strDate);
            
            pst.setString(8,  strDate);
            pst.setInt(9,book.getUpdater().getId() );
            pst.setString(10,book.getProductPlacement() );
            pst.setString(11,book.getCategory() );
            pst.setString(12,book.getPublisher() );
            pst.setString(13,book.getAuthor() );

            int rs = pst.executeUpdate();
            System.out.println(rs);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public void updateBook(String code,Book book){
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE book set Code = ?, Name = ?, PurcharPrice = ?, SalePrice = ?, Remaining = ?,"
                + " AddDate = ?, UpdateDate = ?, Updater = ?,ProductPlacement = ?, Category = ?, Publisher = ?, Author = ? WHERE CODE = ? ";
 
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1,book.getCode() );
            pst.setString(2,book.getName() );
            pst.setInt(3, (int) book.getPurchasePrice());
            pst.setInt(4, (int) book.getSalePrice());
            pst.setInt(5,book.getRemaining() );
            
            Date date = new Date();             
            SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = formatter.format(date); 
            String addDate= formatter.format(book.getAddDate());
            
            pst.setString(6, addDate);         
            pst.setString(7,  strDate);
            
            pst.setInt(8,book.getUpdater().getId() );
            pst.setString(9,book.getProductPlacement() );
            pst.setString(10,book.getCategory() );
            pst.setString(11,book.getPublisher() );
            pst.setString(12,book.getAuthor() );
            
            pst.setString(13,code);
            int rs = pst.executeUpdate();
            System.out.println(rs);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    
    
    // employee
    public List<Account> getListAccounts(){
    List<Account> accounts = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst= null;
        
        String sql =" SELECT * FROM account";
        
        try {
            pst= connection.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
            Account account= new Account();
                  
            account.setUserName(rs.getString("UserName"));
            account.setPassword(rs.getString("PassWord"));
            account.setRole(rs.getString("Role"));
            accounts.add(account);
        }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }        
        return accounts;
   
    }
    
    public List<Employee> getListEmployees(){
    List<Employee> employees = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst= null;
        
        String sql =" SELECT * FROM Employee   ";
        
        try {
            pst= connection.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
            Employee employee= new Employee();
            Account acc = new Account();
            
            acc.setUserName(rs.getString("UserName") );
            acc.setPassword(rs.getString("PassWord") );
            acc.setRole(rs.getString("role") );
            
            employee.setId(rs.getInt("id"));
            employee.setSalary(rs.getInt("salary"));
            employee.setName(rs.getString("Name"));
            employee.setBorn(rs.getInt("born"));
            employee.setPhone(rs.getString("phone"));
            employee.setAccount(acc);
            employees.add(employee);
        }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }        
        return employees;
   
    }
         
    public Employee getEmployee (String id){
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
      
        String sql = "SELECT * FROM employee WHERE id = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
            Employee employee= new Employee();
            Account acc = new Account();
            
            acc.setUserName(rs.getString("UserName") );
            acc.setPassword(rs.getString("PassWord") );
            acc.setRole(rs.getString("role") );
            
            employee.setId(rs.getInt("id"));
            employee.setSalary(rs.getInt("salary"));
            employee.setName(rs.getString("Name"));
            employee.setBorn(rs.getInt("born"));
            employee.setPhone(rs.getString("phone"));
            employee.setAccount(acc);
           
            return employee;
        }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }   
    
    public Employee getEmployeeByUserName(String userName){
          Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
      
        String sql = "SELECT * FROM employee WHERE UserName = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, userName);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
            Employee employee= new Employee();
            Account acc = new Account();
            
            acc.setUserName(rs.getString("UserName") );
            acc.setPassword(rs.getString("PassWord") );
            acc.setRole(rs.getString("role") );
            
            employee.setId(rs.getInt("id"));
            employee.setSalary(rs.getInt("salary"));
            employee.setName(rs.getString("Name"));
            employee.setBorn(rs.getInt("born"));
            employee.setPhone(rs.getString("phone"));
            employee.setAccount(acc);
           
            return employee;
        }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;        
    }
    
    public void addEmployee(Employee employee ){
          Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "INSERT INTO employee (ID, Salary, Name, phone, born, UserName, PassWord, Role) "
                + "VALUE(?,?,?,?,?,?,?,?)";
 
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,employee.getId());
            pst.setString(2, String.valueOf(employee.getSalary()) );
            pst.setString(3,employee.getName());
            pst.setString(4,employee.getPhone());
            pst.setInt(5, employee.getBorn());
            pst.setString(6, employee.getAccount().getUserName());
            pst.setString(7, employee.getAccount().getPassword());
            pst.setString(8, employee.getAccount().getRole());
            int rs = pst.executeUpdate();
            System.out.println(rs);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } 
    }
    
    public void updateEmployee(String userName, Employee employee){
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE employee set salary = ?, Name = ?, born = ?, phone = ?,userName = ?, password = ?, role = ? WHERE userName  = ? ";
 
        try {
             pst = connection.prepareStatement(sql);
             pst.setString(1, String.valueOf(employee.getSalary()));
             pst.setString(2, employee.getName());
             pst.setInt(3,employee.getBorn());
             pst.setString(4, employee.getPhone());
             pst.setString(5, employee.getAccount().getUserName());
             pst.setString(6, employee.getAccount().getPassword());
             pst.setString(7, employee.getAccount().getRole());
             
             pst.setString(8,userName);
            int rs = pst.executeUpdate();
            System.out.println(rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
}
