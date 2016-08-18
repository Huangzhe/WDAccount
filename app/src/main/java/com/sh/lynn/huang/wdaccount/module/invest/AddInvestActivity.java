package com.sh.lynn.huang.wdaccount.module.invest;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.adapter.BankCardNumAdapter;
import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.been.Platform;

import java.util.Calendar;
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
    @BindView(R.id.tv_investTime)
    TextView tv_investTime;

    @BindView(R.id.spinner_bankCard)
    Spinner spinner_bankCard;
    @BindView(R.id.layout_p2p)
    View layout_p2p;
    @BindView(R.id.layout_funds)
    View layout_funds;
    AddInvestPresenter mPresenter;

    private int year, monthOfYear, dayOfMonth;

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

        spinner_bankCard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        tv_investTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.showDateDialog();
            }
        });
    }





    @Override
    public void showBankCardList(List<BankCard> bankCardRecords) {

        spinner_bankCard.setAdapter(new BankCardNumAdapter( bankCardRecords,this));


    }

    @Override
    public void showDateDialog() {

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        monthOfYear = calendar.get(Calendar.MONTH);

        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mPresenter.setDate(year,monthOfYear,dayOfMonth);
            }
        },year,monthOfYear,dayOfMonth);

        dialog.show();

    }

    @Override
    public void showExtendView(int type) {
        switch (type) {
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
    public void setDate(int year, int month, int day) {
      String mth="";
        String d="";

        if((month+1)<10){
            mth = "0"+(month+1);
        }else{
            mth = (month+1)+"";
        }
        if(day<10){
            d = "0"+day;
        }else{
            d = day+"";
        }
        tv_investTime.setText(year+"-"+mth+"-"+d);
    }

    @Override
    public void setPresenter(AddInvestContract.Presenter presenter) {


    }


}
