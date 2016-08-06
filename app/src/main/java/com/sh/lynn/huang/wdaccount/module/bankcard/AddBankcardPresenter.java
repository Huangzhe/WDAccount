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
     long ret =   bankCardRespository.saveBankCard(bankCard);
        addBankcardView.clearText(ret);
        //addBankcardView
    }

    /**
     * 1 借记卡，0 信用卡
     * @param type
     */
    @Override
    public void setCardType(int type) {

        if(type ==1){
            addBankcardView.showCreditCardContent(false);
        }else{
            addBankcardView.showCreditCardContent(true);
        }
    }

    @Override
    public void setDate(int date,int id) {
        addBankcardView.setDateText(date,id);
        addBankcardView.showDateDialog(false,0);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
