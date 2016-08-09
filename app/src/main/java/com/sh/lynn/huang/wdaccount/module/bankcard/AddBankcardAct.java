package com.sh.lynn.huang.wdaccount.module.bankcard;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.been.BankCard;
import com.sh.lynn.huang.wdaccount.utils.DividerItemDecoration;
import com.sh.lynn.huang.wdaccount.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddBankcardAct extends AppCompatActivity implements AddBankcardContract.View {
    @BindView(R.id.ll_returnTime)
    LinearLayout ll_returnTime;

    @BindView(R.id.ll_accountTime)
    LinearLayout ll_accountTime;

  @BindView(R.id.spinner_bankName)
  Spinner spinner;

    @BindView(R.id.et_bankcard)
    EditText et_bankcard;

    @BindView(R.id.et_initMoney)
    EditText et_initMoney;
    @BindView(R.id.rg_bankcardType)
    RadioGroup rg_bankcardType;
    AddBankcardContract.Presenter mPresenter;

    @BindView(R.id.rb_creditCard)
    RadioButton rb_creditCard;
    @BindView(R.id.rb_deditCard)
    RadioButton rb_deditCard;

    @BindView(R.id.tv_date1)
            TextView tv_date1;
    @BindView(R.id.tv_date2)
    TextView tv_date2;

    AlertDialog dateDialog;
@BindView(R.id.parentLayout)
    CoordinatorLayout parentlayout;
    int date1=0;
    int date2=0;
String bankName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bankcard);
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

        rg_bankcardType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_creditCard://信用卡
                        mPresenter.setCardType(0);
                        break;
                    case R.id.rb_deditCard://借记卡
                        mPresenter.setCardType(1);
                        break;
                }
            }
        });
       // spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.item_textview, BankName.getBankName()));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bankName = getResources().getStringArray(R.array.bankNames)[position];
                ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mPresenter = new AddBankcardPresenter(this);
    }


    @Override
    public void showCreditCardContent(boolean isShow) {

        if (isShow) {
            ll_returnTime.setVisibility(View.VISIBLE);
            ll_accountTime.setVisibility(View.VISIBLE);
        } else {
            ll_returnTime.setVisibility(View.GONE);
            ll_accountTime.setVisibility(View.GONE);
        }
    }

    @Override
    public void showDateDialog(boolean isShow,int id) {
        if (isShow) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = View.inflate(this, R.layout.item_days, null);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            recyclerView.setAdapter(new DateAdapter((AddBankcardPresenter) mPresenter,id));

            GridLayoutManager layoutManager = new GridLayoutManager(this, 6);
            recyclerView.setLayoutManager(layoutManager);

            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST|DividerItemDecoration.VERTICAL_LIST));


            builder.setView(view);
            dateDialog = builder.create();
            dateDialog.show();
        } else {
            if (dateDialog != null && dateDialog.isShowing()) {
                dateDialog.dismiss();
            }
        }
    }

    @Override
    public void setDateText(int date, int id) {

        switch (id){
            case R.id.tv_date1:
                tv_date1.setText("每月"+date+"日");
                date1 = date;
                break;
            case R.id.tv_date2:
                tv_date2.setText("每月"+date+"日");
                date2=date;
                break;
        }

    }

    @OnClick({ R.id.tv_date1, R.id.tv_date2, R.id.btn_save })
    public void viewOnClick(View view) {
        switch (view.getId()) {
            case R.id.tv_date1:
                showDateDialog(true,R.id.tv_date1);
                break;
            case R.id.tv_date2:
                showDateDialog(true,R.id.tv_date2);
                break;

            case R.id.btn_save:

                BankCard bankCard = new BankCard();

                //String bankName = tv_bankName.getText().toString();
                if (TextUtils.isEmpty(bankName)||"请选择".equals(bankName)) {
                    MyToast.showToast(this,"发卡行名称不能为空!");
                    return;
                }

                String cardNo = et_bankcard.getText().toString();
                String money = et_initMoney.getText().toString();
                if (TextUtils.isEmpty(cardNo)) {
                    et_bankcard.setError("卡号不能为空！");
                    return;
                }
                bankCard.setBankName(bankName);
                bankCard.setCardNum(cardNo);
                bankCard.setMoney(money);
                if (rb_creditCard.isChecked()) {
                    bankCard.setCardType(0);//信用卡
                } else {
                    bankCard.setCardType(1);//储蓄卡
                }
                bankCard.setBillDate(date1);
                bankCard.setRepaymentDate(date2);

                mPresenter.saveBankcard(bankCard);

                break;
        }
    }

@Override
    public void clearText(long saveRet){
        String snakBarText = "";
        if(saveRet!=-1){
            et_bankcard.setText("");
            et_initMoney.setText("");
            spinner.setSelection(0,true);
            snakBarText="保存成功";
        }else{
            snakBarText="保存失败";
        }



        Snackbar.make(parentlayout,snakBarText,Snackbar.LENGTH_LONG).setAction("退出", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }).show();
    }

    @Override
    public void setPresenter(AddBankcardContract.Presenter presenter) {

    }
}
