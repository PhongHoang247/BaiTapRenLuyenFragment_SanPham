package com.phong.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private String ten;
    private String mota;
    private int gia;
    private int hinh;
    private int type;

    public SanPham() {
    }

    public SanPham(String ten, String mota, int gia, int hinh, int type) {
        this.ten = ten;
        this.mota = mota;
        this.gia = gia;
        this.hinh = hinh;
        this.type = type;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
