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

package com.wlb.framework.learning.utils;

/**
 * Created by WlbTeam on 07/07/17.
 */

public final class ManipulateUtils {

    private ManipulateUtils() {
        // This class is not publicly instantiable
    }

    public static String addRp(String currency) {
//        String[] toConvert = currency.split(".");
        StringBuilder str = new StringBuilder(currency);
        int i = str.length() - 3;
        while (i > 0) {
            str.insert(i, ".");
            i -= 3;
        }
        return "Rp " + str.toString();
    }

}
