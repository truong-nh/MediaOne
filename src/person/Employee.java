/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

/**
 *
 * @author Admin
 */
public class Employee extends Person{
    private Account account;
    private int salary;
    private int id;

    public Employee(Account account, int salary, int id, String name, int born, String phone) {
        super(name, born, phone);
        this.account = account;
        this.salary = salary;
        this.id = id;
    }

    public Employee() {
        Account account= new Account();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
   
    

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
