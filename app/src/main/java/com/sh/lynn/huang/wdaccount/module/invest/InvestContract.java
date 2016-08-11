package com.sh.lynn.huang.wdaccount.module.invest;

import com.sh.lynn.huang.wdaccount.BasePresenter;
import com.sh.lynn.huang.wdaccount.BaseView;
import com.sh.lynn.huang.wdaccount.been.InvestRecord;

import java.util.List;

/**
 * Created by hyz84 on 16/8/10.
 */
public interface InvestContract {
    public interface View extends BaseView<Presenter> {

      void  setInvestList(List<InvestRecord> list);
    }
    public interface Presenter extends BasePresenter {

        List<InvestRecord>  getInversList();

    }
}
