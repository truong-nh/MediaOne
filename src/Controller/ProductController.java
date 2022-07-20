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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mediaone.MediaOne;
import person.Employee;
import person.Person;

/**
 *
 * @author Admin
 */
public class ProductController {
    private Employee employee;
    public ProductController() {
       
    }
    
    public ProductController(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    //Book
    public List<Book> getListBook(){
        return MediaOne.getListBook();
    }
    
    public static int getIdBook() {
        return MediaOne.getListBook().size();
    }  // lấy ra idBook hiện tại
    
    public void addBook(String name, String code , String purcharPrice , String salePrice ,
            String remaining,String productPlacement, String category ,String publisher, String author){
        Book book = new Book();
        book.setId( String.valueOf(this.getIdBook()+1));
        book.setCode(code);
        book.setName(name);
        book.setPurchasePrice(Long.parseLong(purcharPrice));
        book.setSalePrice(Long.parseLong(salePrice));
        book.setRemaining(Integer.parseInt(remaining));        
        book.setUpdateDate(new Date());
        book.setAddDate(new Date());
        book.setUpdater(employee);
        book.setProductPlacement(productPlacement);
        book.setCategory(category);
        book.setPublisher(publisher);
        book.setAuthor(author);
        
        MediaOne.getListBook().add(book);
        DB.addBook(book);
    }
  
    public Book getBookByCode(String code ){
       for(Book book : this.getListBook()){
          if(book.getCode().equals(code) ){
          return book;
          } 
       }
        return null;
    }
    
    public List<Book> getBooksByName(String name){
          List<Book> listBook = new ArrayList<>();
          for(Book book :this.getListBook()){
             if(book.getName().equals(name)){
             listBook.add(book);
             }
          }
          return listBook;
    }

    public void updateBook( String code , String purcharPrice , String salePrice ,
            String remaining,String productPlacement, String category ,String publisher, String author){
        Book book= this.getBookByCode(code);
        book.setPurchasePrice(Long.parseLong(purcharPrice));
        book.setSalePrice(Long.parseLong(salePrice));
        book.setRemaining(Integer.parseInt(remaining));
        book.setUpdateDate(new Date());
        book.setUpdater(employee);
        book.setProductPlacement(productPlacement);
        book.setCategory(category);
        book.setPublisher(publisher);
        book.setAuthor(author);
        
        MediaOne.setListBook(this.getListBook());
        DB.updateBook(code, book);
    }
    
    public void sellBook(String code, int amount){
            Book book= this.getBookByCode(code);
            if(book.getRemaining()>amount){
            book.setRemaining(book.getRemaining()-amount);
            MediaOne.setListBook(this.getListBook());
            DB.updateBook(code, book);
            }
            else{
                System.out.println("Không đủ sản phẩm");
            }
    }
    

    //DISCMUSIC
    public List<DiscMusic> getListDiscMusic(){
       return MediaOne.getListDiscMusics();
    }
    
     public static int getIdDiscMusic(){
      return MediaOne.getListDiscMusics().size();
    }
    
    public List<DiscMusic> getDiscMusicsByName(String name){
          List<DiscMusic> listDiscMusics = new ArrayList<>();
          for(DiscMusic discMusic :this.getListDiscMusic()){
             if(discMusic.getName().equals(name)){
             listDiscMusics.add(discMusic);
             }
          }
          return listDiscMusics;
    }
    
    public void addDiscMusic(String name, String code , String purcharPrice , String salePrice ,
            String remaining,String productPlacement, String genre ,String singer){
        DiscMusic discMusic= new DiscMusic();
        discMusic.setId( String.valueOf(this.getIdDiscMusic()+1));
        discMusic.setCode(code);
        discMusic.setName(name);
        discMusic.setPurchasePrice(Long.parseLong(purcharPrice));
        discMusic.setSalePrice(Long.parseLong(salePrice));
        discMusic.setRemaining(Integer.parseInt(remaining));
        discMusic.setUpdateDate(new Date());
        discMusic.setAddDate(new Date());
        discMusic.setUpdater(employee);
        discMusic.setProductPlacement(productPlacement);
        discMusic.setGenre(genre);
        discMusic.setSinger(singer);
        
        
        MediaOne.getListDiscMusics().add(discMusic);
        DB.addDiscMusic(discMusic);
    }
     
    public DiscMusic getDiscMusicByCode(String code ){
       for(DiscMusic discMusic : this.getListDiscMusic()){
          if(discMusic.getCode().equals(code) ){
          return discMusic;
          }
       }
        return null;
    }
     
    public void updateDiscMusic( String code , String purcharPrice , String salePrice ,
            String remaining,String productPlacement, String genre ,String singer){
        
        DiscMusic discMusic= this.getDiscMusicByCode(code);
        
        discMusic.setPurchasePrice(Long.parseLong(purcharPrice));
        discMusic.setSalePrice(Long.parseLong(salePrice));
        discMusic.setRemaining(Integer.parseInt(remaining));
        discMusic.setUpdateDate(new Date());
        discMusic.setUpdater(employee);
        discMusic.setProductPlacement(productPlacement);
        discMusic.setGenre(genre);
        discMusic.setSinger(singer);
        
        MediaOne.setListDiscMusics(this.getListDiscMusic());
        DB.updateDiscMusic(code, discMusic);
    }
    
    public void sellDiscMusic(String code, int amount){
            DiscMusic discMusic= this.getDiscMusicByCode(code);
            if(discMusic.getRemaining()>amount){
            discMusic.setRemaining(discMusic.getRemaining()-amount);
            MediaOne.setListDiscMusics(this.getListDiscMusic());
            DB.updateDiscMusic(code, discMusic);
            }
            else{
                System.out.println("Không đủ sản phẩm");
            }
    }

        
    
    //DiscMovie
    public List<DiscMovie> getListDiscMovie(){
       return MediaOne.getListDiscMovies();
    }
    
    public List<DiscMovie> getDiscMovieByName(String name){
       List<DiscMovie> listDiscMovie = new ArrayList<>();
          for(DiscMovie discMovie :this.getListDiscMovie()){
             if(discMovie.getName().equals(name)){
             listDiscMovie.add(discMovie);
             }
          }
          return listDiscMovie;
    }
    
    public DiscMovie getDiscMovieByCode(String code ){
       for(DiscMovie discMovie : this.getListDiscMovie()){
          if(discMovie.getCode().equals(code) ){
          return discMovie;
          }
       }
        return null;
    }
   
    public static int getIdDiscMovie(){
      return MediaOne.getListDiscMovies().size();
    }
    
    public void addDiscMovie(String name, String code , String purcharPrice , String salePrice ,
            String remaining,String productPlacement, String genre ,String length,String year ,String actor ,String director  ){
        DiscMovie discMovie= new DiscMovie();
        discMovie.setId( String.valueOf(this.getIdDiscMovie()+1));
        discMovie.setCode(code);
        discMovie.setName(name);
        discMovie.setPurchasePrice(Long.parseLong(purcharPrice));
        discMovie.setSalePrice(Long.parseLong(salePrice));
        discMovie.setRemaining(Integer.parseInt(remaining));
        discMovie.setUpdateDate(new Date());
        discMovie.setAddDate(new Date());
        discMovie.setUpdater(employee);
        discMovie.setProductPlacement(productPlacement);
        discMovie.setGenre(genre);
        discMovie.setLength(Integer.parseInt(length));
        discMovie.setYear(Integer.parseInt(year));
        discMovie.setActor(actor);
        discMovie.setDirector(director);
        
        MediaOne.getListDiscMovies().add(discMovie);
        DB.addDiscMovie(discMovie);
    }
    
    public void updateDiscMovie( String code  , String purcharPrice , String salePrice ,
            String remaining,String productPlacement, String genre ,String length,String year ,String actor ,String director){
        
        DiscMovie discMovie= this.getDiscMovieByCode(code);
        
        discMovie.setPurchasePrice(Long.parseLong(purcharPrice));
        discMovie.setSalePrice(Long.parseLong(salePrice));
        discMovie.setRemaining(Integer.parseInt(remaining));
        discMovie.setUpdateDate(new Date());
        discMovie.setUpdater(employee);
        discMovie.setProductPlacement(productPlacement);
        discMovie.setGenre(genre);
        discMovie.setLength(Integer.parseInt(length));
        discMovie.setYear(Integer.parseInt(year));
        discMovie.setActor(actor);
        discMovie.setDirector(director);
        MediaOne.setListDiscMusics(this.getListDiscMusic());
        DB.updateDiscMovie(code, discMovie);
    }
    
    public void sellDiscMovie(String code, int amount){
        DiscMovie discMovie= this.getDiscMovieByCode(code);
            if(discMovie.getRemaining()>amount){
            discMovie.setRemaining(discMovie.getRemaining()-amount);
            
            MediaOne.setListDiscMusics(this.getListDiscMusic()); 
            DB.updateDiscMovie(code, discMovie);    
            }
            else{
                System.out.println("Không đủ sản phẩm");
            }
    }
}
