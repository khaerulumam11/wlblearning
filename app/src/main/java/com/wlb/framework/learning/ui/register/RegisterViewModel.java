/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.wlb.framework.learning.ui.register;

import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import com.wlb.framework.learning.BR;
import com.wlb.framework.learning.R;
import com.wlb.framework.learning.data.DataManager;
import com.wlb.framework.learning.data.model.api.LoginRequest;
import com.wlb.framework.learning.data.model.api.wlb.register.RegisterRequest;
import com.wlb.framework.learning.ui.base.BaseViewModel;
import com.wlb.framework.learning.utils.CommonUtils;
import com.wlb.framework.learning.utils.rx.SchedulerProvider;

/**
 * Created by MHBX on 08/03/19.
 */
public class RegisterViewModel extends BaseViewModel<RegisterNavigator> {
    public RegisterViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void excuteRegister() {
        getNavigator().FormValidation();
    }
    public void openLoginMenu() {
        getNavigator().oPenlogin();
    }

    public void Register(String email, String password, String username) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doServerRegisterWLBApiCall(new RegisterRequest(username, email, password))
                .doOnSuccess(response ->
                        Log.d("On Success",response.getEmail())
                )
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    Log.d("On Register", "Berhasil");
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public boolean isEmailValid(String email) {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false;
        }
        return true;
    }
}
