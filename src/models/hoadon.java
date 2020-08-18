/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class hoadon {
  private String maHD;
    private String maNV ;
    private Date ngaytao ;

    public hoadon() {
    }

    public hoadon(String maHD, String maNV, Date ngaytao) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.ngaytao = ngaytao;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

   
}
