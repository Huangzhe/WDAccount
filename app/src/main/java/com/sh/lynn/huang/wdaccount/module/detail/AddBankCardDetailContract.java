package com.sh.lynn.huang.wdaccount.module.detail;

import com.sh.lynn.huang.wdaccount.base.BasePresenter;
import com.sh.lynn.huang.wdaccount.base.BaseView;
import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.been.BankCardRecord;

import java.util.List;

/**
 * Created by hyz84 on 16/6/30.
 */
public class AddBankCardDetailContract {

    public interface View extends BaseView<Presenter>{

        void setBankCard(String bankCard);
        void showBankCardList(List<BankCard> bankCardRecords);

    }

    public interface Presenter extends BasePresenter {

        void saveBankCardRecord(BankCardRecord record);

        void getBankCardList();



    }
}
