/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author DELL
 */
public class sanpham {
    private int maSP ,soluongSP;
    private double gia;
private  String tenSP,hinhanh,maLSP;
    public sanpham() {
    }

    public sanpham(int maSP, int soluongSP, double gia, String tenSP, String hinhanh, String maLSP) {
        this.maSP = maSP;
        this.soluongSP = soluongSP;
        this.gia = gia;
        this.tenSP = tenSP;
        this.hinhanh = hinhanh;
        this.maLSP = maLSP;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoluongSP() {
        return soluongSP;
    }

    public void setSoluongSP(int soluongSP) {
        this.soluongSP = soluongSP;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getMaLSP() {
        return maLSP;
    }

    public void setMaLSP(String maLSP) {
        this.maLSP = maLSP;
    }

    
    
}
