package com.utils.lipeng.lputils;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.lipeng.Utils.InterFace.BindViewInterface;
import com.lipeng.Utils.LogUtils;
import com.lipeng.Utils.MyAdapter;
import com.utils.lipeng.lputils.databinding.ActivityMainBinding;
import com.utils.lipeng.lputils.databinding.ItemBinding;
import com.utils.lipeng.lputils.databinding.ItemtwoBinding;
import com.utils.lipeng.lputils.databinding.ItemtwooBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MyAdapter<String> adapter;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.rec.setLayoutManager(new StaggeredGridLayoutManager(1,LinearLayout.VERTICAL));
        list.add("00000");
        list.add("11111");
        list.add("2222");
        list.add("333");
        list.add("444");
        list.add("555");
        list.add("666");
        adapter = new MyAdapter<>(list, R.layout.item, new BindViewInterface() {
            @Override
            public void bandView(ViewDataBinding bb, int position) {
                LogUtils.e(position + "bandView");
                        ItemBinding b = (ItemBinding) bb;
                        b.tv.setText(list.get(position));
            }
        });


        ItemtwoBinding hv = DataBindingUtil.inflate(
                LayoutInflater.from(MainActivity.this),
                R.layout.itemtwo,
                null,
                false);


        ItemtwooBinding hh = DataBindingUtil.inflate(
                LayoutInflater.from(MainActivity.this),
                R.layout.itemtwoo,
                null,
                false);


        hh.tv.setText("aaaaaaaaaaaa");

        hv.tv.setText("bbbbbbbbbb");


        adapter.setHeaderView(hv.getRoot());
        adapter.setFooterView(hh.getRoot());
        binding.rec.setAdapter(adapter);
//        adapter.notifyDataSetChanged();

//        new DialogUtils(this)
//                .setTitle("11")
//.Cancel("1")
//                .setDialogListener(new DialogListener() {
//                    @Override
//                    public void buttType(int ButtType) {
//                        ToastUtils.show(ButtType+"");
//                    }
//                })
//                .isTouchCancel()
//                .show();
    }
}
