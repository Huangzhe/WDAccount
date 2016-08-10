package com.sh.lynn.huang.wdaccount.data.investrecord;

import android.support.annotation.NonNull;

import com.sh.lynn.huang.wdaccount.been.InvestRecord;
import com.sh.lynn.huang.wdaccount.dao.InvestRecordDao;
import com.sh.lynn.huang.wdaccount.ui.WDApp;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by hyz84 on 16/7/25.
 */
public class InvestRecordRepository implements InvestRecordDataSource {


    private static InvestRecordRepository INSTANCE;

    InvestRecordDao dao;

    private InvestRecordRepository() {
        dao = checkNotNull(WDApp.getInstance().daoSession.getInvestRecordDao(), "数据库启动失败，请重试");

    }


    public static InvestRecordRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InvestRecordRepository();
        }
        return INSTANCE;
    }


    @Override
    public Observable<List<InvestRecord>> getRecords() {
        Observable<List<InvestRecord>> observable = Observable.create(new Observable.OnSubscribe<List<InvestRecord>>() {
            @Override
            public void call(Subscriber<? super List<InvestRecord>> subscriber) {
                List<InvestRecord> list =dao.loadAll();
                subscriber.onNext(list);
                subscriber.onCompleted();
            }
        });

        return observable;
    }

    @Override
    public Observable<InvestRecord> getRecord(@NonNull final Long recordId) {
        Observable<InvestRecord> observable = Observable.create(new Observable.OnSubscribe<InvestRecord>() {
            @Override
            public void call(Subscriber<? super InvestRecord> subscriber) {
                InvestRecord  record = dao.load(recordId);
                subscriber.onNext(record);
                subscriber.onCompleted();
            }
        });

        return observable;
    }

    @Override
    public void saveRecord(@NonNull InvestRecord record) {

        dao.insert(record);
    }

    @Override
    public void refreshRecords() {

    }

    @Override
    public void deleteAllRecords() {
        dao.deleteAll();
    }

    @Override
    public void deleteRecord(@NonNull Long recordId) {
        dao.deleteByKey(recordId);
    }
}
