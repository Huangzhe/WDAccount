package com.sh.lynn.huang.wdaccount.module.bankcard;

import com.sh.lynn.huang.wdaccount.BasePresenter;
import com.sh.lynn.huang.wdaccount.BaseView;
import com.sh.lynn.huang.wdaccount.been.BankCard;

import java.util.List;

/**
 * Created by hyz84 on 16/7/29.
 */
public interface BankCardListContract {
    public interface View extends BaseView<Presenter> {


        public void showList(List<BankCard> list);
        public void gotoAddBankCardAct();

    }
    public interface Presenter extends BasePresenter {

       public void getBankCardList();


    }
}
