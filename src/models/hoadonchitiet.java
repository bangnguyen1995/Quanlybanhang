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
public class hoadonchitiet {
    private  int maHDCT , soluong, giamgia;
    private int maSP ;
  private  String maHD ;

    public hoadonchitiet() {
    }

    public hoadonchitiet(int maHDCT, int soluong, int giamgia, int maSP, String maHD) {
        this.maHDCT = maHDCT;
        this.soluong = soluong;
        this.giamgia = giamgia;
        this.maSP = maSP;
        this.maHD = maHD;
    }

    public int getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

  

  
     
    
}
