package com.sh.lynn.huang.wdaccount.module.invest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sh.lynn.huang.wdaccount.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddInvestActivity extends AppCompatActivity {


    @Bind(R.id.rg_investType)
    RadioGroup rg_investType;
    @Bind(R.id.tv_checksource)
    TextView tv_checksource;
    @Bind(R.id.et_investmoney)
    EditText et_investmoney;
    @Bind(R.id.et_investTarget)
    EditText et_investTarget;
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


    }
}
