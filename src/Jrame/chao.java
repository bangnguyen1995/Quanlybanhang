package Jrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class chao extends javax.swing.JFrame {

    /**
     * Creates new form chao
     */
    public chao() {
        initComponents();
        setLocationRelativeTo(null);
        final Timer tmr = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int value = progressBar.getValue();
                if (value < 100) {
                    progressBar.setValue(value + 1);

                } else {
                    chao.this.dispose();
                    new dangnhap().setVisible(true);
                    Thread.currentThread().stop();
                }

            }
        });
        tmr.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        lbllogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý bán hàng");
        setBackground(new java.awt.Color(0, 204, 204));
        setMaximumSize(new java.awt.Dimension(609, 260));
        setMinimumSize(new java.awt.Dimension(609, 260));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        progressBar.setBackground(new java.awt.Color(102, 102, 255));
        progressBar.setForeground(new java.awt.Color(0, 0, 102));
        progressBar.setToolTipText("");
        progressBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        progressBar.setBounds(0, 200, 610, 20);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Loading.....");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(530, 230, 71, 16);

        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/logo.png"))); // NOI18N
        getContentPane().add(lbllogo);
        lbllogo.setBounds(0, -40, 610, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(chao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
