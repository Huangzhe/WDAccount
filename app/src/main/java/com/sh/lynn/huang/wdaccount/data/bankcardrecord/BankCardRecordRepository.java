package com.sh.lynn.huang.wdaccount.data.bankcardrecord;

import android.support.annotation.NonNull;

import com.sh.lynn.huang.wdaccount.been.BankCardRecord;
import com.sh.lynn.huang.wdaccount.dao.BankCardRecordDao;
import com.sh.lynn.huang.wdaccount.ui.WDApp;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by hyz84 on 16/7/7.
 */
public class BankCardRecordRepository implements  BankCardRecordDataSource{

    BankCardRecordDao dao ;
    public BankCardRecordRepository(){
        dao = WDApp.getInstance().daoSession.getBankCardRecordDao();
    }

    @Override
    public Observable<List<BankCardRecord>> getRecords() {


        Observable<List<BankCardRecord>> observable = Observable.create(new Observable.OnSubscribe<List<BankCardRecord>>() {
            @Override
            public void call(Subscriber<? super List<BankCardRecord>> subscriber) {
                List<BankCardRecord> list =dao.loadAll();
                subscriber.onNext(list);
                subscriber.onCompleted();
            }
        });

        return observable;
    }

    @Override
    public Observable<BankCardRecord> getRecord(@NonNull String taskId) {


        return null;
    }

    @Override
    public void saveRecord(@NonNull BankCardRecord record) {
        dao.insert(record);
    }

    @Override
    public void refreshRecords() {

    }

    @Override
    public void deleteAllRecords() {

    }

    @Override
    public void deleteRecord(@NonNull String recordId) {

    }
}
