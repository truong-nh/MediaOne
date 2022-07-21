/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Controller.BillController;
import Controller.CustomerController;
import view.bookform.BookFormEdit;
import view.bookform.BookForm;
import view.clock.ClockThread;
import Controller.ProductController;
import Product.Book;
import Product.DiscMovie;
import Product.DiscMusic;
import bill.Bill;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import person.Customer;
import person.Employee;
import view.bill.OrderBill;
import view.customerform.CustomerForm;
import view.discMovieForm.DiscMovieForm;
import view.discMovieForm.DiscMovieFormEdit;
import view.discmusicform.DiscMusicForm;
import view.discmusicform.DiscMusicFormEdit;

/**
 *
 * @author Admin
 */
public class EmployeeHome extends javax.swing.JFrame {
    ProductController productController;
    CustomerController customerController;
    BillController billController;
    Employee employee;
    /**
     * Creates new form EmployeeHome
     */
    public EmployeeHome() {
        initComponents();
        
    }
    public EmployeeHome(Employee employee)  {
        productController= new ProductController(employee);
        this.employee=employee;
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
        
          DefaultTableModel defaultTableModel6;
        defaultTableModel6 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        } ;
        orderJTable.setModel(defaultTableModel6);
       
       // defaultTableModel6.addColumn("ID");
        defaultTableModel6.addColumn("Mã sản phẩm");
        defaultTableModel6.addColumn("Tên sản phẩm");
        defaultTableModel6.addColumn("Số lượng");
        defaultTableModel6.addColumn("Đơn giá");
        defaultTableModel6.addColumn("Thành tiền");
          
          
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeJLabel = new javax.swing.JLabel();
        homeJTablePane = new javax.swing.JTabbedPane();
        bookJPanel = new javax.swing.JPanel();
        bookjScrollPane = new javax.swing.JScrollPane();
        listBookTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        codeJTextField = new javax.swing.JTextField();
        findJButton = new javax.swing.JButton();
        bookJComboBox2 = new javax.swing.JComboBox<>();
        discMusicJpanel = new javax.swing.JPanel();
        dircMusicjScrollPane3 = new javax.swing.JScrollPane();
        listDiscMusicTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        codeDiscMusicJTextField2 = new javax.swing.JTextField();
        findJButton2 = new javax.swing.JButton();
        discMusicJcombobox = new javax.swing.JComboBox<>();
        discMovieJPanel = new javax.swing.JPanel();
        discMoviejScrollPane4 = new javax.swing.JScrollPane();
        listDiscMovieJTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        codediscMovieJTextField3 = new javax.swing.JTextField();
        findJButton3 = new javax.swing.JButton();
        discMovieJcombobox1 = new javax.swing.JComboBox<>();
        customerjPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        phonejTextField = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerJTable1 = new javax.swing.JTable();
        GioHang = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        phoneCustomerOrderJTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ordercodeJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        orderAmoutJTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderJTable = new javax.swing.JTable();
        addOrderJButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        deleteOrderJButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        newOrderJButton = new javax.swing.JButton();

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
        bookjScrollPane.setViewportView(listBookTable);

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
                .addContainerGap()
                .addComponent(bookJComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
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
            .addComponent(bookjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1598, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookJPanelLayout.setVerticalGroup(
            bookJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookJPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(bookjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
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
                .addContainerGap(948, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        discMusicJpanelLayout.setVerticalGroup(
            discMusicJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discMusicJpanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(dircMusicjScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
        );

        homeJTablePane.addTab("Đĩa nhạc", discMusicJpanel);

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
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
                .addContainerGap(948, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, discMovieJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(discMoviejScrollPane4)
                .addContainerGap())
        );
        discMovieJPanelLayout.setVerticalGroup(
            discMovieJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discMovieJPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(discMoviejScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
        );

        homeJTablePane.addTab("Đĩa phim", discMovieJPanel);

        jButton3.setText("Tạo mới khách hàng");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setText("Tra thông tin");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setText("Số điện thoại :");

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
        customerJTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(customerJTable1);

        javax.swing.GroupLayout customerjPanel1Layout = new javax.swing.GroupLayout(customerjPanel1);
        customerjPanel1.setLayout(customerjPanel1Layout);
        customerjPanel1Layout.setHorizontalGroup(
            customerjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerjPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(phonejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton6)
                .addGap(76, 76, 76)
                .addComponent(jButton3)
                .addContainerGap(959, Short.MAX_VALUE))
            .addGroup(customerjPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        customerjPanel1Layout.setVerticalGroup(
            customerjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerjPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(customerjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(phonejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(jLabel1))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
        );

        homeJTablePane.addTab("Khách hàng", customerjPanel1);

        jLabel2.setText("Số điện thoại khách hàng");

        phoneCustomerOrderJTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneCustomerOrderJTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Mã sản phẩm:");

        ordercodeJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordercodeJTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Số lượng: ");

        orderAmoutJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderAmoutJTextFieldActionPerformed(evt);
            }
        });

        orderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(orderJTable);

        addOrderJButton.setText("Thêm");
        addOrderJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderJButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa");

        deleteOrderJButton.setText("Xóa");
        deleteOrderJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOrderJButtonActionPerformed(evt);
            }
        });

        jButton4.setText("Xuất hóa đơn");

        jButton5.setText("Hủy hóa đơn");

        jLabel5.setText("Tổng cộng: ");

        jButton1.setText("Thanh toán");

        javax.swing.GroupLayout GioHangLayout = new javax.swing.GroupLayout(GioHang);
        GioHang.setLayout(GioHangLayout);
        GioHangLayout.setHorizontalGroup(
            GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GioHangLayout.createSequentialGroup()
                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GioHangLayout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 633, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(260, 260, 260)
                        .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GioHangLayout.createSequentialGroup()
                        .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GioHangLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(addOrderJButton)
                                .addGap(130, 130, 130)
                                .addComponent(jButton2))
                            .addGroup(GioHangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ordercodeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderAmoutJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteOrderJButton)
                            .addComponent(phoneCustomerOrderJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1031, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        GioHangLayout.setVerticalGroup(
            GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GioHangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(phoneCustomerOrderJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ordercodeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(orderAmoutJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addOrderJButton)
                    .addComponent(jButton2)
                    .addComponent(deleteOrderJButton))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(7, 7, 7)
                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        homeJTablePane.addTab("Giỏ Hàng", GioHang);

        jLabel6.setText("Nhân viên:");

        newOrderJButton.setText("Hóa đơn bán hàng mới");
        newOrderJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(468, 468, 468)
                        .addComponent(timeJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(newOrderJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(homeJTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(newOrderJButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeJLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeJTablePane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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

    private void codeJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeJTextFieldActionPerformed

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

    private void phoneCustomerOrderJTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneCustomerOrderJTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneCustomerOrderJTextField2ActionPerformed

    private void ordercodeJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordercodeJTextFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_ordercodeJTextFieldActionPerformed

    private void orderAmoutJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderAmoutJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderAmoutJTextFieldActionPerformed

    private void addOrderJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderJButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_addOrderJButtonActionPerformed

    private void deleteOrderJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrderJButtonActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_deleteOrderJButtonActionPerformed
    private void newOrderJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderJButtonActionPerformed
        // TODO add your handling code here:
       new OrderBill(employee).setVisible(true);
    }//GEN-LAST:event_newOrderJButtonActionPerformed

    private void homeJTablePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeJTablePaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_homeJTablePaneMouseClicked

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

    private void codeDiscMusicJTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeDiscMusicJTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeDiscMusicJTextField2ActionPerformed

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

    private void codediscMovieJTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codediscMovieJTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codediscMovieJTextField3ActionPerformed

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
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         customerController= new CustomerController(employee);
         
        DefaultTableModel defaultTableModel;
        defaultTableModel= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        } ;
        customerJTable1.setModel(defaultTableModel);

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Born");
        defaultTableModel.addColumn("Phone");
        defaultTableModel.addColumn("Point");
        
        try {
            Customer customer = customerController.getCustomerByPhone(phonejTextField.getText());
        defaultTableModel.addRow(new Object[]{customer.getId(),customer.getName(),customer.getBorn(),customer.getPhone(),customer.getId()  });
        
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không tồn tại số điện thoại:  "+phonejTextField.getText());
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        customerController= new CustomerController(employee);
        if (phonejTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại khách hàng cần thêm");
        }
        else{
          if (customerController.getCustomerByPhone(phonejTextField.getText())!= null ){
              JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại \n Vui lòng nhập số điện thoại khác hoặc lựa chọn chức năng chỉnh sửa");
          }
        else{
        new CustomerForm(phonejTextField.getText(),employee).setVisible(true);
        this.setVisible(false);
        }   
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GioHang;
    private javax.swing.JButton addOrderJButton;
    private javax.swing.JComboBox<String> bookJComboBox2;
    private javax.swing.JPanel bookJPanel;
    private javax.swing.JScrollPane bookjScrollPane;
    private javax.swing.JTextField codeDiscMusicJTextField2;
    private javax.swing.JTextField codeJTextField;
    private javax.swing.JTextField codediscMovieJTextField3;
    private javax.swing.JTable customerJTable1;
    private javax.swing.JPanel customerjPanel1;
    private javax.swing.JButton deleteOrderJButton;
    private javax.swing.JScrollPane dircMusicjScrollPane3;
    private javax.swing.JPanel discMovieJPanel;
    private javax.swing.JComboBox<String> discMovieJcombobox1;
    private javax.swing.JScrollPane discMoviejScrollPane4;
    private javax.swing.JComboBox<String> discMusicJcombobox;
    private javax.swing.JPanel discMusicJpanel;
    private javax.swing.JButton findJButton;
    private javax.swing.JButton findJButton2;
    private javax.swing.JButton findJButton3;
    private javax.swing.JTabbedPane homeJTablePane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listBookTable;
    private javax.swing.JTable listDiscMovieJTable;
    private javax.swing.JTable listDiscMusicTable1;
    private javax.swing.JButton newOrderJButton;
    private javax.swing.JTextField orderAmoutJTextField;
    private javax.swing.JTable orderJTable;
    private javax.swing.JTextField ordercodeJTextField;
    private javax.swing.JTextField phoneCustomerOrderJTextField2;
    private javax.swing.JTextField phonejTextField;
    private javax.swing.JLabel timeJLabel;
    // End of variables declaration//GEN-END:variables
}
