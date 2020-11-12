package com.BASofttech.caipiao.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.model.DCBModel;
import com.BASofttech.caipiao.util.Constant;
import com.BASofttech.caipiao.util.Observeable;

import java.util.ArrayList;

/**
 * created by stray cat on 2019/8/21.
 */
public class RandomListAdapter extends RecyclerView.Adapter<RandomListAdapter.RandomHolder>{
    private ArrayList<String> list;
    private Context context;
    public RandomListAdapter(ArrayList<String> list, Context context){
        this.list = list;
        this.context = context;
    }
    private RandomListAdapter(){}
    @NonNull
    @Override
    public RandomListAdapter.RandomHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RandomHolder holder = new RandomHolder(LayoutInflater.from(
                context).inflate(R.layout.item_present_num, viewGroup,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RandomListAdapter.RandomHolder holder, int position) {
        SpannableStringBuilder style = new SpannableStringBuilder(list.get(position));
        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.rgb(234, 32, 0));
        ForegroundColorSpan greenSpan = new ForegroundColorSpan(Color.rgb(36, 178, 246));

        //列表信息颜色
        if (Constant.spinnerSb.toString() != null) {
            if (Constant.DCB_NAME.equals(Constant.spinnerSb.toString())) {
                style.setSpan(redSpan, 0, 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                style.setSpan(greenSpan, 17, 22, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                DCBModel dcb = new DCBModel();
//                dcb.setRedBall1(list.get(position).substring(0, 2));
//                dcb.setRedBall2(list.get(position).substring(3, 5));
//                dcb.setRedBall3(list.get(position).substring(6, 8));
//                dcb.setRedBall4(list.get(position).substring(9, 11));
//                dcb.setRedBall5(list.get(position).substring(12, 14));
//                dcb.setRedBall6(list.get(position).substring(15, 17));
//                dcb.setBlueBall(list.get(position).substring(20, 22));
//                dcb.save();
            } else if (Constant.DLT_NAME.equals(Constant.spinnerSb.toString())) {
                style.setSpan(redSpan, 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                style.setSpan(greenSpan, 15, 21, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else if (Constant.SEVEN_NAME.equals(Constant.spinnerSb.toString())) {
                style.setSpan(redSpan, 0, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        } else {
            holder.tv_cs.setTextColor(Color.rgb(43, 91, 141));
        }
        holder.tv_cs.setText(style);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class RandomHolder extends RecyclerView.ViewHolder{
        TextView tv_cs;
        public RandomHolder(View view){
            super(view);
            tv_cs = view.findViewById(R.id.tv_cs);
        }
    }

}
