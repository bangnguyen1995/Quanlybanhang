/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jrame;

import Heper.sharehelper;
import dao.sanphamdao;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.sanpham;

/**
 *
 * @author DELL
 */
public class quanlysanpham extends javax.swing.JFrame {

    String filename;

    /**
     * Creates new form quanlysanpham
     */
    public quanlysanpham() {
        initComponents();
        setLocationRelativeTo(null);
        loadDataToTable();
        if (sharehelper.user.isVaitro()) {
            btnThem.setEnabled(true);
        }
        lblLSP.setText("QUẢN LÝ SẢN PHẨM " + sharehelper.loaisanpham.getTenLSP());
    }

    private void loadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) tblSP.getModel();
        model.setRowCount(0);
        try {
            sanphamdao dao = new sanphamdao();

            List<sanpham> list = dao.findAll(sharehelper.loaisanpham.getMaLSP());
            for (sanpham sp : list) {

                model.addRow(new Object[]{
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getGia(),
                    sp.getHinhanh(),
                    sp.getSoluongSP()});
            }
            model.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public boolean check() throws Exception {
        if (txtTenSP.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên sản phẩm");
            txtTenSP.requestFocus();
            return false;
        } else if (txtGia.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống giá sản phẩm");
            txtGia.requestFocus();
            return false;
        } else if (lblanh.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống hình ảnh");
            return false;
        } else if (txtSoluong.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống số lượng");
            txtSoluong.requestFocus();
            return false;
        }
        try {
            double gia = Double.parseDouble(txtGia.getText());
            if (gia <= 0) {
                JOptionPane.showMessageDialog(this, "Giá phải lớn hơn 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "giá phải nhập số");
            return false;
        }
        try {
            int soluong = Integer.parseInt(txtSoluong.getText());
            if (soluong <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải nhập số nguyên");
            return false;
        }
        sanphamdao dao = new sanphamdao();
        List<sanpham> list = dao.findAllSP();
        for (int i = 0; i < list.size(); i++) {
            if (txtTenSP.getText().equals(list.get(i).getTenSP())) {
                JOptionPane.showMessageDialog(this, "Trùng tên sản phẩm");
                return false;
            }
        }
        return true;
    }

    public boolean check2() throws Exception {
        if (txtTenSP.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên sản phẩm");
            txtTenSP.requestFocus();
            return false;
        } else if (txtGia.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống giá sản phẩm");
            txtGia.requestFocus();
            return false;
        } else if (lblanh.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống hình ảnh");
            return false;
        } else if (txtSoluong.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống số lượng");
            txtSoluong.requestFocus();
            return false;
        }
        try {
            double gia = Double.parseDouble(txtGia.getText());
            if (gia <= 0) {
                JOptionPane.showMessageDialog(this, "Giá phải lớn hơn 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "giá phải nhập số");
            return false;
        }
        try {
            int soluong = Integer.parseInt(txtSoluong.getText());
            if (soluong <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải nhập số nguyên");
            return false;
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblanh = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnThemanh = new javax.swing.JButton();
        lblLSP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSoluong = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý sản phẩm");
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Tên sản phẩm");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Giá sản phẩm (VND)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Hình ảnh");

        lblanh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 204, 255), null, null));
        jPanel1.setEnabled(false);

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(51, 51, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/save.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setEnabled(false);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSua.setForeground(new java.awt.Color(51, 51, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/update.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.setEnabled(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(51, 51, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/delete.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setEnabled(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMoi.setForeground(new java.awt.Color(51, 51, 255));
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/new.png"))); // NOI18N
        btnMoi.setText("MỚI");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(51, 51, 255));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/thoat.png"))); // NOI18N
        btnThoat.setText("THOÁT");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThoat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi)
                    .addComponent(btnThoat))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Cập nhật");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Chức năng");

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá", "Hình ảnh", "Số lượng sản phẩm"
            }
        ));
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSP);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Danh sách");

        btnThemanh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThemanh.setForeground(new java.awt.Color(0, 0, 255));
        btnThemanh.setText("Thêm ảnh");
        btnThemanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemanhActionPerformed(evt);
            }
        });

        lblLSP.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblLSP.setForeground(new java.awt.Color(204, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Số lượng sản phẩm");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(163, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(txtSoluong))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnThemanh)
                        .addGap(169, 169, 169))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addComponent(jLabel5)
                            .addGap(195, 195, 195))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(152, 152, 152)))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, Short.MAX_VALUE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThemanh)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ret == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        int selectedRow = tblSP.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        String id = tblSP.getValueAt(selectedRow, 0).toString();
        try {
            sanphamdao dao = new sanphamdao();
            sanpham sp = dao.findID(id);
            txtTenSP.setText(sp.getTenSP());
            String gia = String.valueOf(sp.getGia());
            txtGia.setText(gia);
            String sl = String.valueOf(sp.getSoluongSP());
            txtSoluong.setText(sl);
            ImageIcon icon = new ImageIcon("F:\\bangpd02565_DuAN_1\\src\\anhSP\\" + sp.getHinhanh());
            lblanh.setIcon(icon);
            filename = sp.getHinhanh();
            if (sharehelper.user.isVaitro()) {
                btnSua.setEnabled(true);
                btnXoa.setEnabled(true);
                btnThem.setEnabled(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_tblSPMouseClicked

    private void btnThemanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemanhActionPerformed
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);
        try {
            File file = fc.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            lblanh.setIcon(icon);
            filename = file.getName();

        } catch (Exception iOException) {
        }
    }//GEN-LAST:event_btnThemanhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            if (check()) {
                sanphamdao dao = new sanphamdao();
                sanpham sp = new sanpham();
                sp.setTenSP(txtTenSP.getText());
                double gia = Double.parseDouble(txtGia.getText());
                sp.setGia(gia);
                int soluong = Integer.parseInt(txtSoluong.getText());
                sp.setSoluongSP(soluong);
                sp.setMaLSP(sharehelper.loaisanpham.getMaLSP());
                sp.setHinhanh(filename);
                if (dao.insertUser(sp)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    loadDataToTable();
                    btnMoiActionPerformed(evt);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
            e.printStackTrace();

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        txtTenSP.setText("");
        txtGia.setText("");
        txtSoluong.setText("");
        lblanh.setIcon(null);
        if (sharehelper.user.isVaitro()) {
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
            btnThem.setEnabled(true);

        }

    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (check2()) {
                sanphamdao dao = new sanphamdao();
                sanpham sp = new sanpham();
                int selectedRow = tblSP.getSelectedRow();
                String id = tblSP.getValueAt(selectedRow, 0).toString();
                int maSP = Integer.parseInt(id);
                sp.setMaSP(maSP);
                sp.setTenSP(txtTenSP.getText());
                double gia = Double.parseDouble(txtGia.getText());
                sp.setHinhanh(filename);
                sp.setGia(gia);
                int sl = Integer.parseInt(txtSoluong.getText());
                sp.setSoluongSP(sl);
                if (dao.update(sp)) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    loadDataToTable();
                    btnMoiActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(this, "Không sửa được");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            sanphamdao dao = new sanphamdao();

            int selectedRow = tblSP.getSelectedRow();
            String id = tblSP.getValueAt(selectedRow, 0).toString();
            int maSP = Integer.parseInt(id);
            if (dao.delete(maSP)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                loadDataToTable();
                btnMoiActionPerformed(evt);

            } else {
                JOptionPane.showMessageDialog(this, "Không xóa được");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(quanlysanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quanlysanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quanlysanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quanlysanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quanlysanpham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemanh;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLSP;
    private javax.swing.JLabel lblanh;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
