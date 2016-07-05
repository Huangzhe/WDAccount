package com.sh.lynn.huang.wdaccount.module.main;

/**
 *
 */
public class MainPresenter  implements MainContract.Presenter{

    private MainContract.View mainView;
    public MainPresenter(MainContract.View mainView){
    this.mainView = mainView;
   // this.mainView.setPresenter(this);
    }
    @Override
    public void goToAddPage(RecordType tag) {
        switch (tag){
            case BankRecord:
                mainView.gotoAddBankRecord();
                break;
            case InvestRecord:
                mainView.gotoAddInvestRecord();
                break;
            case ReturnRecord:
                mainView.gotoAddReturnRecord();
                break;
        }
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
