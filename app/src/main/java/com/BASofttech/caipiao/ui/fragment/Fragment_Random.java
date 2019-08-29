package com.BASofttech.caipiao.ui.fragment;

import android.os.Handler;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.adapter.ListViewAdapter;
import com.BASofttech.caipiao.adapter.RandomListAdapter;
import com.BASofttech.caipiao.ui.activity.LoginActivity;
import com.BASofttech.caipiao.util.Constant;
import com.BASofttech.caipiao.util.Observeable;
import com.BASofttech.caipiao.util.RandomCalculate;
import com.ajguan.library.EasyRefreshLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 优化随机数生成逻辑 190403
 * 优化代码结构,将内部类分离出去190821
 */
public class Fragment_Random extends BaseFragment implements EasyRefreshLayout.EasyEvent, Observer {
    @BindView(R.id.bt_random)
    AppCompatButton bt_random;
    @BindView(R.id.bt_clear)
    AppCompatButton bt_clear;
    @BindView(R.id.iv_login)
    AppCompatImageView iv_login;
    @BindView(R.id.tv)
    AppCompatTextView tv;
    @BindView(R.id.lv)
    RecyclerView recyclerView;
    @BindView(R.id.et)
    AppCompatEditText et;
    @BindView(R.id.spinner)
    AppCompatSpinner spinner;
    @BindView(R.id.easyRefreshLayout)
    EasyRefreshLayout easyRefreshLayout;

    /**
     * TODO 建一个数据库,将每次得到的数据存进数据库中,通过查询将数据添加到列表里. 再设置一个清空按钮将数据库的数据全部清空
     * 目测需要用户id,双色球号码 如果只是单机的话,只需要号码就可以了 12/22竟然不重复了 但是并没有解决复用的问题
     * 那就只能到时候规定购买的随机注数只有显示的数量了
     */
    final ArrayList<String> list = new ArrayList<>();
    private ListViewAdapter myAdapter;
    private List lists;
    private RandomListAdapter randomListAdapter;
    private RandomCalculate cal;
    private int endIndex;
    private int startIndex;
    private final int pageSize = 20;
    private int parseInt;

    @Override
    protected int setLayout() {
        return R.layout.activity_double_color_ball;
    }

    @Override
    protected void initView(View view) {
        easyRefreshLayout.addEasyEvent(this);
        //观察者模式初始化
        Observeable.getInstance().addObserver(this);
        lists = new ArrayList<String>();
    }

    @Override
    protected void initData() {
        startIndex = 0;
        endIndex = pageSize;
        lists.add(Constant.DCB_NAME);
        lists.add(Constant.DLT_NAME);
        lists.add(Constant.SEVEN_NAME);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, lists);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setBackgroundColor(getResources().getColor(R.color.buttonorange));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cardNumber = spinner.getSelectedItem().toString();
                Constant.spinnerSb.setLength(0);
                Constant.spinnerSb.append(cardNumber);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        randomListAdapter = new RandomListAdapter(list, mContext);
        recyclerView.setAdapter(randomListAdapter);
    }

    @OnClick({R.id.bt_random, R.id.bt_clear, R.id.iv_login})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bt_random:
                // 获得自定义的注数
                endIndex = pageSize;
                startIndex = 0;
                Observeable.getInstance().setState(Constant.BUTTON_RANDOM);
                break;
            // 清空
            case R.id.bt_clear:
                tv.setText("");
                et.setText("");
                list.clear();
                randomListAdapter.notifyDataSetChanged();
                break;
            // 进入登录页面
            case R.id.iv_login:
                toClass(mContext, LoginActivity.class);
                break;
            default:
                break;
        }

    }

    private void btnRandom() {
        list.clear();
        randomListAdapter.notifyDataSetChanged();
        try {
            if (et.getText().toString() != null
                    && !"".equals(et.getText().toString())) {
                parseInt = Integer.parseInt(et.getText().toString());
                if (parseInt >= endIndex) {
                    for (int i = startIndex; i < endIndex; i++) {
                        clickRandomMoment(Constant.spinnerSb.toString());
                    }
                } else {
                    for (int i = startIndex; i < parseInt; i++) {
                        clickRandomMoment(Constant.spinnerSb.toString());
                    }
                }

                randomListAdapter.notifyDataSetChanged();
            } else {
                // 默认执行一次
                clickRandomMoment(Constant.spinnerSb.toString());

            }
        } catch (Exception e) {
            showToast("请输入数字,并且不超过50注");
        }
    }

    //开始随机
    private void clickRandomMoment(String type) {
        cal = new RandomCalculate();
        String randomString = cal.printCP(type);
        list.add(randomString);
    }


    @Override
    public void onResume() {
        tv.setText("");
        randomListAdapter.notifyDataSetChanged();
        super.onResume();
    }


    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                easyRefreshLayout.loadMoreComplete();
//                randomListAdapter.notifyDataSetChanged();
                easyRefreshLayout.loadMoreComplete(new EasyRefreshLayout.Event() {
                    @Override
                    public void complete() {
                        startIndex += pageSize;
                        endIndex += pageSize;
                        if (parseInt - endIndex > 0) {
                            for (int i = startIndex; i < endIndex; i++) {
                                clickRandomMoment(Constant.spinnerSb.toString());
                            }
                        } else if (parseInt - endIndex < 0 && parseInt - startIndex > 0) {
                            for (int i = startIndex; i < parseInt; i++) {
                                clickRandomMoment(Constant.spinnerSb.toString());
                            }
                        } else {
                            showToast("没有更多");
                        }
                        randomListAdapter.notifyDataSetChanged();
                    }
                }, 500);
            }
        }, 2000);
    }

    @Override
    public void onRefreshing() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                easyRefreshLayout.autoRefresh(1000);
                easyRefreshLayout.refreshComplete();
                randomListAdapter.notifyDataSetChanged();
                showToast("refresh success");
            }
        }, 1000);
    }

    @Override
    public void update(Observable o, Object arg) {
        int type = (int) arg;
        switch (type) {
            case Constant.BUTTON_RANDOM:
                btnRandom();
                break;

        }
    }
}
