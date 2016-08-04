package com.sh.lynn.huang.wdaccount.module.bankcard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sh.lynn.huang.wdaccount.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hyz84 on 16/8/2.
 */
public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder> {

    AddBankcardPresenter mPresenter;
    int mId;
    int[] data =new int[31];
    public DateAdapter(AddBankcardPresenter presenter,int id){
        mPresenter = presenter;
        mId = id;
        for(int x=0;x<data.length;x++){
            data[x]=x+1;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(View.inflate(parent.getContext(),R.layout.item_textview,null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_num)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.setDate(Integer.parseInt(textView.getText().toString()),mId);

                }
            });
        }
    }
}
