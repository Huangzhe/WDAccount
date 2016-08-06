package com.sh.lynn.huang.wdaccount.module.bankcard;

/**
 * Created by hyz84 on 16/8/5.
 */
public class BankListPresenter implements BankCardListContract.Presenter {
    BankCardListContract.View bankCardListView;

    public BankListPresenter(BankCardListContract.View view){
        bankCardListView = view;
    }

    @Override
    public void getBankCardList() {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
