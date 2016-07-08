package com.sh.lynn.huang.wdaccount.data.bankcard;

import android.support.annotation.NonNull;

import com.sh.lynn.huang.wdaccount.been.BankCard;

import java.util.List;

import rx.Observable;

/**
 * Created by hyz84 on 16/7/8.
 */
public interface BankCardDataSource {
    Observable<List<BankCard>> getBankCards();

    Observable<BankCard> getBankCard(@NonNull String id);

    void saveBankCard(@NonNull BankCard task);

    void refreshBankCards();

    void deleteAllBankCards();

    void deleteBankCard(@NonNull String id);

}
