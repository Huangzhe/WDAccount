package com.sh.lynn.huang.wdaccount.module.bankcard;

import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.data.bankcard.BankCardRespository;

/**
 * Created by Huangz on 16/7/31.
 */
public class AddBankcardPresenter implements AddBankcardContract.Presenter {

    AddBankcardContract.View addBankcardView;
    BankCardRespository bankCardRespository;
    public AddBankcardPresenter(AddBankcardContract.View view){
        addBankcardView = view;
        bankCardRespository = new BankCardRespository();
    }

    @Override
    public void saveBankcard(BankCard bankCard) {
        bankCardRespository.saveBankCard(bankCard);
    }

    @Override
    public void setCardType(int type) {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
