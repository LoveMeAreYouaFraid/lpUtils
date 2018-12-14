package com.lipeng.Utils;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class PublicViewHeader extends RecyclerView.ViewHolder {
    private ViewDataBinding viewDataBinding;

    PublicViewHeader(View v) {
        super(v);
    }


    ViewDataBinding getBinding() {
        return viewDataBinding;
    }

    void setBinding(ViewDataBinding viewDataBinding) {
        this.viewDataBinding = viewDataBinding;
    }
}
