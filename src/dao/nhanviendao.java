/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Heper.DateHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.nhanvien;

/**
 *
 * @author DELL
 */
public class nhanviendao {

    public boolean insertUser(nhanvien nv) throws Exception {
        String sql = "insert into nhanvien values (?,?,?,?,?,?,?,?,?,?)";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, nv.getMaNV());
            pstm.setString(2, nv.getTenNV());
            pstm.setString(3, nv.getPassword());
            pstm.setString(4, nv.getEmail());
            pstm.setBoolean(5, nv.isGioitinh());
            pstm.setDate(6, DateHelper.toSQLDate(nv.getNgaysinh()));
            pstm.setBoolean(7, nv.isVaitro());
            pstm.setString(8, nv.getSdt());
            pstm.setString(9, nv.getDiachi());
            pstm.setString(10, nv.getHinhanh());
            return pstm.executeUpdate() > 0;
        }
    }

    public nhanvien findID(String manhanvien) throws Exception {
        String sql = "select * from nhanvien where maNV = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, manhanvien);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    nhanvien nv = new nhanvien();
                    nv.setMaNV(rs.getString("maNV"));
                    nv.setPassword(rs.getString("password"));
                    nv.setTenNV(rs.getString("tenNV"));
                    nv.setVaitro(rs.getBoolean("vaitro"));
                    nv.setGioitinh(rs.getBoolean("gioitinh"));
                    nv.setDiachi(rs.getString("diachi"));
                    nv.setEmail(rs.getString("email"));
                    nv.setNgaysinh(rs.getDate("ngaysinh"));
                    nv.setSdt(rs.getString("sdt"));
                    nv.setHinhanh(rs.getString("hinhanh"));

                    return nv;
                }

            }
            return null;
        }

    }

    public List<nhanvien> findAll() throws Exception {
        String sql = "select * from nhanvien ";

        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {

            try (ResultSet rs = pstm.executeQuery()) {
                List<nhanvien> list = new ArrayList<>();

                while (rs.next()) {
                    nhanvien nv = new nhanvien();

                    nv.setMaNV(rs.getString("maNV"));
                    nv.setPassword(rs.getString("password"));
                    nv.setTenNV(rs.getString("tenNV"));
                    nv.setVaitro(rs.getBoolean("vaitro"));
                    nv.setGioitinh(rs.getBoolean("gioitinh"));
                    nv.setDiachi(rs.getString("diachi"));
                    nv.setEmail(rs.getString("email"));
                    nv.setNgaysinh(rs.getDate("ngaysinh"));
                    nv.setSdt(rs.getString("sdt"));
                    nv.setHinhanh(rs.getString("hinhanh"));
                    list.add(nv);
                }
                return list;
            }
        }

    }

    public boolean delete(String manhavien)
            throws Exception {
        String sql = "delete from nhanvien where maNV = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, manhavien);

            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean update(nhanvien nv)
            throws Exception {
        String sql = "update nhanvien set password = ?, tenNV = ?, vaitro = ?, gioitinh = ?,email =?, diachi = ?, sdt = ?, ngaysinh = ?, hinhanh = ?  "
                + " where maNV = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(10, nv.getMaNV());
            pstm.setString(2, nv.getTenNV());
            pstm.setString(1, nv.getPassword());
            pstm.setString(5, nv.getEmail());
            pstm.setString(7, nv.getSdt());
            pstm.setBoolean(4, nv.isGioitinh());
            pstm.setBoolean(3, nv.isVaitro());
            pstm.setString(9, nv.getHinhanh());
            pstm.setDate(8, DateHelper.toSQLDate(nv.getNgaysinh()));
            pstm.setString(6, nv.getDiachi());

            return pstm.executeUpdate() > 0;
        }
    }

    public boolean changePassword(nhanvien nv)
            throws Exception {
        String sql = "update nhanvien set password = ?  "
                + " where maNV = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, nv.getPassword());

            pstmt.setString(2, nv.getMaNV());
           

            return pstmt.executeUpdate() > 0;
        }
    }
}
