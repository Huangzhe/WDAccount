package com.sh.lynn.huang.wdaccount.data.bankcard;

import android.support.annotation.NonNull;

import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.dao.BankCardDao;
import com.sh.lynn.huang.wdaccount.ui.WDApp;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by hyz84 on 16/7/8.
 */
public class BankCardRespository implements BankCardDataSource {
    private static BankCardRespository INSTANCE;

    BankCardDao dao;

    private BankCardRespository() {
        dao = checkNotNull(WDApp.getInstance().daoSession.getBankCardDao(), "数据库启动失败，请重试");

    }

    public static BankCardRespository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BankCardRespository();
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<BankCard>> getBankCards() {

        return Observable.create(new Observable.OnSubscribe<List<BankCard>>() {
            @Override
            public void call(Subscriber<? super List<BankCard>> subscriber) {
                subscriber.onNext(dao.loadAll());
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public Observable<BankCard> getBankCard(@NonNull String id) {
        return null;
    }

    @Override
    public long saveBankCard(@NonNull BankCard bankCard) {
        return dao.insert(bankCard);
    }

    @Override
    public void refreshBankCards() {

    }

    @Override
    public void deleteAllBankCards() {

    }

    @Override
    public void deleteBankCard(@NonNull String id) {

    }
}
