package com.BASofttech.caipiao.ui.fragment;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.NotificationCompat;

import com.BASofttech.caipiao.APIService;
import com.BASofttech.caipiao.bean.NewLuckBean;
import com.BASofttech.caipiao.model.DCBModel;
import com.BASofttech.caipiao.ui.activity.LoginActivity;
import com.BASofttech.caipiao.R;
import com.BASofttech.caipiao.util.GlideImageLoader;
import com.BASofttech.caipiao.util.LogUtil;
import com.BASofttech.caipiao.util.NetWorkUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayerStandard;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.NOTIFICATION_SERVICE;

public class Fragment_Home extends BaseFragment {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.videoplayer)
    JZVideoPlayerStandard jzVideoPlayerStandard;
    @BindView(R.id.test_bt_notice)
    AppCompatButton test_bt_notice;
    private List list;
    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        list = new ArrayList();
    }

    @Override
    protected void initData() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://guoqiang.space")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        APIService apiService = retrofit.create(APIService.class);

        list.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1267755794,1897874823&fm=26&gp=0.jpg");
        list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2814505717,510060409&fm=26&gp=0.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538114721611&di=fbd7d0c84d83c43bf41c26be729bffac&imgtype=0&src=http%3A%2F%2Fpic18.photophoto.cn%2F20110108%2F0035035918164551_b.jpg");
        banner.setImageLoader(new GlideImageLoader());
        //        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);//设置数字还是圆点模式 默认圆点
        banner.setImages(list);
        banner.setDelayTime(2000);
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setOnBannerListener(new OnBannerListener() {//轮播图点击事件
            @Override
            public void OnBannerClick(int position) {
              //  showToast("heheda"+position);
                //通过跳转相应的Activity到相应的webview中
                if(position == 0){
                   showToast("我是第0个图片跳转");
                }else if(position == 1){
                    showToast("我是第一个图片跳转");
                }else{
                    showToast("我是第二张图片跳转");
                }
            }
        });
        banner.start();

        jzVideoPlayerStandard.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "掏粪男孩");
        //        JZVideoPlayerStandard.startFullscreen(getActivity(), JZVideoPlayerStandard.class, "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4", "嫂子辛苦了");
        Glide.with(getActivity()).load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640").into(jzVideoPlayerStandard.thumbImageView);
        // jzVideoPlayerStandard.thumbImageView.setImageURI(url);
            Call<NewLuckBean> newLuck = NetWorkUtil.getApiService().getNewLuck();
            newLuck.enqueue(new Callback<NewLuckBean>() {
                @Override
                public void onResponse(Call<NewLuckBean> call, Response<NewLuckBean> response) {
                    LogUtil.e("onResponse", response.body().toString());
                    NewLuckBean body = response.body();
                    String everyLuck = body.getEveryluck();
                    String everynper = body.getEverynper();
                    LogUtil.e("getLuckandnper", everyLuck + "..." + everynper);
                }

                @Override
                public void onFailure(Call<NewLuckBean> call, Throwable t) {
                    LogUtil.e("onResponse", t.getMessage());
                }
            });
            List<DCBModel> dcbList = LitePal.where().order("dcbDate").find(DCBModel.class);
            String everyPer ="";
            if(dcbList!=null&&dcbList.size()>0){
                List<DCBModel> dcbList2 = LitePal.select("MAX(id)","dcbball","dcbdate").where().order("id").find(DCBModel.class);
//                LitePal.where("id=?",).order("dcbDate").find(DCBModel.class);
                for (DCBModel dcb:
                     dcbList2) {
                    everyPer =dcb.getDcbDate();
                    Log.e("everyPer",dcb.getId()+"");
//                    Log.e("everyPer",everyPer);
//                    Log.e("everyPer",dcb.getDcbBall());
                }
            }else{
                everyPer ="";
            }
            Log.e("everyPer1",everyPer);
            Call<List<NewLuckBean>> allLuck = NetWorkUtil.getApiService().getAllLuck(everyPer);
            allLuck.enqueue(new Callback<List<NewLuckBean>>() {
                @Override
                public void onResponse(Call<List<NewLuckBean>> call, Response<List<NewLuckBean>> response) {
                    Gson gson = new Gson();
                    List<NewLuckBean> stringList = response.body();

                    for (NewLuckBean newLuckBean:stringList){
//                        Log.e("response222222",newLuckBean.getEveryluck());
                        DCBModel dn = new DCBModel();
                        dn.setDcbBall(newLuckBean.getEveryluck());
                        dn.setDcbDate(newLuckBean.getEverynper());
                        dn.save();
                    }
                }

                @Override
                public void onFailure(Call<List<NewLuckBean>> call, Throwable t) {
                    LogUtil.e("onResponse12", t.getMessage());
                }
            });
            Call<List<NewLuckBean>> myLuck = NetWorkUtil.getApiService().getMyLuck();
            myLuck.enqueue(new Callback<List<NewLuckBean>>() {
                @Override
                public void onResponse(Call<List<NewLuckBean>> call, Response<List<NewLuckBean>> response) {
                    LogUtil.e("getResponse2", response.body().toString());
                }

                @Override
                public void onFailure(Call<List<NewLuckBean>> call, Throwable t) {
                    LogUtil.e("getResponse23", t.getMessage());
                }
            });
    }
    @OnClick(R.id.test_bt_notice)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_bt_notice:
                showNotifications(getActivity(), "呵呵呵");
                break;
        }
    }

    @Override
    public void onPause() {
        jzVideoPlayerStandard.release();
        super.onPause();
    }

    /**
     * 自定义通知布局
     *
     * @param context 上下文
     * @param msg     消息体
     *                //@param intent  intent
     */

    public void showNotifications(Context context, String msg) {
        int mNotificationId = hashCode();
        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        @SuppressWarnings("Deprecated")
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        if(Build.VERSION.SDK_INT >= 26){
            NotificationChannel channel = new NotificationChannel("Test", getString(R.string.app_name), NotificationManager.IMPORTANCE_HIGH);
            //获取系统通知响铃声音的配置
//            channel.getAudioAttributes();
            channel.setSound(Uri.parse("android.resource://" + getActivity().getPackageName() + "/raw/son"),null);
            channel.enableLights(true);
            //是否允许震动
            channel.enableVibration(true);
            //设置震动模式
            channel.setVibrationPattern(new long[]{500, 500 });
            //是否会有灯光
            channel.shouldShowLights();
            builder.setChannelId("Test");
            manager.createNotificationChannel(channel);
        }
        builder.setContentTitle("hehehe")
                .setContentText("可拉伸机到付款了房间打扫克里斯")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.app_icon)//设置和时间一栏的工具栏图片icon下同  符合什么规则这个必须黑白
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.app_icon))//设置通知栏图标也得符合什么规则
                .setColor(Color.parseColor("#41b5ea"))
                .setDefaults(Notification.DEFAULT_ALL)
//                .setOnlyAlertOnce(true)   //设置点击发送通知只确认首次
                .setAutoCancel(true);
        Intent intent = new Intent(context, LoginActivity.class);
        //TODO 设置action作为标识
        /*TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(LoginActivity.class);
        stackBuilder.addNextIntent(intent);*/

        PendingIntent contentIntent = PendingIntent.getBroadcast(context, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        manager.notify(mNotificationId, builder.build());


//        PendingIntent contentIntent = PendingIntent.getActivity(context,0,intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        builder.setContentIntent(contentIntent);
//       /* Notification notifation  = builder.build();
//        notifation.flags = Notification.FLAG_AUTO_CANCEL;*/
//        manager.notify(1, builder.build());
        /*Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("This is content title")
                .setContentText("This is content test")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.app_icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.app_icon))
                .build();
        manager.notify(1, notification);*/

    }
}
