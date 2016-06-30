package com.sh.lynn.huang.wdaccount.module.detail;

import com.sh.lynn.huang.wdaccount.BasePresenter;
import com.sh.lynn.huang.wdaccount.BaseView;

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

        void getBankCard();



    }
}
