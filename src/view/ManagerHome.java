/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Controller.CustomerController;
import view.employeeform.EmployeeForm;
import view.bookform.BookFormEdit;
import view.bookform.BookForm;
import Controller.EmployeeController;
import view.clock.ClockThread;
import Controller.ProductController;
import Product.Book;
import Product.DiscMovie;
import Product.DiscMusic;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import person.Customer;
import person.Employee;
import view.bill.BuyBill;
import view.bill.OrderBill;
import view.customerform.CustomerForm;
import view.discMovieForm.DiscMovieForm;
import view.discMovieForm.DiscMovieFormEdit;
import view.discmusicform.DiscMusicForm;
import view.discmusicform.DiscMusicFormEdit;
import view.employeeform.EmployeeFormEdit;
import view.finance.FinanceForm;

/**
 *
 * @author Admin
 */
public class ManagerHome extends javax.swing.JFrame {
    Employee employee;
    EmployeeController employeeController;
    ProductController productController;
    CustomerController customerController;
    /**
     * Creates new form EmployeeHome
     */
    public ManagerHome() {
        initComponents();
        
    }
    public ManagerHome(Employee employee)  {
        this.employee=employee;
        productController= new ProductController(employee);
        employeeController= new EmployeeController(employee);
        initComponents();
        jLabel6.setText("UserName:"+employee.getAccount().getUserName());
        
        ClockThread th= new ClockThread(timeJLabel);
        th.start();
        DefaultTableModel defaultTableModel;
     defaultTableModel= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }         
        } ; 
     listBookTable.setModel(defaultTableModel);
        
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Code");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("PurcharPrice");
        defaultTableModel.addColumn("SalePrice");
        defaultTableModel.addColumn("Remaining");
        defaultTableModel.addColumn("AddDate");
        defaultTableModel.addColumn("UpdateDate");
        defaultTableModel.addColumn("IdUpdater");
        defaultTableModel.addColumn("ProductPlacement");
        defaultTableModel.addColumn("Category");
        defaultTableModel.addColumn("Publisher");
        defaultTableModel.addColumn("Author");
        
        List<Book> books = productController.getListBook();
        for(Book book : books){
        defaultTableModel.addRow(new Object[]{book.getId(),book.getCode(),book.getName(),book.getPurchasePrice(),book.getSalePrice(),book.getRemaining(),formatter.format(book.getAddDate()),formatter.format(book.getUpdateDate()),book.getUpdater().getId(),
            book.getProductPlacement(),book.getCategory(),book.getPublisher(),book.getAuthor()  });
        }
        
        DefaultTableModel defaultTableMode2;
     defaultTableMode2= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }         
        } ; 
     listDiscMusicTable1.setModel(defaultTableMode2);
        
        defaultTableMode2.addColumn("ID");
        defaultTableMode2.addColumn("Code");
        defaultTableMode2.addColumn("Name");
        defaultTableMode2.addColumn("PurcharPrice");
        defaultTableMode2.addColumn("SalePrice");
        defaultTableMode2.addColumn("Remaining");
        defaultTableMode2.addColumn("AddDate");
        defaultTableMode2.addColumn("UpdateDate");
        defaultTableMode2.addColumn("IdUpdater");
        defaultTableMode2.addColumn("ProductPlacement");
        defaultTableMode2.addColumn("Genre");
        defaultTableMode2.addColumn("Singer");

        List<DiscMusic> listDiscMusics = productController.getListDiscMusic();
         for(DiscMusic discMusic: listDiscMusics){
        defaultTableMode2.addRow(new Object[]{discMusic.getId(),discMusic.getCode(),discMusic.getName(),discMusic.getPurchasePrice(),discMusic.getSalePrice(),discMusic.getRemaining(),formatter.format(discMusic.getAddDate()),formatter.format(discMusic.getUpdateDate()),discMusic.getUpdater().getId(),
            discMusic.getProductPlacement(),discMusic.getGenre(),discMusic.getSinger()  });
        }  
        
         DefaultTableModel defaultTableModel3;
     defaultTableModel3= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }         
        } ; 
     listDiscMovieJTable.setModel(defaultTableModel3);
        
        defaultTableModel3.addColumn("ID");
        defaultTableModel3.addColumn("Name");
        defaultTableModel3.addColumn("PurcharPrice");
        defaultTableModel3.addColumn("SalePrice");
        defaultTableModel3.addColumn("Remaining");
        defaultTableModel3.addColumn("AddDate");
        defaultTableModel3.addColumn("UpdateDate");
        defaultTableModel3.addColumn("IdUpdater");
        defaultTableModel3.addColumn("ProductPlacement");
        defaultTableModel3.addColumn("Genre");
        defaultTableModel3.addColumn("Length");
        defaultTableModel3.addColumn("year");
        defaultTableModel3.addColumn("actor");
        defaultTableModel3.addColumn("director");
        
        
          List<DiscMovie> discMovies= productController.getListDiscMovie();
          for(DiscMovie discMovie : discMovies){
        defaultTableModel3.addRow(new Object[]{discMovie.getId(),discMovie.getCode(),discMovie.getName(),discMovie.getPurchasePrice(),discMovie.getSalePrice(),discMovie.getRemaining(),formatter.format(discMovie.getAddDate()),formatter.format(discMovie.getUpdateDate()),discMovie.getUpdater().getId(),
            discMovie.getProductPlacement(),discMovie.getGenre(),discMovie.getLength(),discMovie.getYear(),discMovie.getActor(),discMovie.getDirector() });
        }
         
        DefaultTableModel defaultTableModel4;
        defaultTableModel4= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        } ;
        listEmployeeJTable.setModel(defaultTableModel4);

        defaultTableModel4.addColumn("ID");
        defaultTableModel4.addColumn("Name");
        defaultTableModel4.addColumn("Phone");
        defaultTableModel4.addColumn("Born");
        defaultTableModel4.addColumn("Salary");
        defaultTableModel4.addColumn("Role");
        defaultTableModel4.addColumn("UserName");
        defaultTableModel4.addColumn("PassWord");
        

        List<Employee> employees= employeeController.getListEmployee();
        for(Employee employee1 : employees){
            defaultTableModel4.addRow(new Object[]{employee1.getId(),employee1.getName(),employee1.getPhone(),employee1.getBorn(),employee1.getSalary(),employee1.getAccount().getRole(),
                employee1.getAccount().getUserName(),employee1.getAccount().getPassword()  });
        }
        
        
        
        customerController= new CustomerController(employee);
        DefaultTableModel defaultTableModel5;
        defaultTableModel5 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        } ;
        
        
        customerJTable1.setModel(defaultTableModel5);
       
        defaultTableModel5.addColumn("ID");
        defaultTableModel5.addColumn("Name");
        defaultTableModel5.addColumn("Born");
        defaultTableModel5.addColumn("Phone");
        defaultTableModel5.addColumn("Point");
          List<Customer> customers= customerController.getListCustomer();
          for(Customer customer: customers){
           defaultTableModel5.addRow(new Object[]{customer.getId(),customer.getName(),customer.getBorn(),customer.getPhone(),customer.getPoint() });
        
          }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
 //SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
 SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeJLabel = new javax.swing.JLabel();
        homeJTablePane = new javax.swing.JTabbedPane();
        bookJPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listBookTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        codeJTextField = new javax.swing.JTextField();
        findJButton = new javax.swing.JButton();
        bookJComboBox2 = new javax.swing.JComboBox<>();
        discMusicjPanel = new javax.swing.JPanel();
        discMusicJpanel = new javax.swing.JPanel();
        dircMusicjScrollPane3 = new javax.swing.JScrollPane();
        listDiscMusicTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        codeDiscMusicJTextField2 = new javax.swing.JTextField();
        findJButton2 = new javax.swing.JButton();
        discMusicJcombobox = new javax.swing.JComboBox<>();
        discMovieJPanel3 = new javax.swing.JPanel();
        discMovieJPanel = new javax.swing.JPanel();
        discMoviejScrollPane4 = new javax.swing.JScrollPane();
        listDiscMovieJTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        codediscMovieJTextField3 = new javax.swing.JTextField();
        findJButton3 = new javax.swing.JButton();
        discMovieJcombobox1 = new javax.swing.JComboBox<>();
        employeeJPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        userNameSearchJTextField1 = new javax.swing.JTextField();
        findJButton1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listEmployeeJTable = new javax.swing.JTable();
        customerjPanel = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        phonejTextField3 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerJTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        timeJLabel.setText("time:");

        homeJTablePane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeJTablePaneMouseClicked(evt);
            }
        });

        listBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(listBookTable);

        jButton10.setText("Thêm mới");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton9.setText("Chỉnh sửa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        codeJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeJTextFieldActionPerformed(evt);
            }
        });

        findJButton.setText("Tìm kiếm");
        findJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findJButtonActionPerformed(evt);
            }
        });

        bookJComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sản phẩm", "Tên sản phẩm" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(bookJComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(findJButton)
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findJButton)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(bookJComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout bookJPanelLayout = new javax.swing.GroupLayout(bookJPanel);
        bookJPanel.setLayout(bookJPanelLayout);
        bookJPanelLayout.setHorizontalGroup(
            bookJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1584, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookJPanelLayout.setVerticalGroup(
            bookJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookJPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        homeJTablePane.addTab("Sách", bookJPanel);

        listDiscMusicTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        dircMusicjScrollPane3.setViewportView(listDiscMusicTable1);

        jButton13.setText("Thêm mới");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Chỉnh sửa");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        codeDiscMusicJTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeDiscMusicJTextField2ActionPerformed(evt);
            }
        });

        findJButton2.setText("Tìm kiếm");
        findJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findJButton2ActionPerformed(evt);
            }
        });

        discMusicJcombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sản phẩm", "Tên sản phẩm" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(discMusicJcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(codeDiscMusicJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(findJButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton14)
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addContainerGap(934, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeDiscMusicJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findJButton2)
                    .addComponent(jButton14)
                    .addComponent(jButton13)
                    .addComponent(discMusicJcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout discMusicJpanelLayout = new javax.swing.GroupLayout(discMusicJpanel);
        discMusicJpanel.setLayout(discMusicJpanelLayout);
        discMusicJpanelLayout.setHorizontalGroup(
            discMusicJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dircMusicjScrollPane3)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        discMusicJpanelLayout.setVerticalGroup(
            discMusicJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discMusicJpanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(dircMusicjScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout discMusicjPanelLayout = new javax.swing.GroupLayout(discMusicjPanel);
        discMusicjPanel.setLayout(discMusicjPanelLayout);
        discMusicjPanelLayout.setHorizontalGroup(
            discMusicjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1584, Short.MAX_VALUE)
            .addGroup(discMusicjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(discMusicjPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(discMusicJpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        discMusicjPanelLayout.setVerticalGroup(
            discMusicjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
            .addGroup(discMusicjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(discMusicjPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(discMusicJpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        homeJTablePane.addTab("Đĩa nhạc", discMusicjPanel);

        listDiscMovieJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        discMoviejScrollPane4.setViewportView(listDiscMovieJTable);

        jButton15.setText("Thêm mới");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Chỉnh sửa");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        codediscMovieJTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codediscMovieJTextField3ActionPerformed(evt);
            }
        });

        findJButton3.setText("Tìm kiếm");
        findJButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findJButton3ActionPerformed(evt);
            }
        });

        discMovieJcombobox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sản phẩm", "Tên sản phẩm" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(discMovieJcombobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(codediscMovieJTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(findJButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton16)
                .addGap(18, 18, 18)
                .addComponent(jButton15)
                .addContainerGap(934, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codediscMovieJTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findJButton3)
                    .addComponent(jButton16)
                    .addComponent(jButton15)
                    .addComponent(discMovieJcombobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout discMovieJPanelLayout = new javax.swing.GroupLayout(discMovieJPanel);
        discMovieJPanel.setLayout(discMovieJPanelLayout);
        discMovieJPanelLayout.setHorizontalGroup(
            discMovieJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(discMoviejScrollPane4)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        discMovieJPanelLayout.setVerticalGroup(
            discMovieJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discMovieJPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(discMoviejScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout discMovieJPanel3Layout = new javax.swing.GroupLayout(discMovieJPanel3);
        discMovieJPanel3.setLayout(discMovieJPanel3Layout);
        discMovieJPanel3Layout.setHorizontalGroup(
            discMovieJPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1584, Short.MAX_VALUE)
            .addGroup(discMovieJPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(discMovieJPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(discMovieJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        discMovieJPanel3Layout.setVerticalGroup(
            discMovieJPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
            .addGroup(discMovieJPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(discMovieJPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(discMovieJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        homeJTablePane.addTab("Đĩa phim", discMovieJPanel3);

        jLabel8.setText("UserName :");

        userNameSearchJTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameSearchJTextField1ActionPerformed(evt);
            }
        });

        findJButton1.setText("Tìm kiếm");
        findJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findJButton1ActionPerformed(evt);
            }
        });

        jButton11.setText("Chỉnh sửa");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Thêm mới");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        listEmployeeJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(listEmployeeJTable);

        javax.swing.GroupLayout employeeJPanelLayout = new javax.swing.GroupLayout(employeeJPanel);
        employeeJPanel.setLayout(employeeJPanelLayout);
        employeeJPanelLayout.setHorizontalGroup(
            employeeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeJPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(employeeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1567, Short.MAX_VALUE)
                    .addGroup(employeeJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userNameSearchJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(findJButton1)
                        .addGap(71, 71, 71)
                        .addComponent(jButton11)
                        .addGap(68, 68, 68)
                        .addComponent(jButton12)
                        .addContainerGap())))
        );
        employeeJPanelLayout.setVerticalGroup(
            employeeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeJPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(employeeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(userNameSearchJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findJButton1)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        homeJTablePane.addTab("quản lý nhân viên", employeeJPanel);

        jButton7.setText("Tạo mới khách hàng");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Số điện thoại", "Họ và tên" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton8.setText("Tra thông tin");

        customerJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(customerJTable1);

        javax.swing.GroupLayout customerjPanelLayout = new javax.swing.GroupLayout(customerjPanel);
        customerjPanel.setLayout(customerjPanelLayout);
        customerjPanelLayout.setHorizontalGroup(
            customerjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerjPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(customerjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(customerjPanelLayout.createSequentialGroup()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phonejTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton8)
                        .addGap(101, 101, 101)
                        .addComponent(jButton7)
                        .addGap(0, 914, Short.MAX_VALUE)))
                .addContainerGap())
        );
        customerjPanelLayout.setVerticalGroup(
            customerjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerjPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(customerjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(phonejTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        homeJTablePane.addTab("Quản lý khách hàng ", customerjPanel);

        jLabel6.setText("Nhân viên:");

        jButton1.setText("báo cáo tài chính");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Hóa đơn nhập hàng mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(timeJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2))
                    .addComponent(homeJTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(timeJLabel)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeJTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new FinanceForm(employee).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void homeJTablePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeJTablePaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_homeJTablePaneMouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        customerController= new CustomerController(employee);
        if (phonejTextField3.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại khách hàng cần thêm");
        }
        else{
            if (customerController.getCustomerByPhone(phonejTextField3.getText())!= null ){
                JOptionPane.showMessageDialog(null, "Mã sản phẩm đã tồn tại \n Vui  lòng nhập mã sản phẩm khác hoặc lựa chọn chức năng chỉnh sửa");
            }
            else{
                new CustomerForm(phonejTextField3.getText(),employee).setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:

        new EmployeeForm(employee).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        employeeController = new EmployeeController(employee);
        String userName= userNameSearchJTextField1.getText();

        if ( employeeController.getEmployeeByUserName(userName)!= null ){
            new EmployeeFormEdit(employeeController.getEmployeeByUserName(userName), employee).setVisible(true);
            this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Mã nhân viên chưa tồn tại");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void findJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findJButton1ActionPerformed
        // TODO add your handling code here:
        employeeController = new EmployeeController(employee);
        DefaultTableModel defaultTableModel;
        defaultTableModel= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        } ;
        listEmployeeJTable.setModel(defaultTableModel);

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Phone");
        defaultTableModel.addColumn("Born");
        defaultTableModel.addColumn("Salary");
        defaultTableModel.addColumn("Role");
        defaultTableModel.addColumn("UserName");
        defaultTableModel.addColumn("PassWord");

        try {
            employee = employeeController.getEmployeeByUserName(userNameSearchJTextField1.getText());
            defaultTableModel.addRow(new Object[]{employee.getId(),employee.getName(),employee.getPhone(),employee.getBorn(),employee.getSalary(),employee.getAccount().getRole(),
                employee.getAccount().getUserName(),employee.getAccount().getPassword()  });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhap lai ma nhan vien");
        }
    }//GEN-LAST:event_findJButton1ActionPerformed

    private void userNameSearchJTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameSearchJTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameSearchJTextField1ActionPerformed

    private void findJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findJButton3ActionPerformed
        // TODO add your handling code here:
        productController= new ProductController(employee);
        DefaultTableModel defaultTableModel;
        defaultTableModel= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        } ;
        listDiscMovieJTable.setModel(defaultTableModel);

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Code");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("PurcharPrice");
        defaultTableModel.addColumn("SalePrice");
        defaultTableModel.addColumn("Remaining");
        defaultTableModel.addColumn("AddDate");
        defaultTableModel.addColumn("UpdateDate");
        defaultTableModel.addColumn("IdUpdater");
        defaultTableModel.addColumn("ProductPlacement");
        defaultTableModel.addColumn("Genre");
        defaultTableModel.addColumn("Length");
        defaultTableModel.addColumn("year");
        defaultTableModel.addColumn("actor");
        defaultTableModel.addColumn("director");

        if ( discMovieJcombobox1.getSelectedItem().equals("Tên sản phẩm") ){
            List<DiscMovie> discMovies= productController.getDiscMovieByName(codediscMovieJTextField3.getText());
            for(DiscMovie discMovie : discMovies){
                defaultTableModel.addRow(new Object[]{discMovie.getId(),discMovie.getCode(),discMovie.getName(),discMovie.getPurchasePrice(),discMovie.getSalePrice(),discMovie.getRemaining(),formatter.format(discMovie.getAddDate()),formatter.format(discMovie.getUpdateDate()),discMovie.getUpdater().getId(),
                    discMovie.getProductPlacement(),discMovie.getGenre(),discMovie.getLength(),discMovie.getYear(),discMovie.getActor(),discMovie.getDirector() });
        }
        }
        else{

            try {
                DiscMovie discMovie= productController.getDiscMovieByCode(codediscMovieJTextField3.getText());
                defaultTableModel.addRow(new Object[]{discMovie.getId(),discMovie.getCode(),discMovie.getName(),discMovie.getPurchasePrice(),discMovie.getSalePrice(),discMovie.getRemaining(),formatter.format(discMovie.getAddDate()),formatter.format(discMovie.getUpdateDate()),discMovie.getUpdater().getId(),
                    discMovie.getProductPlacement(),discMovie.getGenre(),discMovie.getLength(),discMovie.getYear(),discMovie.getActor(),discMovie.getDirector() });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhập lại mã sản phẩm: ");
        }

        }
    }//GEN-LAST:event_findJButton3ActionPerformed

    private void codediscMovieJTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codediscMovieJTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codediscMovieJTextField3ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        if ( discMovieJcombobox1.getSelectedItem().equals("Tên sản phẩm") ){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn mã sản phẩm để chỉnh sửa");
        }
        else{
            productController= new ProductController(employee);
            String code= codediscMovieJTextField3.getText();

            if ( productController.getDiscMovieByCode(code)!= null ){
                new DiscMovieFormEdit( productController.getDiscMovieByCode(code),employee).setVisible(true);
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Mã sản phẩm chưa tồn tại");
            }
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        if ( String.valueOf(discMovieJcombobox1.getSelectedItem()).equals("Tên sản phẩm") ){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn mã sản phẩm để thêm mới");
        }
        else{
            productController = new ProductController(employee);
            if (codediscMovieJTextField3.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sản phẩm bạn muốn thêm");
            }
            else{
                if (productController.getDiscMovieByCode(codeDiscMusicJTextField2.getText())!= null ){
                    JOptionPane.showMessageDialog(null, "Mã sản phẩm đã tồn tại \n Vui  lòng nhập mã sản phẩm khác hoặc lựa chọn chức năng chỉnh sửa");
                }
                else{
                    new DiscMovieForm(codediscMovieJTextField3.getText(),employee).setVisible(true);
                    this.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void findJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findJButton2ActionPerformed
        // TODO add your handling code here:
        productController= new ProductController(employee);
        DefaultTableModel defaultTableModel;
        defaultTableModel= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        } ;
        listDiscMusicTable1.setModel(defaultTableModel);

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Code");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("PurcharPrice");
        defaultTableModel.addColumn("SalePrice");
        defaultTableModel.addColumn("Remaining");
        defaultTableModel.addColumn("AddDate");
        defaultTableModel.addColumn("UpdateDate");
        defaultTableModel.addColumn("IdUpdater");
        defaultTableModel.addColumn("ProductPlacement");
        defaultTableModel.addColumn("Genre");
        defaultTableModel.addColumn("Singer");

        if ( discMusicJcombobox.getSelectedItem().equals("Tên sản phẩm") ){
            List<DiscMusic> listDiscMusics= productController.getDiscMusicsByName(codeDiscMusicJTextField2.getText());
            for(DiscMusic discMusic : listDiscMusics){

                defaultTableModel.addRow(new Object[]{discMusic.getId(),discMusic.getCode(),discMusic.getName(),discMusic.getPurchasePrice(),discMusic.getSalePrice(),discMusic.getRemaining(),formatter.format(discMusic.getAddDate()),formatter.format(discMusic.getUpdateDate()),discMusic.getUpdater().getId(),
                    discMusic.getProductPlacement(),discMusic.getGenre(),discMusic.getSinger()  });
        }
        }
        else{

            try {
                DiscMusic discMusic = productController.getDiscMusicByCode(codeDiscMusicJTextField2.getText());
                defaultTableModel.addRow(new Object[]{discMusic.getId(),discMusic.getCode(),discMusic.getName(),discMusic.getPurchasePrice(),discMusic.getSalePrice(),discMusic.getRemaining(),formatter.format(discMusic.getAddDate()),formatter.format(discMusic.getUpdateDate()),discMusic.getUpdater().getId(),
                    discMusic.getProductPlacement(),discMusic.getGenre(),discMusic.getSinger()  });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhập lại mã sản phẩm: ");
        }

        }
    }//GEN-LAST:event_findJButton2ActionPerformed

    private void codeDiscMusicJTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeDiscMusicJTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeDiscMusicJTextField2ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        productController= new ProductController(employee);
        String code= codeDiscMusicJTextField2.getText();

        if ( discMusicJcombobox.getSelectedItem().equals("Tên sản phẩm") ){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn mã sản phẩm để chỉnh sửa");
        }
        else{

            if ( productController.getDiscMusicByCode(code)!= null ){
                new DiscMusicFormEdit(productController.getDiscMusicByCode(code),employee).setVisible(true);
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Mã sản phẩm chưa tồn tại");
            }
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if ( String.valueOf(discMusicJcombobox.getSelectedItem()).equals("Tên sản phẩm") ){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn mã sản phẩm để thêm mới");
        }
        else{
            productController = new ProductController(employee);
            if (codeDiscMusicJTextField2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sản phẩm bạn muốn thêm");
            }
            else{
                if (productController.getDiscMusicByCode(codeDiscMusicJTextField2.getText())!= null ){
                    JOptionPane.showMessageDialog(null, "Mã sản phẩm đã tồn tại \n Vui  lòng nhập mã sản phẩm khác hoặc lựa chọn chức năng chỉnh sửa");
                }
                else{
                    new DiscMusicForm(codeDiscMusicJTextField2.getText(),employee).setVisible(true);
                    this.setVisible(false);
                }

            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void findJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findJButtonActionPerformed
        // TODO add your handling code here:
        productController= new ProductController(employee);
        DefaultTableModel defaultTableModel;
        defaultTableModel= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        } ;
        listBookTable.setModel(defaultTableModel);

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Code");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("PurcharPrice");
        defaultTableModel.addColumn("SalePrice");
        defaultTableModel.addColumn("Remaining");
        defaultTableModel.addColumn("AddDate");
        defaultTableModel.addColumn("UpdateDate");
        defaultTableModel.addColumn("IdUpdater");
        defaultTableModel.addColumn("ProductPlacement");
        defaultTableModel.addColumn("Category");
        defaultTableModel.addColumn("Publisher");
        defaultTableModel.addColumn("Author");

        if ( bookJComboBox2.getSelectedItem().equals("Tên sản phẩm") ){
            List<Book> books= productController.getBooksByName(codeJTextField.getText());
            for(Book book : books){
                defaultTableModel.addRow(new Object[]{book.getId(),book.getCode(),book.getName(),book.getPurchasePrice(),book.getSalePrice(),book.getRemaining(),formatter.format(book.getAddDate()),formatter.format(book.getUpdateDate()),book.getUpdater().getId(),
                    book.getProductPlacement(),book.getCategory(),book.getPublisher(),book.getAuthor()  });
        }
        }
        else{

            try {
                Book book= productController.getBookByCode(codeJTextField.getText());
                defaultTableModel.addRow(new Object[]{book.getId(),book.getCode(),book.getName(),book.getPurchasePrice(),book.getSalePrice(),book.getRemaining(),book.getAddDate(),book.getUpdateDate(),book.getUpdater().getId(),
                    book.getProductPlacement(),book.getCategory(),book.getPublisher(),book.getAuthor()  });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nhập lại mã sản phẩm: ");
        }

        }
    }//GEN-LAST:event_findJButtonActionPerformed

    private void codeJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeJTextFieldActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if ( bookJComboBox2.getSelectedItem().equals("Tên sản phẩm") ){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn mã sản phẩm để chỉnh sửa");
        }
        else{
            productController= new ProductController(employee);
            String code= codeJTextField.getText();

            if ( productController.getBookByCode(code)!= null ){
                new BookFormEdit(productController.getBookByCode(code),employee).setVisible(true);
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Mã sản phẩm chưa tồn tại");
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if ( String.valueOf(bookJComboBox2.getSelectedItem()).equals("Tên sản phẩm") ){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn mã sản phẩm để thêm mới");
        }
        else{
            productController = new ProductController(employee);
            if (codeJTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sản phẩm bạn muốn thêm");
            }
            else{
                if (productController.getBookByCode(codeJTextField.getText())!= null ){
                    JOptionPane.showMessageDialog(null, "Mã sản phẩm đã tồn tại \n Vui  lòng nhập mã sản phẩm khác hoặc lựa chọn chức năng chỉnh sửa");
                }
                else{
                    new BookForm(codeJTextField.getText(),employee).setVisible(true);
                    this.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new BuyBill(employee).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bookJComboBox2;
    private javax.swing.JPanel bookJPanel;
    private javax.swing.JTextField codeDiscMusicJTextField2;
    private javax.swing.JTextField codeJTextField;
    private javax.swing.JTextField codediscMovieJTextField3;
    private javax.swing.JTable customerJTable1;
    private javax.swing.JPanel customerjPanel;
    private javax.swing.JScrollPane dircMusicjScrollPane3;
    private javax.swing.JPanel discMovieJPanel;
    private javax.swing.JPanel discMovieJPanel3;
    private javax.swing.JComboBox<String> discMovieJcombobox1;
    private javax.swing.JScrollPane discMoviejScrollPane4;
    private javax.swing.JComboBox<String> discMusicJcombobox;
    private javax.swing.JPanel discMusicJpanel;
    private javax.swing.JPanel discMusicjPanel;
    private javax.swing.JPanel employeeJPanel;
    private javax.swing.JButton findJButton;
    private javax.swing.JButton findJButton1;
    private javax.swing.JButton findJButton2;
    private javax.swing.JButton findJButton3;
    private javax.swing.JTabbedPane homeJTablePane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable listBookTable;
    private javax.swing.JTable listDiscMovieJTable;
    private javax.swing.JTable listDiscMusicTable1;
    private javax.swing.JTable listEmployeeJTable;
    private javax.swing.JTextField phonejTextField3;
    private javax.swing.JLabel timeJLabel;
    private javax.swing.JTextField userNameSearchJTextField1;
    // End of variables declaration//GEN-END:variables
}
