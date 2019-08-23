package com.BASofttech.caipiao.util;
/**
 * @author Stray Cat 2016/04/03
 * 抽取的baseadapter工具类
 * */
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class BasicAdapter<T> extends BaseAdapter {
	protected List<T> datas;
    protected Context context;
    protected String type;

	public BasicAdapter(List<T> datas, Context context) {
		super();
		this.datas = datas;
		this.context = context;
	}
	public BasicAdapter(List<T> datas, Context context,String type) {
		super();
		this.datas = datas;
		this.context = context;
		this.type = type;
	}

	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public  abstract View getView(int position, View convertView, ViewGroup parent);
	@Override
	public  abstract int getItemViewType(int position);
	@Override
	public abstract int getViewTypeCount();
}
