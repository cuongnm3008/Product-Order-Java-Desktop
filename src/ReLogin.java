/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author NguyenManhCuong
 */
public class ReLogin extends javax.swing.JPanel {

    Connection cnn;// Kết nối CSDL
    Statement stm; // Thực hiện câu lệnh SQL
    ResultSet rs; // Lưu trữ và xử lý dư liệu

    private void connect() {
        try {
            cnn = (new DBContext().getConnection());
            System.out.println("Connect Successfully!");
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            System.out.println("Lỗi connect: " + e.getMessage());
        }
    }
    /**
     * Creates new form ReLogin
     */
    String captcha = "";

    public ReLogin() {
        initComponents();
        connect();
        captcha = generateCaptcha();
        txtCaptcha.setText(captcha);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtEnterCaptcha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCaptcha = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel3.setText("Captcha:");

        txtEnterCaptcha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnterCaptchaActionPerformed(evt);
            }
        });

        jLabel4.setText("Enter Captcha:");

        txtCaptcha.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        txtCaptcha.setForeground(new java.awt.Color(51, 0, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEnterCaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnterCaptcha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEnterCaptchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnterCaptchaActionPerformed
        // TODO add your handling code here:
        System.out.println(captcha);
        System.out.println(txtEnterCaptcha.getText());
        if (txtEnterCaptcha.getText().trim().toLowerCase().equalsIgnoreCase(captcha.trim().toLowerCase())) {
            JOptionPane.showMessageDialog(null, "Mời bạn đăng nhập lại ");
            JFrame parent = Common.findParent(this);
            if (parent != null) {
                parent.setContentPane(new Login());
                parent.setTitle("Login");
                parent.pack();
                parent.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nhập sai captcha!\nMời bạn nhập lại");
            captcha = generateCaptcha();
            txtCaptcha.setText(captcha);
            return;
        }
    }//GEN-LAST:event_txtEnterCaptchaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtCaptcha;
    private javax.swing.JTextField txtEnterCaptcha;
    // End of variables declaration//GEN-END:variables
     private static String generateCaptcha() {
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rd = new Random();
        String captcha = new String();
        // loop until to generate success captcha with 6 character
        for (int i = 0; i < 6; i++) {
            char c = alphabet.charAt(rd.nextInt(alphabet.length()));
            captcha += c;
        }
        return captcha;
    }

}
