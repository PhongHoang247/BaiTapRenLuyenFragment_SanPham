package com.phong.baitaprenluyenfragment_sanpham;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.phong.adapter.SanPhamAdapter;
import com.phong.model.MyClickListener;
import com.phong.model.SanPham;

import java.util.ArrayList;

public class MyFragment extends Fragment {
    private ArrayList<SanPham> sanPhams;
    private MyClickListener myClickListener;
    private TextView txtChiTiet;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment,null);
        ListView lvSanPham = view.findViewById(R.id.lvSanPham);
        txtChiTiet = view.findViewById(R.id.txtChiTiet);
        sanPhams = new ArrayList<>();//Đọc CSDL ở đây
        sanPhams.add(new SanPham("Cocacola","Nước ngọt",15000,R.drawable.hinh2,1));
        sanPhams.add(new SanPham("Pepsi","Nước ngọt",18000,R.drawable.hinh1,2));
        sanPhams.add(new SanPham("Heineken","Bia",20000,R.drawable.hinh3,1));
        sanPhams.add(new SanPham("Red Bull","Nước ngọt",17000,R.drawable.hinh4,2));
        SanPhamAdapter adapter = new SanPhamAdapter(getActivity(), sanPhams);
        lvSanPham.setAdapter(adapter);

        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (txtChiTiet == null){//Nằm đứng
                    myClickListener = (MyClickListener) getActivity();
                    myClickListener.click(sanPhams.get(i));
                }
                else {//Nằm ngang
                    txtChiTiet.setText(sanPhams.get(i).getMota());
                }
            }
        });
        return view;
    }
}
