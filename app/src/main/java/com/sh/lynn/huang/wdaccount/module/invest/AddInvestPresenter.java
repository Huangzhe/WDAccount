package com.sh.lynn.huang.wdaccount.module.invest;

import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.been.InvestRecord;
import com.sh.lynn.huang.wdaccount.data.bankcard.BankCardRespository;
import com.sh.lynn.huang.wdaccount.data.investrecord.InvestRecordRepository;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Huangz on 16/7/24.
 */
public class AddInvestPresenter implements AddInvestContract.Presenter {
    private AddInvestContract.View mAddInvesView;
    private InvestRecordRepository investRecordRepository;
    private BankCardRespository bankCardRespository;
    public AddInvestPresenter(AddInvestContract.View view){
        mAddInvesView=view;
        investRecordRepository = new InvestRecordRepository();
        bankCardRespository = new BankCardRespository();
    }

    @Override
    public void saveInvestRecord(InvestRecord record) {

        investRecordRepository.saveRecord(record);

    }

    @Override
    public void getBankCardList() {
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
                        mAddInvesView.showBankCardList(bankCardRecords);
                        //return bankCardRecords;
                    }
                });
    }

    @Override
    public void getPlatformList() {

    }

    @Override
    public void setInvetsType(int type) {

    }

    @Override
    public void gotoAddP2PPlatform() {

    }

    @Override
    public double calIncome() {
        return 0;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
