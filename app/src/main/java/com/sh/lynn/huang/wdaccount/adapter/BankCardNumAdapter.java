package com.sh.lynn.huang.wdaccount.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.been.BankCard;

import java.util.List;

/**
 * Created by hyz84 on 16/8/16.
 */
public class BankCardNumAdapter extends BaseAdapter {

    List<BankCard> list;
    Context mCtx;
    public BankCardNumAdapter(List<BankCard> data,Context ctx){
        list = data;
        mCtx=ctx;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView==null){
            holder = new ViewHolder();
            convertView = View.inflate(mCtx, R.layout.item_bankcard,null);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
           ;

        }
        holder.tv_bankCard = (TextView) convertView.findViewById(R.id.tv_bankCard);
        holder.tv_bankCard.setText(list.get(position).getBankName()+"   "+list.get(position).getCardNum());
        return convertView;
    }

    public static class ViewHolder {

        TextView tv_bankCard;
        public ViewHolder() {
        }


    }
}
