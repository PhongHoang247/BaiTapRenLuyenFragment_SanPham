package com.phong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phong.baitaprenluyenfragment_sanpham.R;
import com.phong.model.SanPham;

import java.util.ArrayList;

public class SanPhamAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> sanPhams;//Dữ liệu
    LayoutInflater inflater;//Gán layout
    public SanPhamAdapter(Context context,ArrayList<SanPham> sanPhams){
        this.context = context;
        this.sanPhams = sanPhams;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return sanPhams.size();
    }

    @Override
    public Object getItem(int i) {
        return sanPhams.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null)
        {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview, null);//Lấy view
            viewHolder.imgHinh = view.findViewById(R.id.imgHinh);
            viewHolder.txtTen = view.findViewById(R.id.txtTen);
            viewHolder.txtGia = view.findViewById(R.id.txtGia);
            view.setTag(viewHolder);//Thông qua setTag để lưu lại địa chỉ hoặc đối tượng, giá trị nào đó để xử lý sau
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }
        SanPham sp = sanPhams.get(i);
        viewHolder.imgHinh.setImageResource(sp.getHinh());
        viewHolder.txtTen.setText(sp.getTen());
        viewHolder.txtGia.setText("Giá:" + sp.getGia() + " VND");
        return view;
    }

    private class ViewHolder{
        public ImageView imgHinh;
        public TextView txtTen, txtGia;
    }
}
