/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jrame;

import Heper.sharehelper;
import dao.nhanviendao;
import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.nhanvien;

/**
 *
 * @author DELL
 */
public class quanlynhanvien extends javax.swing.JFrame {
    
    String filename;

    /**
     * Creates new form nhanvien
     */
    public quanlynhanvien() {
        initComponents();
        setLocationRelativeTo(null);
        if (sharehelper.user.isVaitro()) {
            btnThem.setEnabled(true);
        }
        loadDataToTable();
    }
    
    private void loadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0);
        try {
            nhanviendao dao = new nhanviendao();
            
            List<nhanvien> list = dao.findAll();
            for (nhanvien nv : list) {
                String gt;
                if (nv.isGioitinh()) {
                    gt = "Nam";
                } else {
                    gt = "Nữ";
                }
                String vt;
                if (nv.isVaitro()) {
                    vt = "Quản lý";
                    
                } else {
                    vt = "Nhân viên";
                }
                model.addRow(new Object[]{
                    nv.getMaNV(),
                    nv.getTenNV(),
                    nv.getNgaysinh(),
                    nv.getSdt(),
                    gt,
                    nv.getEmail(),
                    nv.getDiachi(),
                    vt,
                    nv.getHinhanh()
                });
            }
            model.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    public boolean check() throws Exception {
        if (txtmaNV.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống mã nhân viên");
            txtmaNV.requestFocus();
            return false;
        } else if (txttenNV.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống tên nhân viên");
            txttenNV.requestFocus();
            return false;
        } else if (txtemail.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống email");
            txtemail.requestFocus();
            return false;
        } else if (txtsdt.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống sđt");
            txtsdt.requestFocus();
            return false;
        } else if (txtsdt.getText().length() >= 11) {
            JOptionPane.showMessageDialog(this, "SĐT không quá 11 số");
            txtsdt.requestFocus();
            return false;
        } else if (txtdiachi.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống địa chỉ");
            txtdiachi.requestFocus();
            return false;
        } else if (txtpassword.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống mật khẩu");
            txtpassword.requestFocus();
            return false;
        } else if (txtngaysinh.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống ngày sinh");
            txtngaysinh.requestFocus();
            return false;
        } else if (lblanh.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "Không để trống ảnh");
            return false;
        } else if (!txtsdt.getText().matches("^[0-9]{0,99}$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải nhập số");;
            txtsdt.requestFocus();
            return false;
        } else if (!txtemail.getText().matches("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "Không đúng định dạng Email!");
            return false;
        }
        try {
            Date ngaysinh = new SimpleDateFormat("dd/MM/yyyy").parse(txtngaysinh.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "sai định dạng ngày sinh");
            return false;
        }
        
        nhanviendao dao = new nhanviendao();
        nhanvien nv = new nhanvien();
        nv = dao.findID(txtmaNV.getText());
        if (nv != null) {
            JOptionPane.showMessageDialog(this, "trùng mã nhân viên");
            return false;
        }
        return true;
    }
    
    public boolean check2() throws Exception {
        if (txtmaNV.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống mã nhân viên");
            txtmaNV.requestFocus();
            return false;
        } else if (txttenNV.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống tên nhân viên");
            txttenNV.requestFocus();
            return false;
        } else if (txtemail.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống email");
            txtemail.requestFocus();
            return false;
        } else if (txtsdt.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống sđt");
            txtsdt.requestFocus();
            return false;
        } else if (txtsdt.getText().length() >= 11) {
            JOptionPane.showMessageDialog(this, "SĐT không quá 11 số");
            txtsdt.requestFocus();
            return false;
        } else if (txtdiachi.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống địa chỉ");
            txtdiachi.requestFocus();
            return false;
        } else if (txtpassword.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống mật khẩu");
            txtpassword.requestFocus();
            return false;
        } else if (txtngaysinh.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không để trống ngày sinh");
            txtngaysinh.requestFocus();
            return false;
        } else if (lblanh.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "Không để trống ảnh");
            return false;
        } else if (!txtsdt.getText().matches("^[0-9]{0,99}$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải nhập số");;
            txtsdt.requestFocus();
            return false;
        } else if (!txtemail.getText().matches("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "Không đúng định dạng Email!");
            return false;
        }
        try {
            Date ngaysinh = new SimpleDateFormat("dd/MM/yyyy").parse(txtngaysinh.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "sai định dạng ngày sinh");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmaNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttenNV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        chknam = new javax.swing.JCheckBox();
        chknu = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        txtngaysinh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        chknhanvien = new javax.swing.JCheckBox();
        chktruongphong = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblanh = new javax.swing.JLabel();
        btnthemanh = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtdiachi = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý nhân viên");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Cập nhật");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Mã nhân viên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Tên nhân viên:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Mật khẩu:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Email:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Giới tính:");

        buttonGroup1.add(chknam);
        chknam.setSelected(true);
        chknam.setText("Nam");

        buttonGroup1.add(chknu);
        chknu.setText("Nữ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Ngày sinh:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Số điện thoại:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Vai trò:");

        buttonGroup2.add(chknhanvien);
        chknhanvien.setSelected(true);
        chknhanvien.setText("Nhân viên");

        buttonGroup2.add(chktruongphong);
        chktruongphong.setText("Quản lý");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Địa chỉ:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setText("Hình ảnh:");

        lblanh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        btnthemanh.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnthemanh.setForeground(new java.awt.Color(0, 0, 255));
        btnthemanh.setText("Thêm ảnh");
        btnthemanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemanhActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 255));
        jLabel14.setText("Danh sách");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblNV.setBackground(new java.awt.Color(240, 240, 240));
        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma nhân viên", "Tên nhân viên", "Ngày sinh", "SĐT", "Giới tính", "Email", "Địa chỉ", "Chức vụ", "Hình ảnh"
            }
        ));
        tblNV.setGridColor(new java.awt.Color(0, 0, 0));
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblNV);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtdiachi.setColumns(20);
        txtdiachi.setRows(5);
        jScrollPane4.setViewportView(txtdiachi);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 204, 255), null, null));

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(36, 36, 36)
                .addComponent(btnMoi)
                .addGap(36, 36, 36)
                .addComponent(btnThoat)
                .addGap(48, 48, 48))
        );

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 255));
        jLabel16.setText("Chức năng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(txtmaNV)
                                        .addComponent(jLabel4)
                                        .addComponent(txttenNV)
                                        .addComponent(txtpassword)
                                        .addComponent(txtemail)
                                        .addComponent(jLabel8)
                                        .addComponent(txtngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                                    .addComponent(jLabel9)
                                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chknhanvien)
                                        .addGap(18, 18, 18)
                                        .addComponent(chktruongphong))
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chknam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chknu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnthemanh)
                                .addGap(90, 90, 90)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))))
            .addGroup(layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chknhanvien)
                                    .addComponent(chktruongphong))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addComponent(txttenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(chknam)
                                    .addComponent(chknu)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnthemanh))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            if (check()) {
                nhanviendao dao = new nhanviendao();
                
                nhanvien nv = new nhanvien();
                nv.setMaNV(txtmaNV.getText());
                nv.setTenNV(txttenNV.getText());
                nv.setPassword(txtpassword.getText());
                nv.setEmail(txtemail.getText());
                nv.setDiachi(txtdiachi.getText());
                Date ngaysinh = new SimpleDateFormat("dd/MM/yyyy").parse(txtngaysinh.getText());
                nv.setNgaysinh(ngaysinh);
                nv.setSdt(txtsdt.getText());
                boolean gt;
                if (chknam.isSelected()) {
                    gt = true;
                } else {
                    gt = false;
                }
                nv.setGioitinh(gt);
                boolean vaitro;
                if (chknhanvien.isSelected()) {
                    vaitro = false;
                } else {
                    vaitro = true;
                }
                nv.setVaitro(vaitro);
                nv.setHinhanh(filename);
                dao.insertUser(nv);
                loadDataToTable();
                btnMoiActionPerformed(evt);
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnthemanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemanhActionPerformed
        JFileChooser fc = new JFileChooser();
        
        int res = fc.showOpenDialog(null);
        
        try {
            
            File file = fc.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            lblanh.setIcon(icon);
            filename = file.getName();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnthemanhActionPerformed

    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVMouseClicked
        int selectedRow = tblNV.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        
        String id = tblNV.getValueAt(selectedRow, 0).toString();
        
        try {
            nhanviendao dao = new nhanviendao();
            nhanvien nv = dao.findID(id);
            txtmaNV.setText(nv.getMaNV());
            txttenNV.setText(nv.getTenNV());
            txtpassword.setText(nv.getPassword());
            txtemail.setText(nv.getEmail());
            txtsdt.setText(nv.getSdt());
            ImageIcon icon = new ImageIcon("F:\\bangpd02565_DuAN_1\\src\\anh\\" + nv.getHinhanh());
            lblanh.setIcon(icon);
            filename = nv.getHinhanh();
            txtdiachi.setText(nv.getDiachi());
            if (nv.isGioitinh()) {
                chknam.setSelected(true);
            } else {
                chknu.setSelected(true);
            }
            if (nv.isVaitro()) {
                chktruongphong.setSelected(true);
            } else {
                chknhanvien.setSelected(true);
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String ngaysinh = formatter.format(nv.getNgaysinh());
            txtngaysinh.setText(ngaysinh);
            if (sharehelper.user.isVaitro()) {
                btnSua.setEnabled(true);
                btnXoa.setEnabled(true);
                btnThem.setEnabled(false);
            }
            txtmaNV.setEditable(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_tblNVMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (check2()) {
                nhanviendao dao = new nhanviendao();
                nhanvien nv = new nhanvien();
                nv.setMaNV(txtmaNV.getText());
                nv.setTenNV(txttenNV.getText());
                nv.setPassword(txtpassword.getText());
                nv.setEmail(txtemail.getText());
                nv.setDiachi(txtdiachi.getText());
                Date ngaysinh = new SimpleDateFormat("dd/MM/yyyy").parse(txtngaysinh.getText());
                nv.setNgaysinh(ngaysinh);
                nv.setSdt(txtsdt.getText());
                boolean gt;
                if (chknam.isSelected()) {
                    gt = true;
                } else {
                    gt = false;
                }
                nv.setGioitinh(gt);
                boolean vaitro;
                if (chknhanvien.isSelected()) {
                    vaitro = false;
                } else {
                    vaitro = true;
                }
                nv.setVaitro(vaitro);
                nv.setHinhanh(filename);
                
                if (dao.update(nv)) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    loadDataToTable();
                    btnMoiActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(this, "Không sửa được");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        txtmaNV.setText("");
        txttenNV.setText("");
        txtpassword.setText("");
        txtemail.setText("");
        txtngaysinh.setText("");
        txtsdt.setText("");
        lblanh.setIcon(null);
        txtdiachi.setText("");
        chknam.setSelected(true);
        chknhanvien.setSelected(true);
        if (sharehelper.user.isVaitro()) {
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
            btnThem.setEnabled(true);
        }
        txtmaNV.setEditable(true);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ret == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            if (!txtmaNV.getText().equals(sharehelper.user.getMaNV())) {
                
                nhanviendao dao = new nhanviendao();
                
                if (dao.delete(txtmaNV.getText())) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    loadDataToTable();
                    btnMoiActionPerformed(evt);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Không xóa được");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không xóa được chính mình");
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
            java.util.logging.Logger.getLogger(nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quanlynhanvien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnthemanh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox chknam;
    private javax.swing.JCheckBox chknhanvien;
    private javax.swing.JCheckBox chknu;
    private javax.swing.JCheckBox chktruongphong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblanh;
    private javax.swing.JTable tblNV;
    private javax.swing.JTextArea txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmaNV;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttenNV;
    // End of variables declaration//GEN-END:variables
}
