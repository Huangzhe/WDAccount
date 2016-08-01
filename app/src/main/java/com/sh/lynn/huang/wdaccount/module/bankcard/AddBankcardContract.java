package com.sh.lynn.huang.wdaccount.module.bankcard;

import com.sh.lynn.huang.wdaccount.BasePresenter;
import com.sh.lynn.huang.wdaccount.BaseView;
import com.sh.lynn.huang.wdaccount.been.BankCard;

/**
 * Created by Huangz on 16/7/31.
 */
public class AddBankcardContract {

    public interface View extends BaseView<Presenter> {
        public void showCreditCardContent(boolean isShow);
    }
    public interface Presenter extends BasePresenter {

        public void saveBankcard(BankCard bankCard);

        public void setCardType(int type);

    }
}
