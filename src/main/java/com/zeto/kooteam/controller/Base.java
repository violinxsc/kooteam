package com.zeto.kooteam.controller;

import com.zeto.ZenResult;
import com.zeto.domain.ZenUser;

public class Base {
    private static final String rootError = "只有管理员才能执行该操作";
    private static final String rootName = "root";

    public ZenResult checkRoot(ZenUser user) {
        if (user == null || !user.getUsername().equals(rootName)) {
            return ZenResult.fail(rootError);
        }
        return null;
    }
}
