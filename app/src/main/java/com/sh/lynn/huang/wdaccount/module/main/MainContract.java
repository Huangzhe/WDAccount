package com.sh.lynn.huang.wdaccount.module.main;

import com.sh.lynn.huang.wdaccount.BasePresenter;
import com.sh.lynn.huang.wdaccount.BaseView;

/**
 * Created by Huangz on 16/6/6.
 */
public interface MainContract {

    public interface View extends BaseView<Presenter>{


        void gotoAddBankRecord();
        void gotoAddInvestRecord();
        void gotoAddReturnRecord();
        //void
    }

    public interface Presenter extends BasePresenter{

        void goToAddPage(RecordType tag);

    }
}
