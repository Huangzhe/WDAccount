package com.sh.lynn.huang.wdaccount.data.investrecord;

import android.support.annotation.NonNull;

import com.sh.lynn.huang.wdaccount.been.InvestRecord;

import java.util.List;

import rx.Observable;

/**
 * Created by hyz84 on 16/7/25.
 */
public interface InvestRecordDataSource {

    Observable<List<InvestRecord>> getRecords();

    Observable<InvestRecord> getRecord(@NonNull Long recordId);

    void saveRecord(@NonNull InvestRecord record);

    void refreshRecords();

    void deleteAllRecords();

    void deleteRecord(@NonNull Long recordId);
}
