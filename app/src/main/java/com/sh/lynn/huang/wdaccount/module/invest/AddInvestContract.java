package com.sh.lynn.huang.wdaccount.module.invest;

import com.sh.lynn.huang.wdaccount.BasePresenter;
import com.sh.lynn.huang.wdaccount.BaseView;
import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.been.BankCardRecord;
import com.sh.lynn.huang.wdaccount.been.Platform;

import java.util.List;

/**
 * Created by Huangz on 16/7/19.
 */
public class AddInvestContract {

    public interface View extends BaseView<Presenter> {

        void setBankCard(String bankCard);
        void showBankCardList(List<BankCard> bankCardRecords);
        void showDateDialog();
        void showExtendView(int type);
        void showPlatformList(List<Platform> pfLists);
        void setPlatform(Platform platform);
    }

    public interface Presenter extends BasePresenter {

        void saveInvestRecord(BankCardRecord record);

        void getBankCardList();

        void getPlatformList();



    }
}
