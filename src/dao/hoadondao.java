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
import models.hoadon;

/**
 *
 * @author DELL
 */
public class hoadondao {

    public boolean insert(hoadon hd) throws Exception {
        String sql = "insert into hoadon values (?,?,?)";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, hd.getMaHD());
            pstm.setString(2, hd.getMaNV());
            pstm.setDate(3, DateHelper.toSQLDate(hd.getNgaytao()));
            return pstm.executeUpdate() > 0;
        }
    }
    public hoadon findID(String maHD) throws Exception {
        String sql = "select * from hoadon where maHD = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maHD);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    hoadon hd = new hoadon();
                    hd.setMaHD(rs.getString("maHD"));
                    hd.setMaNV(rs.getString("maNV"));
                    hd.setNgaytao(rs.getDate("ngaytao"));

                    return hd;
                }

            }
            return null;
        }

    }

    public List<hoadon> findAll() throws Exception {
        String sql = "select * from hoadon order by ngaytao desc ";

        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {

            try (ResultSet rs = pstm.executeQuery()) {
                List<hoadon> list = new ArrayList<>();

                while (rs.next()) {
                    hoadon hd = new hoadon();
                    hd.setMaHD(rs.getString("maHD"));
                    hd.setMaNV(rs.getString("maNV"));
                    hd.setNgaytao(rs.getDate("ngaytao"));
                    list.add(hd);
                }
                return list;
            }
        }

    }

    public boolean delete(String maHD)
            throws Exception {
        String sql = "delete from hoadon where maHD = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, maHD);

            return pstmt.executeUpdate() > 0;
        }
    }
}
