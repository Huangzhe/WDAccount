package com.sh.lynn.huang.wdaccount.module.bankcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.been.BankCard;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddBankcardAct extends AppCompatActivity implements  AddBankcardContract.View
{
    @BindView(R.id.ll_returnTime)
    LinearLayout ll_returnTime;

    @BindView(R.id.ll_accountTime)
    LinearLayout ll_accountTime;

    @BindView(R.id.tv_bankName)
    TextView tv_bankName;

    @BindView(R.id.et_bankcard)
    EditText et_bankcard;
@BindView(R.id.rg_bankcardType)
RadioGroup rg_bankcardType;
AddBankcardContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bankcard);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rg_bankcardType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_creditCard://信用卡
                       mPresenter.setCardType(0);

                        break;
                    case R.id.rb_deditCard://借记卡
                        mPresenter.setCardType(1);
                        break;
                }
            }
        });

        mPresenter = new AddBankcardPresenter(this);
    }


    @Override
    public void showCreditCardContent(boolean isShow) {

        if(isShow){
            ll_returnTime.setVisibility(View.VISIBLE);
            ll_accountTime.setVisibility(View.VISIBLE);
        }else{
            ll_returnTime.setVisibility(View.GONE);
            ll_accountTime.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.btn_save)
    public void saveBankCard(){
        BankCard bankCard = new BankCard();
        String bankName = tv_bankName.getText().toString();
        if(TextUtils.isEmpty(bankName)){
            tv_bankName.setError("发卡行名称不能为空!");
            return;
        }

        String cardNo = et_bankcard.getText().toString();

        if(TextUtils.isEmpty(bankName)){
            et_bankcard.setError("卡号不能为空！");
            return;
        }

        bankCard.setBankName(bankName);

    }

    @Override
    public void setPresenter(AddBankcardContract.Presenter presenter) {

    }
}
