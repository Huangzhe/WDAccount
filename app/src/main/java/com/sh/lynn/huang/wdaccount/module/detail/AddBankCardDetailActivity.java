package com.sh.lynn.huang.wdaccount.module.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.adapter.BankCardAdapter;
import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.been.BankCardRecord;
import com.sh.lynn.huang.wdaccount.utils.PopupHelper;

import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

public class AddBankCardDetailActivity extends AppCompatActivity implements AddBankCardDetailContract.View {

    @Bind(R.id.tv_checkBankCard)
    TextView tv_checkBankCard;

    @Bind(R.id.et_money)
    EditText et_money;

    @Bind(R.id.et_desc)
    EditText et_desc;
    @Bind(R.id.rg_type)
    RadioGroup rg_type;

    int type=0;//0收入 -1支出
    private BankCardAdapter bankCardAdapter;
    private AddBankCardDetailContract.Presenter mPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank_card_detail);
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
        mPresent = new DetailPresenter(this);
        rg_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_income:
                        type=0;
                        break;
                    case R.id.rb_pay:
                        type=1;
                        break;
                }
            }
        });
    }

    @Override
    public void setBankCard(String bankCard) {
        tv_checkBankCard.setText(bankCard);
    }

    @Override
    public void showBankCardList(List<BankCard> list) {
       // List<BankCard> list =  mPresent.getBankCardList();

        PopupWindow popupWindow =  PopupHelper.newBasicPopupWindow(this);
        View view = View.inflate(this,R.layout.item_bankcard_pop,null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bankCardAdapter = new BankCardAdapter(list);
        recyclerView.setAdapter(bankCardAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        popupWindow.showAsDropDown(tv_checkBankCard);

    }

    @Override
    public void setPresenter(@NonNull AddBankCardDetailContract.Presenter presenter) {
        mPresent = presenter;
    }

    @OnClick(R.id.tv_checkBankCard)
    public void showBankList() {
        //showBankCardList();
        mPresent.getBankCardList();
    }
    @OnClick(R.id.btn_bankCardSave)
    public void saveRecord() {        ;

        BankCardRecord bankCardRecord = new BankCardRecord();
        bankCardRecord.setDescripe(et_desc.getText().toString());
        bankCardRecord.setMoney(checkNotNull(et_money.getText().toString(), "金额不能为空!"));
        bankCardRecord.setCardID(checkNotNull(et_money.getText().toString(), "银行卡不能为空!"));
        bankCardRecord.setType(type);
        bankCardRecord.setTime(new Date());
        mPresent.saveBankCardRecord(bankCardRecord);
    }
}
