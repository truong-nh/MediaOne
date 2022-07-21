package bill;

/**
 * @author nguyen
 * @create_date 21/07/2022
 */
public class BusinessReport {
  private long totalPurchase;
  private long totalSell;
  private long totalOther;

  public long getTotalPurchase() {
    return totalPurchase;
  }

  public void setTotalPurchase(long totalPurchase) {
    this.totalPurchase = totalPurchase;
  }

  public long getTotalSell() {
    return totalSell;
  }

  public void setTotalSell(long totalSell) {
    this.totalSell = totalSell;
  }

  public long getTotalOther() {
    return totalOther;
  }

  public void setTotalOther(long totalOther) {
    this.totalOther = totalOther;
  }
}
