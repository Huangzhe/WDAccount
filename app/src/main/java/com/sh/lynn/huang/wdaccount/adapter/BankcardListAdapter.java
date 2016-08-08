package com.sh.lynn.huang.wdaccount.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.been.BankCard;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hyz84 on 16/8/8.
 */
public class BankcardListAdapter extends RecyclerView.Adapter<BankcardListAdapter.ViewHolder> {
    List<BankCard> mData;

    public BankcardListAdapter( List<BankCard> list){
        mData = list;
    }
    @Override
    public BankcardListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bankcard_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BankcardListAdapter.ViewHolder holder, int position) {
        holder.tv_bankName.setText(mData.get(position).getBankName());
        holder.tv_cardType.setText(mData.get(position).getCardType()==0?"信用卡":"储蓄卡");
        holder.tv_cardNo.setText("银行卡尾号："+mData.get(position).getCardNum());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_bankName)
        TextView tv_bankName;
        @BindView(R.id.tv_cardType)
        TextView tv_cardType;
        @BindView(R.id.tv_cardNo)
        TextView tv_cardNo;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }


    }
}
