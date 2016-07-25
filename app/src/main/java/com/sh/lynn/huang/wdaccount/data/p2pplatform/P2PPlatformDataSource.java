package com.sh.lynn.huang.wdaccount.data.p2pplatform;

import android.support.annotation.NonNull;

import com.sh.lynn.huang.wdaccount.been.Platform;

import java.util.List;

import rx.Observable;

/**
 * Created by hyz84 on 16/7/25.
 */
public interface P2PPlatformDataSource  {

    Observable<List<Platform>> getPlatforms();

    Observable<Platform> getPlatform(@NonNull String id);

    void savePlatform(@NonNull Platform pf);

    void refreshPlatforms();

    void deleteAllPfs();

    void deletePlatform(@NonNull Long id);
}
