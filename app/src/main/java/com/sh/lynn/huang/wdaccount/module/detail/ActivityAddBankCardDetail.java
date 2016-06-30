package com.sh.lynn.huang.wdaccount.module.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.sh.lynn.huang.wdaccount.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActivityAddBankCardDetail extends AppCompatActivity implements AddBankCardDetailContract.View {

    @Bind(R.id.tv_checkBankCard)
    TextView tv_checkBankCard;

    @Bind(R.id.et_money)
    EditText et_money;

    @Bind(R.id.et_desc)
    EditText et_desc;

    private AddBankCardDetailContract.Presenter mPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_add_bank_card_detail);

        ButterKnife.bind(this);

    }

    @Override
    public void setBankCard(String bankCard) {


        tv_checkBankCard.setText(bankCard);
    }

    @Override
    public void showBankCardList() {

    }

    @Override
    public void setPresenter(AddBankCardDetailContract.Presenter presenter) {
        mPresent =presenter;
    }


}
