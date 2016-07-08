package com.sh.lynn.huang.wdaccount.data.bankcardrecord;

import android.support.annotation.NonNull;

import com.sh.lynn.huang.wdaccount.been.BankCardRecord;

import java.util.List;

import rx.Observable;

/**
 * Created by hyz84 on 16/7/7.
 */
public interface BankCardRecordDataSource {

    Observable<List<BankCardRecord>> getRecords();

    Observable<BankCardRecord> getRecord(@NonNull String taskId);

    void saveRecord(@NonNull BankCardRecord task);

    void refreshRecords();

    void deleteAllRecords();

    void deleteRecord(@NonNull String recordId);
}
