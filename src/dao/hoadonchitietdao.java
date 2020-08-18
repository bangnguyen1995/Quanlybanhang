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
import models.hoadonchitiet;
import models.sanpham;

/**
 *
 * @author DELL
 */
public class hoadonchitietdao {

    public boolean insert(hoadonchitiet hdct) throws Exception {
        String sql = "insert into hoadonchitiet values (?,?,?,?)";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {

            pstm.setInt(1, hdct.getMaSP());
            pstm.setString(2, hdct.getMaHD());
            pstm.setInt(3, hdct.getSoluong());
            pstm.setInt(4, hdct.getGiamgia());

            return pstm.executeUpdate() > 0;
        }
    }

    public hoadonchitiet findID(int maHDCT) throws Exception {
        String sql = "select * from hoadonchitiet  where maHDCT = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setInt(1, maHDCT);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    hoadonchitiet hdct = new hoadonchitiet();
                    hdct.setMaHDCT(rs.getInt("maHDCT"));
                    hdct.setSoluong(rs.getInt("soluong"));
                    hdct.setMaHD(rs.getString("maHD"));
                    hdct.setMaSP(rs.getInt("maSP"));
                    hdct.setGiamgia(rs.getInt("giamgia"));

                    return hdct;
                }

            }
            return null;
        }

    }

    public List<hoadonchitiet> findAll(String maHD) throws Exception {
        String sql = "select * from hoadonchitiet where maHD = ? ";

        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maHD);

            try (ResultSet rs = pstm.executeQuery()) {
                List<hoadonchitiet> list = new ArrayList<>();

                while (rs.next()) {
                    hoadonchitiet hdct = new hoadonchitiet();
                    hdct.setMaHDCT(rs.getInt("maHDCT"));
                    hdct.setSoluong(rs.getInt("soluong"));
                    hdct.setMaHD(rs.getString("maHD"));
                    hdct.setMaSP(rs.getInt("maSP"));
                    hdct.setGiamgia(rs.getInt("giamgia"));
                    list.add(hdct);
                }
                return list;
            }
        }

    }

    public boolean delete(int maHDCT)
            throws Exception {
        String sql = "delete from hoadonchitiet where maHDCT = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, maHDCT);

            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean update(hoadonchitiet hdct)
            throws Exception {
        String sql = "update hoadonchitiet set  soluong = ?,giamgia =?  "
                + " where maHDCT = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setInt(3, hdct.getMaHDCT());
            pstm.setInt(1, hdct.getSoluong());
            pstm.setInt(2, hdct.getGiamgia());
            return pstm.executeUpdate() > 0;
        }
    }

    public List<sanpham> findAlltenSPkhongchotrongHD(String maHD) throws Exception {
        String sql = "SELECT * FROM sanpham WHERE maSP NOT IN (SELECT maSP FROM hoadonchitiet where maHD = ? ) order by tenSP asc";

        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maHD);
            try (ResultSet rs = pstm.executeQuery()) {
                List<sanpham> list = new ArrayList<>();

                while (rs.next()) {
                    sanpham sp = new sanpham();
                    sp.setTenSP(rs.getString("tenSP"));

                    list.add(sp);
                }
                return list;
            }
        }
    }
}
