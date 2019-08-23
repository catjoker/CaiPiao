package com.BASofttech.caipiao.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.util.BasicAdapter;
import com.BASofttech.caipiao.util.ViewHolder;

import java.lang.reflect.Type;
import java.util.List;

public class ListViewAdapter extends BasicAdapter<String> {

	public ListViewAdapter(List<String> datas, Context context) {
		super(datas, context);
	}
	public ListViewAdapter(List<String> datas, Context context, String type) {
		super(datas, context, type);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView=View.inflate(context, R.layout.item_present_num,null);
			TextView tv_cs = ViewHolder.get(convertView, R.id.tv_cs);

			SpannableStringBuilder style=new SpannableStringBuilder(datas.get(position));
			ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.rgb(234, 32, 0));
			ForegroundColorSpan greenSpan = new ForegroundColorSpan(Color.rgb(36, 178, 246));
			if(type != null){
				if("双色球".equals(type)){
					style.setSpan(redSpan,0,17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
					style.setSpan(greenSpan,17,22, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				}else if("大乐透".equals(type)){
					style.setSpan(redSpan,0,14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
					style.setSpan(greenSpan,15,21, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				}
			}else{
				tv_cs.setTextColor(Color.rgb(43, 91, 141));
			}


			tv_cs.setText(style);
			//千万别自己编数字--!170329  或者用下面的方法 jiangcsl传进去  当然得先行以color文件的颜色
			//Resources resource = (Resources) getBaseContext().getResources();  
			//ColorStateList csl = (ColorStateList) resource.getColorStateList(R.color.my_color);
//			tv_cs.setTextColor(Color.rgb(43, 91, 141));
		}
		return convertView;
	}

	@Override
	public int getItemViewType(int position) {
	//	Log.e("positiong=======",position+"");
		return position;
	}

	@Override
	public int getViewTypeCount() {
		return 20;
	}

}
