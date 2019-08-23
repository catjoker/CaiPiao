package com.BASofttech.caipiao.util;
/**
 * @author Stray Cat 2016/04/03
 * 抽取ViewHolder工具类
 * */
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

public class ViewHolder { 
    public static <T extends View> T get(View view, int id) { 
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag(); 
        if (viewHolder == null) { 
            viewHolder = new SparseArray<View>(); 
            view.setTag(viewHolder);
            Log.e("lllll","jjjj");
        }
        View childView = viewHolder.get(id); 
        if (childView == null) { 
            childView = view.findViewById(id); 
            viewHolder.put(id, childView); 
        } 
        return (T) childView; 
    } 
} 