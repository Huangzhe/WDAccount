package com.sh.lynn.huang.wdaccount.module.invest;

import com.sh.lynn.huang.wdaccount.BasePresenter;
import com.sh.lynn.huang.wdaccount.BaseView;
import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.been.InvestRecord;
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
        void gotoP2PPfAct();
        void setIncome(double income);
    }

    public interface Presenter extends BasePresenter {

        void saveInvestRecord(InvestRecord record);

        void getBankCardList();

        void getPlatformList();

        void setInvetsType(int type);

        void gotoAddP2PPlatform();

        double calIncome();

    }
}
