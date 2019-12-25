package com.phong.baitaprenluyenfragment_sanpham;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.phong.model.SanPham;

public class MyFragmentDetail extends Fragment {
    private SanPham sanPham;
    private String key = "MyFragmentDetail_infor";

    public MyFragmentDetail() {

    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public MyFragmentDetail (SanPham sanPham){
        this.sanPham = sanPham;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment_detail,null);
        TextView txtChiTiet = view.findViewById(R.id.txtChiTiet);
        txtChiTiet.setText(sanPham.getMota() + "\nGiá:" + sanPham.getGia() + " VND");
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //Lưu sản phẩm: đỡ tốn bộ nhớ
        outState.putSerializable(key, sanPham);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Phục hồi:
        if (savedInstanceState != null && savedInstanceState.containsKey(key)){
            sanPham = (SanPham) savedInstanceState.getSerializable(key);
        }
    }
}
