package com.sh.lynn.huang.wdaccount.module.main;

import com.sh.lynn.huang.wdaccount.BasePresenter;
import com.sh.lynn.huang.wdaccount.BaseView;

/**
 * Created by Huangz on 16/6/6.
 */
public interface MainContract {

    public interface View extends BaseView{

        void showToal(String balance,String loan,String invest);

        void showInvest();
        void showLoan();
        void showPopMenu ();
        void setLoadingIndicator(boolean active);
        //void
    }

    public interface Presenter extends BasePresenter{

        void addRecord();
        void addInvers();
        void addLoan();

    }
}
