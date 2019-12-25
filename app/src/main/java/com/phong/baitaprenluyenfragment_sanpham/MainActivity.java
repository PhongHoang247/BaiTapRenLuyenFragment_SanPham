package com.phong.baitaprenluyenfragment_sanpham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.phong.model.MyClickListener;
import com.phong.model.SanPham;

public class MainActivity extends AppCompatActivity implements MyClickListener {

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container,new MyFragment());
        transaction.commit();
    }

    @Override
    public void click(SanPham sanPham) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        MyFragmentDetail myFragmentDetail = new MyFragmentDetail();
        myFragmentDetail.setSanPham(sanPham);
        transaction.replace(R.id.container,myFragmentDetail);
        transaction.addToBackStack(null);//Lưu trạng thái
        transaction.commit();
    }
}
