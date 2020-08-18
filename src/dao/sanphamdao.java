/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.sanpham;

/**
 *
 * @author DELL
 */
public class sanphamdao {

    public boolean insertUser(sanpham sp) throws Exception {
        String sql = "insert into sanpham values (?,?,?,?,?)";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, sp.getTenSP());
            pstm.setDouble(2, sp.getGia());
            pstm.setString(3, sp.getMaLSP());
            pstm.setString(4, sp.getHinhanh());
            pstm.setInt(5, sp.getSoluongSP());
            return pstm.executeUpdate() > 0;
        }
    }

    public sanpham findID(String maSP) throws Exception {
        String sql = "select * from sanpham where maSP = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maSP);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    sanpham sp = new sanpham();
                    sp.setMaSP(rs.getInt("maSP"));
                    sp.setTenSP(rs.getString("tenSP"));
                    sp.setGia(rs.getDouble("gia"));
                    sp.setMaLSP(rs.getString("maLoaiSP"));
                    sp.setHinhanh(rs.getString("hinhanhSP"));
                    sp.setSoluongSP(rs.getInt("soluongSP"));

                    return sp;
                }

            }
            return null;
        }

    }

    public List<sanpham> findAll(String maLSP) throws Exception {
        String sql = "select * from sanpham where maLoaiSP = ? ";

        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maLSP);
            try (ResultSet rs = pstm.executeQuery()) {
                List<sanpham> list = new ArrayList<>();

                while (rs.next()) {
                    sanpham sp = new sanpham();
                    sp.setMaSP(rs.getInt("maSP"));
                    sp.setTenSP(rs.getString("tenSP"));
                    sp.setGia(rs.getDouble("gia"));
                    sp.setHinhanh(rs.getString("hinhanhSP"));
                      sp.setSoluongSP(rs.getInt("soluongSP"));
                    list.add(sp);
                }
                return list;
            }
        }

    }

    public List<sanpham> findAllSP() throws Exception {
        String sql = "select * from sanpham  ";

        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {

            try (ResultSet rs = pstm.executeQuery()) {
                List<sanpham> list = new ArrayList<>();

                while (rs.next()) {
                    sanpham sp = new sanpham();
                    sp.setMaSP(rs.getInt("maSP"));
                    sp.setTenSP(rs.getString("tenSP"));
                    sp.setGia(rs.getDouble("gia"));
                    sp.setHinhanh(rs.getString("hinhanhSP"));
                      sp.setSoluongSP(rs.getInt("soluongSP"));
                    list.add(sp);
                }
                return list;
            }
        }

    }

    public boolean delete(int maSP)
            throws Exception {
        String sql = "delete from sanpham where maSP = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, maSP);

            return pstmt.executeUpdate() > 0;
        }
    }
public boolean deletehoadonbySP(int maSP)
            throws Exception {
        String sql = "delete from hoadonchitiet where maSP = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, maSP);

            return pstmt.executeUpdate() > 0;
        }
    }
    public boolean deletebyLSP(String maLSP)
            throws Exception {
        String sql = "delete from sanpham where maLoaiSP = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, maLSP);

            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean update(sanpham sp)
            throws Exception {
        String sql = "update sanpham set tenSP = ?, gia = ?, hinhanhSP = ?, soluongSP =? "
                + " where maSP = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {

            pstm.setInt(5, sp.getMaSP());
            pstm.setString(1, sp.getTenSP());
            pstm.setDouble(2, sp.getGia());
            pstm.setString(3, sp.getHinhanh());
            pstm.setInt(4, sp.getSoluongSP());
            return pstm.executeUpdate() > 0;
        }
    }

    public sanpham findbyname(String tenSP) throws Exception {
        String sql = "select maSP, soluongSP from sanpham where tenSP = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, tenSP);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    sanpham sp = new sanpham();
                    sp.setMaSP(rs.getInt("maSP"));
                    sp.setSoluongSP(rs.getInt("soluongSP"));

                    return sp;
                }

            }
            return null;
        }
    }
}
