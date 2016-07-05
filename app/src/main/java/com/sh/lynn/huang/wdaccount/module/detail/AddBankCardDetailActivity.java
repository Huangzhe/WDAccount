package com.sh.lynn.huang.wdaccount.module.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.adapter.BankCardAdapter;
import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.been.BankCardRecord;
import com.sh.lynn.huang.wdaccount.utils.PopupHelper;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddBankCardDetailActivity extends AppCompatActivity implements AddBankCardDetailContract.View {

    @Bind(R.id.tv_checkBankCard)
    TextView tv_checkBankCard;

    @Bind(R.id.et_money)
    EditText et_money;

    @Bind(R.id.et_desc)
    EditText et_desc;

    private BankCardAdapter bankCardAdapter;
    private AddBankCardDetailContract.Presenter mPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_add_bank_card_detail);
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
    }

    @Override
    public void setBankCard(String bankCard) {

        tv_checkBankCard.setText(bankCard);
    }

    @Override
    public void showBankCardList() {
        List<BankCard> list =  mPresent.getBankCardList();

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
    public void setPresenter(AddBankCardDetailContract.Presenter presenter) {
        mPresent = presenter;
    }

    @OnClick(R.id.tv_checkBankCard)
    public void showBankList() {
        showBankCardList();

    }
    @OnClick(R.id.btn_bankCardSave)
    public void saveRecord() {

        BankCardRecord bankCardRecord = new BankCardRecord();
        bankCardRecord.setDescripe(et_desc.getText().toString());
        bankCardRecord.setMoney(et_money.getText().toString());
        bankCardRecord.setCardID(tv_checkBankCard.getText().toString());
        mPresent.saveBankCardRecord();
    }
}
