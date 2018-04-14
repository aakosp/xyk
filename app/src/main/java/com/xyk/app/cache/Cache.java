package com.xyk.app.cache;

import com.xyk.app.domian.Admin;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private Cache() {
        //no instance
    }

    private static Map<String, Admin> admins = new ConcurrentHashMap<>(2);

    public static boolean checkAdmin(String sessionKey) {
        if (!StringUtils.isEmpty(sessionKey) && admins.containsKey(sessionKey)) {
            return true;
        }
        return false;
    }
}
