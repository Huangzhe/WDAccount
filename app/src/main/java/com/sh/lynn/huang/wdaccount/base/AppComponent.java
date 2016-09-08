package com.sh.lynn.huang.wdaccount.base;


import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
   // LoginComponent plus(LoginModule loginModule);
   // void inject(ActivityScope activity);
//    Context mctx();
//    PreferencesManager  preferencesManager();
}
