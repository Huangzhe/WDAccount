package com.sh.lynn.huang.wdaccount.module.detail;

import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.been.BankCardRecord;
import com.sh.lynn.huang.wdaccount.data.bankcard.BankCardRespository;
import com.sh.lynn.huang.wdaccount.data.bankcardrecord.BankCardRecordRepository;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Huangz on 16/5/22.
 */
public class DetailPresenter implements AddBankCardDetailContract.Presenter {
    AddBankCardDetailContract.View addBankView;

//    BankCardDao bankCardDao;
//    BankCardRecordDao bankCardRecordDao;
    BankCardRecordRepository bankCardRecordRepository;
    BankCardRespository bankCardRespository;
    public DetailPresenter(AddBankCardDetailContract.View view){
        this.addBankView = addBankView;
//        bankCardDao = WDApp.getInstance().daoSession.getBankCardDao();
//        bankCardRecordDao=WDApp.getInstance().daoSession.getBankCardRecordDao();
        bankCardRecordRepository = new BankCardRecordRepository();
        bankCardRespository = new BankCardRespository();
    }

    @Override
    public void saveBankCardRecord(BankCardRecord record) {
      //  bankCardRecordDao.insert(record);

        bankCardRecordRepository.saveRecord(record);
    }

    @Override
    public void getBankCardList() {

        //Observable.from()
        bankCardRespository.getBankCards()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<BankCard>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<BankCard> bankCardRecords) {
                        addBankView.showBankCardList(bankCardRecords);
                        //return bankCardRecords;
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
