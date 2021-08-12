/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author NguyenManhCuong
 */
public class FormStart extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private void connect() {
        try {
            cnn = (new DBContext().getConnection());
            System.out.println("Connect Successfully!");
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            System.out.println("Lỗi connect: " + e.getMessage());
        }
    }

    public FormStart() {
        initComponents();
        connect();
        this.setContentPane(new Login());
        setTitle("Login");
        this.pack();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ItemLogin = new javax.swing.JMenuItem();
        ItemRegister = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        ItemProduct = new javax.swing.JMenuItem();
        IteamCustomer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Account");

        ItemLogin.setText("Login");
        ItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemLoginActionPerformed(evt);
            }
        });
        jMenu1.add(ItemLogin);

        ItemRegister.setText("Register");
        ItemRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemRegisterActionPerformed(evt);
            }
        });
        jMenu1.add(ItemRegister);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Database");

        ItemProduct.setText("Product");
        ItemProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemProductActionPerformed(evt);
            }
        });
        jMenu2.add(ItemProduct);

        IteamCustomer.setText("Customer");
        IteamCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IteamCustomerActionPerformed(evt);
            }
        });
        jMenu2.add(IteamCustomer);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemLoginActionPerformed
        try {
            // TODO add your handling code here:
            rs = stm.executeQuery("SELECT *FROM dbo.tblUser ");
            int check = 0;
            while (rs.next()) {
                check = rs.getInt(9);
                if (check == 1) {
                    this.setContentPane(new Login());
                    setTitle("Login");
                    this.pack();
                    this.setVisible(true);
                    return;
                }
            }

        } catch (Exception e) {
            System.out.println("Lỗi login trong Start:" + e.getMessage());
        }
    }//GEN-LAST:event_ItemLoginActionPerformed

    private void ItemRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemRegisterActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            rs = stm.executeQuery("SELECT *FROM dbo.tblUser ");
            int check = 0;
            while (rs.next()) {
                check = rs.getInt(9);
                if (check == 1) {
                    this.setContentPane(new Register());
                    setTitle("Register");
                    this.pack();
                    this.setVisible(true);
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi login trong Start:" + e.getMessage());
        }
    }//GEN-LAST:event_ItemRegisterActionPerformed
// Khai báo các thành phần xử lý DB
    Connection cnn;// Kết nối CSDL
    Statement stm; // Thực hiện câu lệnh SQL
    ResultSet rs; // Lưu trữ và xử lý dư liệu
    private void ItemProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemProductActionPerformed
        try {
            // TODO add your handling code here:
            int check = 0;
            rs = stm.executeQuery("SELECT *FROM dbo.tblUser ");
            while (rs.next()) {
                check = rs.getInt(8);
                if (check == 1) {
                    this.setContentPane(new mainForm(1));
                    setTitle("Welcome to admin");
                    this.pack();
                    this.setVisible(true);
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi select hàm ItemProduct:" + e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Bạn cần đăng nhập để thực hiện chức năng này !");
        return;
    }//GEN-LAST:event_ItemProductActionPerformed

    private void IteamCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IteamCustomerActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int check = 0;
            rs = stm.executeQuery("SELECT *FROM dbo.tblUser ");
            while (rs.next()) {
                check = rs.getInt(8);
                if (check == 1) {
                    this.setContentPane(new mainForm(2));
                    setTitle("Welcome to admin");
                    this.pack();
                    this.setVisible(true);
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi select IteamCustomer:" + e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Bạn cần đăng nhập để thực hiện chức năng này !");
        return;
    }//GEN-LAST:event_IteamCustomerActionPerformed

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
            java.util.logging.Logger.getLogger(FormStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormStart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem IteamCustomer;
    private javax.swing.JMenuItem ItemLogin;
    private javax.swing.JMenuItem ItemProduct;
    private javax.swing.JMenuItem ItemRegister;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
