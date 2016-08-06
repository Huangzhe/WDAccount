package com.sh.lynn.huang.wdaccount.module.bankcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.been.BankCard;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BankCardListActivity extends AppCompatActivity implements BankCardListContract.View {

    @BindView(R.id.recyclerView_bankCard)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;


    BankCardListContract.Presenter bankCardPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_card_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bankCardPresenter = new BankCardPresenter(this);
        bankCardPresenter.getBankCardList();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAddBankCardAct();
            }
        });
    }



    @Override
    public void showList(List<BankCard> list) {

    }

    @Override
    public void gotoAddBankCardAct() {

        Intent intent = new Intent(this,AddBankcardAct.class);
        startActivity(intent);
    }

    @Override
    public void setPresenter(BankCardListContract.Presenter presenter) {
        bankCardPresenter = presenter;
    }
}
