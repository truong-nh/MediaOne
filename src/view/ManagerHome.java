/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import view.employeeform.EmployeeForm;
import view.bookform.BookFormEdit;
import view.bookform.BookForm;
import Controller.EmployeeController;
import view.clock.ClockThread;
import Controller.ProductController;
import Product.Book;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import person.Employee;
import view.employeeform.EmployeeFormEdit;

/**
 *
 * @author Admin
 */
public class ManagerHome extends javax.swing.JFrame {
    Employee employee;
    EmployeeController employeeController;
    ProductController productController;
    /**
     * Creates new form EmployeeHome
     */
    public ManagerHome() {
        initComponents();
        
    }
    public ManagerHome(Employee employee)  {
        this.employee=employee;
        initComponents();
        jLabel6.setText("UserName:"+employee.getAccount().getUserName());
        
        ClockThread th= new ClockThread(timeJLabel);
        th.start();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listBookTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        getAllButton = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        codeJTextField = new javax.swing.JTextField();
        findJButton = new javax.swing.JButton();
        bookJComboBox2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        employeeJPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        userNameSearchJTextField1 = new javax.swing.JTextField();
        findJButton1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listEmployeeJTable = new javax.swing.JTable();
        getAllButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        financeJPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

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

        getAllButton.setText("Lấy tất cả");
        getAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllButtonActionPerformed(evt);
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
                .addGap(18, 18, 18)
                .addComponent(getAllButton)
                .addContainerGap(800, Short.MAX_VALUE))
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
                    .addComponent(getAllButton)
                    .addComponent(bookJComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout bookJPanelLayout = new javax.swing.GroupLayout(bookJPanel);
        bookJPanel.setLayout(bookJPanelLayout);
        bookJPanelLayout.setHorizontalGroup(
            bookJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1525, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookJPanelLayout.setVerticalGroup(
            bookJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookJPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        homeJTablePane.addTab("Sách", bookJPanel);

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jButton1)
                .addContainerGap(1302, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(436, Short.MAX_VALUE))
        );

        homeJTablePane.addTab("Đĩa nhạc", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1525, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        homeJTablePane.addTab("Đĩa phim", jPanel3);

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

        getAllButton1.setText("Lấy tất cả");
        getAllButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout employeeJPanelLayout = new javax.swing.GroupLayout(employeeJPanel);
        employeeJPanel.setLayout(employeeJPanelLayout);
        employeeJPanelLayout.setHorizontalGroup(
            employeeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeJPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(employeeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1508, Short.MAX_VALUE)
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
                        .addGap(42, 42, 42)
                        .addComponent(getAllButton1)
                        .addGap(629, 629, 629))))
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
                    .addComponent(jButton12)
                    .addComponent(getAllButton1))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        homeJTablePane.addTab("quản lý nhân viên", employeeJPanel);

        jButton7.setText("Tất cả khách hàng");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Số điện thoại", "Họ và tên" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton8.setText("Tra thông tin");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton8)
                .addGap(101, 101, 101)
                .addComponent(jButton7)
                .addContainerGap(873, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addContainerGap(424, Short.MAX_VALUE))
        );

        homeJTablePane.addTab("Quản lý khách hàng ", jPanel5);

        javax.swing.GroupLayout financeJPanelLayout = new javax.swing.GroupLayout(financeJPanel);
        financeJPanel.setLayout(financeJPanelLayout);
        financeJPanelLayout.setHorizontalGroup(
            financeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1525, Short.MAX_VALUE)
        );
        financeJPanelLayout.setVerticalGroup(
            financeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        homeJTablePane.addTab("quản lý tài chính", financeJPanel);

        jLabel6.setText("Nhân viên:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(468, 468, 468)
                        .addComponent(timeJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(homeJTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeJLabel)
                        .addGap(14, 14, 14)))
                .addComponent(homeJTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeJTablePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeJTablePaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_homeJTablePaneMouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void getAllButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllButton1ActionPerformed
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
        

        List<Employee> employees= employeeController.getListEmployee();
        for(Employee employee : employees){
            defaultTableModel.addRow(new Object[]{employee.getId(),employee.getName(),employee.getPhone(),employee.getBorn(),employee.getSalary(),employee.getAccount().getRole(),
                employee.getAccount().getUserName(),employee.getAccount().getPassword()  });
        }
    }//GEN-LAST:event_getAllButton1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
       
        new EmployeeForm(employee).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed

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
        defaultTableModel.addRow(new Object[]{book.getId(),book.getCode(),book.getName(),book.getPurchasePrice(),book.getSalePrice(),book.getRemaining(),book.getAddDate(),book.getUpdateDate(),book.getUpdater().getId(),
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

    private void getAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllButtonActionPerformed
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

        
        List<Book> books = productController.getListBook();
        for(Book book : books){
        defaultTableModel.addRow(new Object[]{book.getId(),book.getCode(),book.getName(),book.getPurchasePrice(),book.getSalePrice(),book.getRemaining(),book.getAddDate(),book.getUpdateDate(),book.getUpdater().getId(),
            book.getProductPlacement(),book.getCategory(),book.getPublisher(),book.getAuthor()  });
        }
    }//GEN-LAST:event_getAllButtonActionPerformed

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
    private javax.swing.JTextField codeJTextField;
    private javax.swing.JPanel employeeJPanel;
    private javax.swing.JPanel financeJPanel;
    private javax.swing.JButton findJButton;
    private javax.swing.JButton findJButton1;
    private javax.swing.JButton getAllButton;
    private javax.swing.JButton getAllButton1;
    private javax.swing.JTabbedPane homeJTablePane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable listBookTable;
    private javax.swing.JTable listEmployeeJTable;
    private javax.swing.JLabel timeJLabel;
    private javax.swing.JTextField userNameSearchJTextField1;
    // End of variables declaration//GEN-END:variables
}
