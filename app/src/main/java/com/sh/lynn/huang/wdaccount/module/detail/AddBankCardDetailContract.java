package com.sh.lynn.huang.wdaccount.module.detail;

import com.sh.lynn.huang.wdaccount.BasePresenter;
import com.sh.lynn.huang.wdaccount.BaseView;
import com.sh.lynn.huang.wdaccount.been.BankCard;

import java.util.List;

/**
 * Created by hyz84 on 16/6/30.
 */
public class AddBankCardDetailContract {

    public interface View extends BaseView<Presenter>{

        void setBankCard(String bankCard);
        void showBankCardList();

    }

    public interface Presenter extends BasePresenter {

        void saveBankCardRecord();

        List<BankCard> getBankCardList();



    }
}
