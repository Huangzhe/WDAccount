package com.sh.lynn.huang.wdaccount.data.p2pplatform;

import android.support.annotation.NonNull;

import com.sh.lynn.huang.wdaccount.been.Platform;
import com.sh.lynn.huang.wdaccount.dao.PlatformDao;
import com.sh.lynn.huang.wdaccount.ui.WDApp;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by hyz84 on 16/7/25.
 */
public class P2PPlatformRepository implements P2PPlatformDataSource {

    PlatformDao dao ;
    public P2PPlatformRepository(){
        dao = WDApp.getInstance().daoSession.getPlatformDao();
    }



    @Override
    public Observable<List<Platform>> getPlatforms() {
        Observable<List<Platform>> observable = Observable.create(new Observable.OnSubscribe<List<Platform>>() {
            @Override
            public void call(Subscriber<? super List<Platform>> subscriber) {
                List<Platform> list =dao.loadAll();
                subscriber.onNext(list);
                subscriber.onCompleted();
            }
        });

        return observable;
    }

    @Override
    public Observable<Platform> getPlatform(@NonNull String id) {
        return null;
    }

    @Override
    public void savePlatform(@NonNull Platform pf) {

    }

    @Override
    public void refreshPlatforms() {

    }

    @Override
    public void deleteAllPfs() {

    }

    @Override
    public void deletePlatform(@NonNull Long id) {

    }
}
