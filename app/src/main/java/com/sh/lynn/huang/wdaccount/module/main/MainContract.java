package com.sh.lynn.huang.wdaccount.module.main;

import com.sh.lynn.huang.wdaccount.base.BasePresenter;
import com.sh.lynn.huang.wdaccount.base.BaseView;

/**
 * Created by Huangz on 16/6/6.
 */
public interface MainContract {

    public interface View extends BaseView<Presenter>{

        void gotoAddBankRecord();
        void gotoAddInvestRecord();
        void gotoAddReturnRecord();
        void gotoBankCardList();
        //void
    }

    public interface Presenter extends BasePresenter{

        void goToAddPage(RecordType tag);

    }
}
