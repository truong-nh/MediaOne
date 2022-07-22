package Controller;

import Product.Book;
import Product.DiscMovie;
import Product.DiscMusic;
import bill.BusinessReport;
import bill.FinanceReport;
import database.DB;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mediaone.MediaOne;
import person.Employee;
import util.DateUtil;

/**
 * @author nguyen
 * @create_date 21/07/2022
 */
public class FinanceController {

  Employee employee;

    public FinanceController(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
  public List<FinanceReport> getReport(String fromDate, String toDate) throws ParseException {
    List<FinanceReport> result = new ArrayList<>();
    List<String> listDateRequired = getListDateRequired(fromDate, toDate);
    long totalProductValue = getTotalProductValues();
    String today = DateUtil.sdf.format(new Date());
    for (String date : listDateRequired){
      FinanceReport report = new FinanceReport();
      long time = DateUtil.sdf.parse(date).getTime();
      long finance = DB.getFinance(time);
      report.setMoney(finance);
      report.setDate(date);
      BusinessReport businessReport = getBusinessReport(date, today);
      report.setProductValue(totalProductValue + businessReport.getTotalPurchase() -
          businessReport.getTotalSell() + businessReport.getTotalOther());
      report.setTotalProperties(report.getMoney()+ report.getProductValue());
      result.add(report);
    }
    return result;
  } //table

  public long getTotalProductValues(){
    return getTotalBookValue() + getTotalDiscMovieValue() + getTotalDiscMusicValue();
  }
  public long getTotalBookValue(){
    List<Book> books = MediaOne.getListBook();
    long result = 0L;
    for (Book book : books){
      result += book.getSalePrice()*book.getRemaining();
    }
    return result;
  }
  public long getTotalDiscMovieValue(){
    List<DiscMovie> discs = MediaOne.getListDiscMovies();
    long result = 0L;
    for (DiscMovie disc : discs){
      result += disc.getSalePrice()*disc.getRemaining();
    }
    return result;
  }
  public long getTotalDiscMusicValue(){
    List<DiscMusic> discs = MediaOne.getListDiscMusics();
    long result = 0L;
    for (DiscMusic disc : discs){
      result += disc.getSalePrice()*disc.getRemaining();
    }
    return result;
  }

  public static List<String> getListDateRequired(String fromDate, String toDate) throws ParseException {
    long dateDiff = DateUtil.getDateDiffFollowingDate(fromDate, toDate);
    List<String> listDateRequired = new ArrayList<>();

    if(dateDiff>4) {
      int size = (int) dateDiff / 4;
      String tmp = fromDate;
      for (int i = 0; i < 5; i++){
        if (i == 4){
          listDateRequired.add(toDate);
          break;
        }
        if (i== 0){
          listDateRequired.add(fromDate);
          continue;
        }
        String dateAdded = DateUtil.addDate(tmp, size);
        listDateRequired.add(dateAdded);
        tmp = dateAdded;
      }
    } else {
      String tmp = fromDate;
      for (int i = 0; i <= dateDiff; i++){
        if (i == dateDiff){
          listDateRequired.add(toDate);
          break;
        }
        if (i== 0){
          listDateRequired.add(fromDate);
          continue;
        }
        String dateAdded = DateUtil.addDate(tmp, 1);
        listDateRequired.add(dateAdded);
        tmp = dateAdded;
      }
    }
    return listDateRequired;
  }

  public BusinessReport getBusinessReport(String fromDate, String toDate) throws ParseException {
    long fromTime = DateUtil.sdf.parse(fromDate).getTime();
    long endTime = DateUtil.atEndOfDay(DateUtil.sdf.parse(toDate)).getTime();
    return DB.getBusinessReport(fromTime, endTime);
  } 
  
}
