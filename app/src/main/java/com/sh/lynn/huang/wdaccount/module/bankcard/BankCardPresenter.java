package com.sh.lynn.huang.wdaccount.module.bankcard;

import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.data.bankcard.BankCardRespository;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by hyz84 on 16/7/29.
 */
public class BankCardPresenter implements  BankCardListContract.Presenter {
    BankCardRespository bankCardRespository;
    BankCardListContract.View mView;
    public BankCardPresenter(BankCardListContract.View view){
        bankCardRespository =  BankCardRespository.getInstance();
        mView = view;
    }

    @Override
    public void getBankCardList() {
      bankCardRespository.getBankCards()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Action1<List<BankCard>>() {
                 @Override
                 public void call(List<BankCard> bankCards) {
                     mView.showList(bankCards);
                 }
             });
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
