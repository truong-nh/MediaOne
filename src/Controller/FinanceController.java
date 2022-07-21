package Controller;

import bill.BusinessReport;
import bill.FinanceReport;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nguyen
 * @create_date 21/07/2022
 */
public class FinanceController {

  public List<FinanceReport> getReport(String fromDate, String toDate) {
    List<FinanceReport> result = new ArrayList<>();
    FinanceReport f1 = new FinanceReport();
    f1.setDate("01/07/2022");
    f1.setMoney(10000000);
    f1.setProductValue(20000000);
    f1.setTotalProperties(30000000);
    FinanceReport f2 = new FinanceReport();
    f2.setDate("07/07/2022");
    f2.setMoney(15000000);
    f2.setProductValue(20000000);
    f2.setTotalProperties(35000000);
    result.add(f1);
    result.add(f2);
    return result;
  }

  public BusinessReport getBusinessReport(String fromDate, String toDate){
    BusinessReport result = new BusinessReport();
    result.setTotalPurchase(5000000);
    result.setTotalSell(7000000);
    result.setTotalOther(500000);
    return result;
  }
}
