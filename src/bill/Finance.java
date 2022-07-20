package bill;

/**
 * @author nguyen
 * @create_date 20/07/2022
 */
public class Finance {

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(long totalValue) {
    this.totalValue = totalValue;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }

  private int id;
  private long totalValue;
  private long time;


}
