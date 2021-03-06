/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.bill;

import Controller.CustomerController;
import Controller.BillController;
import Controller.ProductController;
import Product.Product;
import bill.Bill;
import bill.BillType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import person.Customer;
import person.Employee;

/**
 *
 * @author Admin
 */
public class OrderBill extends javax.swing.JFrame {
    ProductController productController;
    BillController billController;
    CustomerController customerController;
    Employee employee;
    Map<Product, Integer> productMaps =  new LinkedHashMap<Product, Integer>( );
    /**
     * Creates new form OrderBill
     */
    public OrderBill(Employee employee,String phone) {
        initComponents();
        this.employee= employee;
        billController= new BillController(employee);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        nhanVienJLabel1.setText("Nhân viên: " + employee.getAccount().getUserName() );
        Bill bill= new Bill();
        phoneCustomerOrderJTextField2.setText(phone);
        phoneCustomerOrderJTextField2.setEnabled(false);
        DefaultTableModel defaultTableModel;
     defaultTableModel= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }         
        } ; 
     orderjTable1.setModel(defaultTableModel);
        
        defaultTableModel.addColumn("Mã sản phẩm");
        defaultTableModel.addColumn("Tên sản phẩm");
        defaultTableModel.addColumn("Số lượng");
        defaultTableModel.addColumn("Đơn giá");
        defaultTableModel.addColumn("Thành tiền");
        
        totalJLabel5.setText( String.valueOf(billController.calculateBillValue(productMaps))) ;
        
        Set<Product> products = productMaps.keySet();
        for(Product product : products){
        defaultTableModel.addRow(new Object[]{ product.getId(),product.getName(),productMaps.get(product),product.getSalePrice(),productMaps.get(product)*product.getSalePrice() });
        }
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GioHang = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        phoneCustomerOrderJTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ordercodeJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        orderAmoutJTextField = new javax.swing.JTextField();
        addOrderJButton = new javax.swing.JButton();
        deleteOrderJButton = new javax.swing.JButton();
        totalJLabel5 = new javax.swing.JLabel();
        newOrderJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderjTable1 = new javax.swing.JTable();
        nhanVienJLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        addOrderJButton.setText("Thêm");
        addOrderJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderJButtonActionPerformed(evt);
            }
        });

        deleteOrderJButton.setText("Xóa");
        deleteOrderJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOrderJButtonActionPerformed(evt);
            }
        });

        totalJLabel5.setText("                     Tổng cộng: ");

        newOrderJButton.setText("Tạo mơi");
        newOrderJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderJButtonActionPerformed(evt);
            }
        });

        orderjTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(orderjTable1);

        nhanVienJLabel1.setText("Nhân viên :");

        jButton5.setText("Hủy hóa đơn");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("Xác nhận xuất hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GioHangLayout = new javax.swing.GroupLayout(GioHang);
        GioHang.setLayout(GioHangLayout);
        GioHangLayout.setHorizontalGroup(
            GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GioHangLayout.createSequentialGroup()
                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GioHangLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(totalJLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(GioHangLayout.createSequentialGroup()
                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GioHangLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(addOrderJButton)
                        .addGap(267, 267, 267)
                        .addComponent(deleteOrderJButton))
                    .addGroup(GioHangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(GioHangLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(ordercodeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nhanVienJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(136, 136, 136)
                        .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(76, 76, 76)
                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderAmoutJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GioHangLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(newOrderJButton))
                    .addComponent(phoneCustomerOrderJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 210, Short.MAX_VALUE))
        );
        GioHangLayout.setVerticalGroup(
            GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GioHangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(phoneCustomerOrderJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nhanVienJLabel1))
                .addGap(24, 24, 24)
                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ordercodeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(orderAmoutJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addOrderJButton)
                    .addComponent(deleteOrderJButton)
                    .addComponent(newOrderJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalJLabel5)
                    .addGroup(GioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        productController = new ProductController(employee);
        try {
            
            Product addProduct= productController.getProductByCode(ordercodeJTextField.getText());
            if(addProduct!= null){
                if(addProduct.getRemaining()>=Integer.parseInt(orderAmoutJTextField.getText())&& Integer.parseInt(orderAmoutJTextField.getText())>=0 ){
        productMaps.put(addProduct, Integer.parseInt(orderAmoutJTextField.getText()) );
            DefaultTableModel defaultTableModel;
     defaultTableModel= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }         
        } ; 
     orderjTable1.setModel(defaultTableModel);
        
        defaultTableModel.addColumn("Mã sản phẩm");
        defaultTableModel.addColumn("Tên sản phẩm");
        defaultTableModel.addColumn("Số lượng");
        defaultTableModel.addColumn("Đơn giá");
        defaultTableModel.addColumn("Thành tiền");
        
        totalJLabel5.setText( String.valueOf(billController.calculateBillValue(productMaps))) ;
        
        Set<Product> products = productMaps.keySet();
        for(Product product : products){
        defaultTableModel.addRow(new Object[]{ product.getCode(),product.getName(),productMaps.get(product),product.getSalePrice(),productMaps.get(product)*product.getSalePrice() });
        }
        }
                else{
                JOptionPane.showMessageDialog(null, "Số lượng sản phẩm ko hợp lệ");
                }
        }
            else{
                JOptionPane.showMessageDialog(null, "Mã sản phẩm không tồn tại");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ");
        }
        
    }//GEN-LAST:event_addOrderJButtonActionPerformed

    private void deleteOrderJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrderJButtonActionPerformed
        // TODO add your handling code here:
      int row = orderjTable1.getSelectedRow();
        if(row == -1) {
           JOptionPane.showMessageDialog(null,"Chọn sản phẩm cần xóa khỏi danh sách");
        }
        else{
          String code = String.valueOf(orderjTable1.getValueAt(row, 0));
          productMaps.remove(productController.getBookByCode(code));
          
          
          DefaultTableModel defaultTableModel;
     defaultTableModel= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }         
        } ; 
        orderjTable1.setModel(defaultTableModel);
        
        defaultTableModel.addColumn("Mã sản phẩm");
        defaultTableModel.addColumn("Tên sản phẩm");
        defaultTableModel.addColumn("Số lượng");
        defaultTableModel.addColumn("Đơn giá");
        defaultTableModel.addColumn("Thành tiền");
        
        totalJLabel5.setText( String.valueOf(billController.calculateBillValue(productMaps))) ;
        Set<Product> products = productMaps.keySet();
        for(Product product : products){
        defaultTableModel.addRow(new Object[]{ product.getCode(),product.getName(),productMaps.get(product),product.getSalePrice(),productMaps.get(product)*product.getSalePrice() });
        }
        }  
    }//GEN-LAST:event_deleteOrderJButtonActionPerformed

    private void newOrderJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderJButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newOrderJButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            billController= new BillController(employee);
        customerController= new CustomerController(employee);
        
        Customer customer = customerController.getCustomerByPhone(phoneCustomerOrderJTextField2.getText());
        Bill bill=billController.addBill(customer, employee, BillType.SELLING);
        
        billController.addItemToBill(bill, productMaps);
        billController.calculateBill(bill);
        billController.pay(bill, 0);
        
        this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(OrderBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(OrderBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(OrderBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(OrderBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new OrderBill().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GioHang;
    private javax.swing.JButton addOrderJButton;
    private javax.swing.JButton deleteOrderJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newOrderJButton;
    private javax.swing.JLabel nhanVienJLabel1;
    private javax.swing.JTextField orderAmoutJTextField;
    private javax.swing.JTextField ordercodeJTextField;
    private javax.swing.JTable orderjTable1;
    private javax.swing.JTextField phoneCustomerOrderJTextField2;
    private javax.swing.JLabel totalJLabel5;
    // End of variables declaration//GEN-END:variables
}
