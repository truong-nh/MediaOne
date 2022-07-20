package order;

import product.Product;
import java.util.Date;
import java.util.Map;
import person.Customer;
import person.Employee;

/**
 * @author nguyen
 * @create_date 19/07/2022
 */
public class Order {

  private int id;
  private Customer customer;
  private Employee employee;
  private Map<Product, Integer> listProducts;
  private Date date;
  private BillType type;
  private long totalValue;

  public Order() {
  }

  public Order(int id, Customer customer, Employee sellEmployee,
      Map<Product, Integer> listProducts, Date date, BillType type, long totalValue) {
    this.id = id;
    this.customer = customer;
    this.employee = sellEmployee;
    this.listProducts = listProducts;
    this.date = date;
    this.type = type;
    this.totalValue = totalValue;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Employee getSellEmployee() {
    return employee;
  }

  public void setSellEmployee(Employee sellEmployee) {
    this.employee = sellEmployee;
  }

  public Map<Product, Integer> getListProducts() {
    return listProducts;
  }

  public void setListProducts(Map<Product, Integer> listProducts) {
    this.listProducts = listProducts;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public BillType getType() {
    return type;
  }

  public void setType(BillType type) {
    this.type = type;
  }

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

  public Order updateProducts(Map<Product, Integer> inputMaps) {
    Map<Product, Integer> prods = this.getListProducts();
    prods.putAll(inputMaps);
    return this;
  }

}
