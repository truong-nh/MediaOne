/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Product;

import java.util.Date;
import person.Employee;


/**
 *
 * @author Admin
 */
public class DiscMusic extends Product{
    private String genre;
    private String singer;

    public DiscMusic(String genre, String singer, String id, String code, String name, long purchasePrice, long salePrice, int remaining, Date addDate, Date updateDate, Employee updater, String productPlacement) {
        super(id, code, name, purchasePrice, salePrice, remaining, addDate, updateDate, updater, productPlacement);
        this.genre = genre;
        this.singer = singer;
    }

    public DiscMusic() {
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    

    
    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    
    
    
    
}
