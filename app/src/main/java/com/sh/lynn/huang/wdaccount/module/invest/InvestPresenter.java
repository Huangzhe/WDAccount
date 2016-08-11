package com.sh.lynn.huang.wdaccount.module.invest;

import com.sh.lynn.huang.wdaccount.been.InvestRecord;

import java.util.List;

/**
 * Created by Huangz on 16/5/22.
 */
public class InvestPresenter implements InvestContract.Presenter {

    public InvestPresenter(InvestContract.View view){}


    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public List<InvestRecord> getInversList() {
        return null;
    }
}
