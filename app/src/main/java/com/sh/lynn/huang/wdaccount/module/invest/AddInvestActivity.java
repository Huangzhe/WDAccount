package com.sh.lynn.huang.wdaccount.module.invest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.been.Platform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddInvestActivity extends AppCompatActivity implements AddInvestContract.View {


    @BindView(R.id.rg_investType)
    RadioGroup rg_investType;
//    @BindView(R.id.tv_checksource)
//    TextView tv_checksource;
    @BindView(R.id.et_investmoney)
    EditText et_investmoney;
    @BindView(R.id.et_investTarget)
    EditText et_investTarget;
    @BindView(R.id.spinner_bankCard)
    Spinner spinner_bankCard;
    @BindView(R.id.layout_p2p)
    View layout_p2p;
    @BindView(R.id.layout_funds)
    View layout_funds;
    AddInvestPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_invest);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mPresenter = new AddInvestPresenter(this);
        rg_investType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                    mPresenter.showExtendView(checkedId);

            }
        });
    }

    @Override
    public void setBankCard(String bankCard) {

    }

    @Override
    public void showBankCardList(List<BankCard> bankCardRecords) {

    }

    @Override
    public void showDateDialog() {

    }

    @Override
    public void showExtendView(int type) {
switch (type){
    case R.id.rb_p2p:
        layout_p2p.setVisibility(View.VISIBLE);
    layout_funds.setVisibility(View.GONE);
        break;
    case R.id.rb_funds:
        layout_p2p.setVisibility(View.GONE);
        layout_funds.setVisibility(View.VISIBLE);
        break;
    case R.id.rb_other:
        layout_p2p.setVisibility(View.GONE);
        layout_funds.setVisibility(View.GONE);
        break;
}

    }

    @Override
    public void showPlatformList(List<Platform> pfLists) {

    }

    @Override
    public void setPlatform(Platform platform) {

    }

    @Override
    public void gotoP2PPfAct() {

    }

    @Override
    public void setIncome(double income) {

    }

    @Override
    public void setPresenter(AddInvestContract.Presenter presenter) {

    }
}
