package com.BASofttech.caipiao;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by stray cat on 2017/5/3.
 */

public class ConnectionService extends Service{
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
