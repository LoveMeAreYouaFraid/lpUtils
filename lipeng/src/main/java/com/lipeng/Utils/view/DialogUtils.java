package com.lipeng.Utils.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.lipeng.R;
import com.lipeng.Utils.InterFace.DialogListener;


/**
 * Created by Administrator on 2017/3/22 0022.
 */

public class DialogUtils {
    private Context mContext;
    private Dialog dialog;
    private TextView title, one, two;
    private View line;

    public DialogUtils(Context context) {
        mContext = context;
        dialog = new Dialog(mContext, R.style.dialog);
        dialog.setContentView(R.layout.dialog_list_layout);
        title = (TextView) dialog.findViewById(R.id.tv_title);
        one = (TextView) dialog.findViewById(R.id.tv_determine);
        two = (TextView) dialog.findViewById(R.id.tv_cancel);
        line = dialog.findViewById(R.id.line);
        title.setVisibility(View.GONE);
        two.setVisibility(View.GONE);
        line.setVisibility(View.GONE);


    }

    public DialogUtils setTitle(Object s) {
        if (title != null) {
            title.setText(s.toString());
            title.setVisibility(View.VISIBLE);
        }
        return this;
    }


    public DialogUtils Determine(Object s) {
        if (one != null) {
            one.setText(s.toString());
            one.setVisibility(View.VISIBLE);
            one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();
                }
            });
            if (two.getVisibility() == View.VISIBLE) {
                line.setVisibility(View.VISIBLE);
            } else {
                one.setBackgroundResource(R.drawable.bg_click_dialog_lift_and_right_gray);
            }
        }
        return this;
    }

    public DialogUtils Cancel(Object s) {
        if (two != null) {
            two.setText(s.toString());
            two.setVisibility(View.VISIBLE);
            two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();
                }
            });
            one.setBackgroundResource(R.drawable.bg_click_dialog_lift_gray);
            line.setVisibility(View.VISIBLE);
        }
        return this;
    }


    public DialogUtils isTouchCancel() {
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);

        }
        return this;
    }


    public DialogUtils setDialogListener(final DialogListener checkBoxListener) {
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxListener != null) {
                    checkBoxListener.buttType(1);
                }

                dialog.dismiss();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxListener != null) {
                    checkBoxListener.buttType(2);
                }

                dialog.dismiss();
            }
        });
        return this;
    }

    public DialogUtils setTitleStyleBold() {
        title.getPaint().setFakeBoldText(true);//加粗
        return this;
    }

    public DialogUtils show() {
        dialog.show();
        return this;
    }
}
