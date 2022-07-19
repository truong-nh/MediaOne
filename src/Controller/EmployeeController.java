/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import database.DB;
import java.util.List;
import mediaone.MediaOne;
import person.Account;
import person.Employee;

/**
 *
 * @author Admin
 */
public class EmployeeController {
    private Employee employee;
    
    
    
    public EmployeeController(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public Employee getEmployeeByID(String id){
        for(Employee employee: this.getListEmployee()){
           if( employee.getId()== Integer.parseInt(id) ){
              return employee;
           }
        }
        return null;        
    }
    
    public int getIdEmployee(){
      return  MediaOne.getIdEmployee();
    }
    
    public List<Employee> getListEmployee(){
       return MediaOne.getListEmployee();
    }
    
    public Employee getEmployeeByUserName(String userName){
      for(Employee employee: MediaOne.getListEmployee()){
           if( employee.getAccount().getUserName().equals(userName) ){
              return employee;
           }
        }
        return null;   
    }
    
    public void addEmployee(String salary, String name, String phone, String born ,String userName,String passWord, String role  ){
           Employee newEmployee= new Employee();
           Account  account = new Account();
           
           account.setPassword(passWord);
           account.setRole(role);
           account.setUserName(userName);
           newEmployee.setAccount(account);
           
           newEmployee.setId(this.getIdEmployee()+1);
           newEmployee.setSalary(Integer.parseInt(salary));
           newEmployee.setName(name);
           newEmployee.setPhone(phone);
           newEmployee.setBorn(Integer.parseInt(born));
           
           MediaOne.getListEmployee().add(newEmployee);
           DB.addEmployee(newEmployee);
    }
     
    public void updateEmployee(String userName, String salary){
       employee = this.getEmployeeByUserName(userName);
       employee.setSalary(Integer.parseInt(salary));
       DB.updateEmployee(userName, employee);
    }

    public EmployeeController() {
    }
}
