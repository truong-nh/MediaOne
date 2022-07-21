package bill;

/**
 * @author nguyen
 * @create_date 21/07/2022
 */
public class FinanceReport {
  private String date;
  private long money;
  private long productValue;
  private long totalProperties;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public long getMoney() {
    return money;
  }

  public void setMoney(long money) {
    this.money = money;
  }

  public long getProductValue() {
    return productValue;
  }

  public void setProductValue(long productValue) {
    this.productValue = productValue;
  }

  public long getTotalProperties() {
    return totalProperties;
  }

  public void setTotalProperties(long totalProperties) {
    this.totalProperties = totalProperties;
  }
}
