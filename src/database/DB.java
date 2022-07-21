/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import Product.Book;
import Product.DiscMovie;
import Product.DiscMusic;
import Product.Product;
import bill.Bill;
import bill.BillType;
import bill.BusinessReport;
import bill.Finance;
import config.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import person.Account;
import person.Customer;
import person.Employee;

/**
 *
 * @author Admin
 */
public class DB {
    
    public static List<Book> getListBook(){
        List<Book> bookList = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst= null;
        
        String sql =" SELECT * FROM book";
        
        try {
            pst= connection.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
            Employee updater= DB.getEmployee(rs.getString("Updater"));
            Book book = new Book();
            
            book.setUpdater(updater);
            book.setId(rs.getString("ID"));
            book.setCode(rs.getString("CODE"));
            book.setName(rs.getString("Name"));
            book.setPurchasePrice(rs.getInt("purcharPrice"));
            book.setSalePrice(rs.getInt("SalePrice"));
            book.setRemaining(rs.getInt("Remaining"));
            book.setAddDate(rs.getDate("AddDate"));
            book.setUpdateDate(rs.getDate("UpdateDate"));
            
            book.setProductPlacement(rs.getString("ProductPlacement"));
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
                  
    public static void addBook(Book book) {
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
    
    public static void updateBook(String code,Book book){
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
    
 
    //DiscMusic
    public static List<DiscMusic> getListDiscMusics(){
        List<DiscMusic> discMusics = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst= null;
        
        String sql =" SELECT * FROM discmusic";
        
        try {
            pst= connection.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
            Employee updater= DB.getEmployee(rs.getString("Updater"));
            DiscMusic discMusic = new DiscMusic();
            
            discMusic.setUpdater(updater);
            
            discMusic.setId(rs.getString("ID"));
            discMusic.setCode(rs.getString("CODE"));
            discMusic.setName(rs.getString("Name"));
            discMusic.setPurchasePrice(rs.getInt("purcharPrice"));
            discMusic.setSalePrice(rs.getInt("SalePrice"));
            discMusic.setRemaining(rs.getInt("Remaining"));
            discMusic.setAddDate(rs.getTimestamp("AddDate"));
            discMusic.setUpdateDate(rs.getTimestamp("UpdateDate"));
            discMusic.setProductPlacement(rs.getString("ProductPlacement"));
            discMusic.setGenre(rs.getString("Genre"));
            discMusic.setSinger(rs.getString("Singer"));
            
            discMusics.add(discMusic);
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
        return discMusics;
    }
           
    public static void addDiscMusic(DiscMusic discMusic){
    Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "INSERT INTO discMusic (ID, Code, Name, PurcharPrice, SalePrice, Remaining, AddDate, UpdateDate, Updater,ProductPlacement, genre, singer) "
                + "VALUE(?,?,?,?,?,?,?,?,?,?,?,?)";
 
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,discMusic.getId());
            pst.setString(2,discMusic.getCode() );
            pst.setString(3,discMusic.getName() );
            pst.setInt(4, (int) discMusic.getPurchasePrice());
            pst.setInt(5, (int) discMusic.getSalePrice());
            pst.setInt(6,discMusic.getRemaining() );
            
            Date date = new Date();             
            SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = formatter.format(date); 
            pst.setString(7, strDate);
            
            pst.setString(8,  strDate);
            pst.setInt(9,discMusic.getUpdater().getId() );
            pst.setString(10,discMusic.getProductPlacement() );
            pst.setString(11,discMusic.getGenre());
            pst.setString(12,discMusic.getSinger());
            

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
    
    public static void updateDiscMusic(String code,DiscMusic discMusic){
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE discmusic set Code = ?, Name = ?, PurcharPrice = ?, SalePrice = ?, Remaining = ?,"
                + " AddDate = ?, UpdateDate = ?, Updater = ?,ProductPlacement = ?, genre = ?, singer = ?  WHERE CODE = ? ";
 
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1,discMusic.getCode() );
            pst.setString(2,discMusic.getName() );
            pst.setInt(3, (int) discMusic.getPurchasePrice());
            pst.setInt(4, (int) discMusic.getSalePrice());
            pst.setInt(5,discMusic.getRemaining() );
            
            Date date = new Date();             
            SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = formatter.format(date); 
            String addDate= formatter.format(discMusic.getAddDate());
            
            pst.setString(6, addDate);         
            pst.setString(7,  strDate);
            
            pst.setInt(8,discMusic.getUpdater().getId() );
            pst.setString(9,discMusic.getProductPlacement() );
            pst.setString(10,discMusic.getGenre());
            pst.setString(11,discMusic.getSinger());
            
            pst.setString(12,code);
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
    
    //DiscFilm
    public static List<DiscMovie> getliDiscMovie(){
        List<DiscMovie> listDiscMovies = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst= null;
        
        String sql =" SELECT * FROM discmovie";
        
        try {
            pst= connection.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
            Employee updater= DB.getEmployee(rs.getString("Updater"));
            DiscMovie discMovie = new DiscMovie();
            
            discMovie.setUpdater(updater);
            
            discMovie.setId(rs.getString("ID"));
            discMovie.setCode(rs.getString("CODE"));
            discMovie.setName(rs.getString("Name"));
            discMovie.setPurchasePrice(rs.getInt("purcharPrice"));
            discMovie.setSalePrice(rs.getInt("SalePrice"));
            discMovie.setRemaining(rs.getInt("Remaining"));
            discMovie.setAddDate(rs.getTimestamp("AddDate"));
            discMovie.setUpdateDate(rs.getTimestamp("UpdateDate"));
            discMovie.setProductPlacement(rs.getString("ProductPlacement"));
            discMovie.setGenre(rs.getString("Genre"));
            discMovie.setLength(rs.getInt("Length"));
            discMovie.setYear(rs.getInt("Year"));
            discMovie.setActor(rs.getString("Actor"));
            discMovie.setDirector(rs.getString("Director"));
           
            
            listDiscMovies.add(discMovie);
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
        return listDiscMovies;
    }
    
    public static void addDiscMovie (DiscMovie discMovie){
    Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "INSERT INTO discMovie (ID, Code, Name, PurcharPrice, SalePrice, Remaining, AddDate, UpdateDate, Updater,ProductPlacement, genre, length, year, actor, director) "
                + "VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
 
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,discMovie.getId());
            pst.setString(2,discMovie.getCode() );
            pst.setString(3,discMovie.getName() );
            pst.setInt(4, (int) discMovie.getPurchasePrice());
            pst.setInt(5, (int) discMovie.getSalePrice());
            pst.setInt(6,discMovie.getRemaining() );
            
            Date date = new Date();             
            SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = formatter.format(date); 
            pst.setString(7, strDate);
            
            pst.setString(8,  strDate);
            pst.setInt(9,discMovie.getUpdater().getId() );
            pst.setString(10,discMovie.getProductPlacement() );
            pst.setString(11,discMovie.getGenre());
            pst.setInt(12,discMovie.getLength());
            pst.setInt(13,discMovie.getYear());
            pst.setString(14,discMovie.getActor());
            pst.setString(15,discMovie.getDirector());
            

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
    
    public static void updateDiscMovie(String code,DiscMovie discMovie){
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE discMovie set Code = ?, Name = ?, PurcharPrice = ?, SalePrice = ?, Remaining = ?,"
                + " AddDate = ?, UpdateDate = ?, Updater = ?,ProductPlacement = ?, genre = ?, length =?, year =?, actor = ?, director = ? WHERE CODE = ? ";
  
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1,discMovie.getCode() );
            pst.setString(2,discMovie.getName() );
            pst.setInt(3, (int) discMovie.getPurchasePrice());
            pst.setInt(4, (int) discMovie.getSalePrice());
            pst.setInt(5,discMovie.getRemaining() );
            
            Date date = new Date();             
            SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = formatter.format(date); 
            String addDate= formatter.format(discMovie.getAddDate());
            
            pst.setString(6, addDate);         
            pst.setString(7,  strDate);
            
            pst.setInt(8,discMovie.getUpdater().getId() );
            pst.setString(9,discMovie.getProductPlacement() );
            pst.setString(10,discMovie.getGenre());
            pst.setInt(11,discMovie.getLength());
            pst.setInt(12,discMovie.getYear());
            pst.setString(13,discMovie.getActor() );
            pst.setString(14,discMovie.getDirector() );


            pst.setString(15,code);
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
    public static List<Employee> getListEmployees(){
    List<Employee> employees = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst= null;
        
        String sql =" SELECT * FROM employee";
        
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
         
    public static Employee getEmployee (String id){
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
    
    public static Employee getEmployeeByUserName(String userName){
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
    
    public static void addEmployee(Employee employee ){
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
    
    public static void updateEmployee(String userName, Employee employee){
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
    
    
    
    
    
    //customer
    public static List<Customer> getListCustomers(){
     List<Customer> customers = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst= null;
        
        String sql =" SELECT * FROM customer";
        
        try {
            pst= connection.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()){
            Customer customer = new Customer();
            
            customer.setId(rs.getInt("ID")) ;
            customer.setName(rs.getString("Name"));
            customer.setBorn(rs.getInt("born"));
            customer.setPhone(rs.getString("phone"));
            customer.setPoint(rs.getInt("point"));
            
            customers.add(customer);
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
        return customers;
    }
    
    public static void addCustomer(Customer customer){
       Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "INSERT INTO customer (ID, Name, born, phone, point) "
                + "VALUE(?,?,?,?,?)";
 
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,customer.getId());
            pst.setString(2, customer.getName() );
            pst.setInt(3,customer.getBorn());
            pst.setString(4,customer.getPhone());
            pst.setInt(5, customer.getPoint());
            
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
    
    public static void updateCustomer(String ID,Customer customer){
       Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE customer set ID = ?, Name = ?, born = ?, phone = ?, Point = ? WHERE ID  = ? ";
 
        try {
             pst = connection.prepareStatement(sql);
            pst.setInt(1,customer.getId());
            pst.setString(2, customer.getName() );
            pst.setInt(3,customer.getBorn());
            pst.setString(4,customer.getPhone());
            pst.setInt(5, customer.getPoint());
            
            pst.setString(6,ID);
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
     
    ///bill
    public static List<Bill> getListBills(){
      List<Bill> bills = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst= null;

        String sql =" SELECT * FROM bill";

        try {
            pst= connection.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();

            while(rs.next()){
            Bill bill = new Bill();
            Employee creator = DB.getEmployee(rs.getString("creator"));


            bill.setTime(rs.getTimestamp("date").getTime()); ;
            bill.setType(BillType.valueOf(rs.getString("type")));
            bill.setId(rs.getInt("id"));
            bill.setValue(rs.getInt("value"));
            bill.setEmployee(creator);
//            bill.setCustomer(rs.getString("note"));

            bills.add(bill);
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
        return bills;

    }
    
    public static void saveBill(Bill bill){
       Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        String sqlBill = "INSERT INTO bill (date, type, value, creator, customer) "
                + "VALUE(?,?,?,?,?)";
        String sqlBillProduct = "INSERT into bill_product(bill_id, product_code, amount)"
            + "VALUE(?,?,?)";
        try {
            pst = connection.prepareStatement(sqlBill);
            pst2 = connection.prepareStatement(sqlBillProduct);
            pst.setLong(1, bill.getTime());
            pst.setString(2, bill.getType().name());
            pst.setInt(3, (int) bill.getValue());
            pst.setString(4, String.valueOf(bill.getEmployee().getId()));
            if (bill.getCustomer()== null){
                pst.setString(5, "0");
            } else {
                pst.setString(5, bill.getCustomer().getPhone());
            }

            int rs = pst.executeUpdate();
            System.out.println(rs);
            int billId = rs;
            pst2.setInt(1, billId);
            Map<Product, Integer> maps = bill.getProductMaps();
            Set<Product> products = maps.keySet();
            for (Product product : products){
                pst2.setString(2, product.getCode());
                pst2.setInt(3, maps.get(product));
                pst2.execute();
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
    }
    
    //finance
    public static long getFinance(long time) {
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM finance\n"
            + "WHERE time < ? \n"
            + "ORDER BY time DESC\n"
            + "LIMIT 1";
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, time);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                long result = resultSet.getLong("total_value");
                return result;
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
        return 1;
    }

    public static BusinessReport getBusinessReport(long fromDate, long toDate){
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM finance\n"
            + "WHERE time < ? \n"
            + "AND time > ?\n";
        List<String> reportList = new ArrayList<>();
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, toDate);
            pst.setLong(2, fromDate);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()) {
                reportList.add(resultSet.getString("description"));
            }
            return calcBusinessReport(reportList);
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

    private static BusinessReport calcBusinessReport(List<String> listReports){
        BusinessReport result = new BusinessReport();
        for (String report : listReports){
            String[] dataGot = report.split("_");
            List<String> dataLists = Arrays.asList(dataGot);
            if (dataLists.size() ==2 ){
                if (BillType.BUYING.name().equals(dataLists.get(1))) {
                    result.setTotalPurchase(result.getTotalPurchase()
                        + Long.parseLong(dataLists.get(0)));
                } else if (BillType.SELLING.name().equals(dataLists.get(1))) {
                    result.setTotalSell(result.getTotalSell()
                        + Long.parseLong(dataLists.get(0)));
                } else if ("OTHER".equals(dataLists.get(1))){
                    result.setTotalOther(result.getTotalOther()
                        + Long.parseLong(dataLists.get(0)));
                }
            }
        }
        return result;
    }

    public static void saveFinance(long totalValue, Bill bill, long cost) {
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        long time = new Date().getTime();
        String sql = "INSERT INTO finance (total_value, time, description) "
            + "VALUE(?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setLong(1, totalValue);
            pst.setLong(2, time);

            if (bill == null){
                pst.setString(3, String.valueOf(cost).concat("_OTHER"));
            } else {
                pst.setString(3, String.valueOf(bill.getValue()).concat("_")
                    .concat(bill.getType().name()));
            }
            int rs = pst.executeUpdate();

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
