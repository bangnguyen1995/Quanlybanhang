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
import models.loaisanpham;

/**
 *
 * @author DELL
 */
public class loaisanphamdao {
   public boolean insertUser(loaisanpham lsp) throws Exception {
        String sql = "insert into loaisanpham values (?,?)";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, lsp.getMaLSP());
            pstm.setString(2, lsp.getTenLSP());
      
            return pstm.executeUpdate() > 0;
        }
    }

    public loaisanpham findID(String maLSP) throws Exception {
        String sql = "select * from loaisanpham where maLoaiSP = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maLSP);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    loaisanpham lsp = new loaisanpham();
                    lsp.setMaLSP(rs.getString("maLoaiSP"));
                    lsp.setTenLSP(rs.getString("tenloaisanpham"));
                   

                    return lsp;
                }

            }
            return null;
        }

    }

    public List<loaisanpham> findAll() throws Exception {
        String sql = "select * from loaisanpham ";

        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {

            try (ResultSet rs = pstm.executeQuery()) {
                List<loaisanpham> list = new ArrayList<>();

                while (rs.next()) {
                    loaisanpham lsp = new loaisanpham();

                    lsp.setMaLSP(rs.getString("maLoaiSP"));
                    lsp.setTenLSP(rs.getString("tenloaisanpham"));
                
                    list.add(lsp);
                }
                return list;
            }
        }

    }

    public boolean delete(String LSP)
            throws Exception {
        String sql = "delete from loaisanpham where maLoaiSP = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, LSP);

            return pstmt.executeUpdate() > 0;
        }
    }


    public boolean update(loaisanpham lsp)
            throws Exception {
        String sql = "update loaisanpham set tenloaisanpham = ?   "
                + " where maLoaiSP = ?";
        try (
                Connection con = database.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, lsp.getTenLSP());
            pstm.setString(2, lsp.getMaLSP());
          

            return pstm.executeUpdate() > 0;
        }
    }
}
