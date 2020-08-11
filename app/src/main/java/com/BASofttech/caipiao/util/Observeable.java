package com.BASofttech.caipiao.util;

import java.util.Observable;

/**
 * created by stray cat on 2019/8/27.
 */
public class Observeable extends Observable {

    private static Observeable mObserveable;
    private Observeable(){}

    public static Observeable getInstance(){
        if (mObserveable == null){
            synchronized (Observeable.class){
                if (mObserveable == null){
                    mObserveable = new Observeable();
                }
            }
        }
        return mObserveable;
    }
    public void setState(int state){
        setChanged();
        notifyObservers(state);
        LogUtil.e("state",state+"int");
    }
}
